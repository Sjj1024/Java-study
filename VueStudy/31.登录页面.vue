<template>
  <div class="login_container">
    <div class="login_box">
      <div class="avatar_box">
        <img src="../assets/logo.png" alt />
      </div>
      <el-form ref="formRef" :model="form" :rules="rules" label-width="80px" class="login_form">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" prefix-icon="el-icon-user-solid"></el-input>
        </el-form-item>
        <el-form-item label="密  码" prop="password">
          <el-input
            v-model="form.password"
            show-password
            type="password"
            prefix-icon="el-icon-s-finance"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="loginForm">登 录</el-button>
          <el-button type="info" @click="resetForm">重 置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      form: {
        username: "",
        password: ""
      },
      remeberBox: [1, 2],
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" },
          { min: 1, max: 10, message: "长度在 1 到 10 个字符", trigger: "blur" }
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 20, message: "长度在 1 到 20 个字符", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    resetForm() {
      this.$refs.formRef.resetFields();
    },
    loginForm() {
      // 将用户名和密码通过cookie传递过去的
      //   var value = this.$cookies.isKey("username");
      //   if (value) {
      //     this.$cookies.remove("JSESSIONID");
      //     this.$cookies.remove("username");
      //   }
      //   // 判断是否记住密码
      //   if (this.remeberBox.length > 0) {
      //     this.$cookies.set("username", this.form.username, "7d");
      //     this.$cookies.set("password", this.form.password, "7d");
      //     this.$cookies.set("bit", "true", "7d");
      //   } else {
      //     this.$cookies.remove("username");
      //     this.$cookies.remove("bit");
      //     this.$cookies.remove("password");
      //   }
      // 发送登录请求
      this.startLogin();
    },
    startLogin() {
      this.$refs.formRef.validate(valid => {
        console.log(valid);
        if (!valid) return;
        let param = new URLSearchParams();
        param.append("username", this.form.username);
        param.append("password", this.form.password);
        console.log(param);
        this.$axios.post("doLogin", param).then(res => {
          console.log(res.data);
          if (res.data.msg == "success") {
            this.$message.success("登陆成功");
            // 将token存储在sessionStorage中，这个sessionStorage是会话存储机制，localhostStorage是持久存储机制
            window.sessionStorage.setItem("token", res.data.loginInfo.token);
            // 使用路由跳转机制，跳转到主页,发生页面跳转
            this.$router.push("/home");
          } else {
            this.$message.error("登录失败");
          }
        });
      });
    }
  }
};
</script>

<style scoped>
.login_container {
  background-color: #2b4b6b;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);
}

.avatar_box {
  width: 130px;
  height: 130px;
  border: 1px solid #ddd;
  border-radius: 50%;
  padding: 10px;
  box-shadow: 0 0 10px #ddd;
  position: absolute;
  left: 50%;
  transform: translate(-50%, -50%);
  background-color: #fff;
}

.avatar_box img {
  width: 100%;
  height: 100%;
  border-radius: 50%;
  background-color: #ddd;
}

.login_form {
  position: absolute;
  bottom: 0;
  width: 90%;
  right: 20px;
  left: 10px;
}
</style>
