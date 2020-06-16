package cn.itcast.travel.util;

import cn.itcast.travel.domain.ResultInfo;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class sometest {
    public static void main(String[] args) {
        //  将对象序列化为json的功能
        // jsonToObject();
        jsonToObject();

        // 将对象序列化为json字符串
        // objectToJson();
    }

    public static void jsonToObject() {
        System.out.println("将json字符串转化为对象");
        String jsonstr = "{\"errorMsg\":\"注册失败\",\"flag\":false}";
        // 将json字符串转成java对象，使用json的parseObject方法
        // JSONObject jsonObject = JSONObject.parseObject(jsonstr);
        ResultInfo resultInfo = JSONObject.parseObject(jsonstr, ResultInfo.class);

        // System.out.println(jsonObject.get("flag"));
        System.out.println(resultInfo.getErrorMsg());
    }

    public static void objectToJson(){
        System.out.println("将对象转成json字符串");
        ResultInfo info = new ResultInfo();
        info.setFlag(false);
        info.setErrorMsg("注册失败");
        // 将对象转成json字符串超简单
        String s = JSONObject.toJSONString(info);
        System.out.println(s);

    }
}
