<template>
    <div>
        单文件组件组成部分由三部分组成：模板，script，style三个部分
    </div>
</template>

<script>
// 使用export default将vue组件暴露出去，别的文件就可以引入使用了
export default {
    data(){
        return {
            msg: "单文件组件中的数据"
        }
    },
    methods:{
        save:function(){
            console.log("这是单文件组件的方法");
        }
    }
}
</script>

<style scoped>
/* 单文件组件的样式表 */
</style>
