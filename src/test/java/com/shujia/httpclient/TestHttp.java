package com.shujia.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

public class TestHttp {
    /**
     * junit  用于测试的工具
     * 可以不写main方法
     *
     */
    @Test
    public void test1(){
        System.out.println("junit。。。");
    }
    @Test
    public void test2() throws IOException {
        //创建一个http请求发起对象，相当于一个缩小版的浏览器
        DefaultHttpClient httpClient = new DefaultHttpClient();

        //创建一个请求
        HttpGet httpGet = new HttpGet("https://www.sojson.com/open/api/weather/json.shtml?city=北京");
        //httpGet.addHeader("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");

        //发起请求
        HttpResponse execute = httpClient.execute(httpGet);

        //获取请求响应状态码
        /**
         * 200---成功
         * 300---请求重定向
         * 400---网页找不到
         * 500---服务器发生异常
         *
         */
        int statusCode = execute.getStatusLine().getStatusCode();

        System.out.println(statusCode);
        if (statusCode==200){
            //获取响应的数据
            HttpEntity entity = execute.getEntity();
            //将响应对象转成字符串
            String strResult = EntityUtils.toString(entity);

            System.out.println(strResult);
        }


    }
}
