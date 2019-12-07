package com.xuecheng.auth;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @version 1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //创建jwt令牌
    @Test
    public void testRedis(){
        //定义key
        String key = "b042e6e9-70d3-46bd-b973-fa08595efb71";
        //定义value
        Map<String,String> value = new HashMap<>();
        value.put("jwt","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6IlhjV2ViQXBwIiwic2NvcGUiOlsiYXBwIl0sIm5hbWUiOm51bGwsInV0eXBlIjpudWxsLCJpZCI6bnVsbCwiZXhwIjoxNTcwNTc5NTE2LCJqdGkiOiJiMDQyZTZlOS03MGQzLTQ2YmQtYjk3My1mYTA4NTk1ZWZiNzEiLCJjbGllbnRfaWQiOiJYY1dlYkFwcCJ9.R-l9MCwKloO16dR3SR8b5IiJIHXGuff1Y0m4td1xDBYLHiAKTXAhat0TBQTfRPYBdEdxyJ-IHMkSTglSKgEqofj2kpCQdiBa-a_Av8h4jBJHb7l8VmOyxCHP_p7qk_b0Exsj9KQdGXZS4-Q4w8ZO_dFknzF313i6WPM1cjPBNuSRNl-hU__ECuIUbww_N_p2XlaYdMVkzOwK5nPw6r6maK1l8XZ328h-H1e7JXhrIfpLyB0GxYbRXg_7wxm5yhfcp5aNdsHvTamaijHFV2q4euJh7bA0FYO3Hxs27ANI4wW-p6wH71V8hJzxi344C23Nl2hf4s-wdQg1T4DQFnkMnw");
        value.put("refresh_token","eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJjb21wYW55SWQiOm51bGwsInVzZXJwaWMiOm51bGwsInVzZXJfbmFtZSI6IlhjV2ViQXBwIiwic2NvcGUiOlsiYXBwIl0sImF0aSI6ImIwNDJlNmU5LTcwZDMtNDZiZC1iOTczLWZhMDg1OTVlZmI3MSIsIm5hbWUiOm51bGwsInV0eXBlIjpudWxsLCJpZCI6bnVsbCwiZXhwIjoxNTcwNTc2NjU2LCJqdGkiOiIwNjAyY2ZjNy04YmFjLTQ1ODAtYjU1My0yNDIyZWU3NzJhZTIiLCJjbGllbnRfaWQiOiJYY1dlYkFwcCJ9.ci1ZPw2ChMHUyDHkRnQOrwFVNqmMf9hzdxw5IoUawYER-7fAVsrBfE0V8-KzfPjSi0FfE5IO-3RHGHm2vSBBLHgLMqSiJX25MmpSvN9rJ1OP9spVTHn7ceZU8-bIeVWvP6OUGdfsiysgRrw3qPdH7EH69QQ3VYdJqGzzbqwUbShvRGguwInMdq3ZfZRgN7kU0FMYL-geUwjMPpuzFbk0_HVD5-sdGPHNVGFVKbMramsFGk7Cqg_ci3p4_rt54GNd0H15gzGg8eckEf69i69nbzlUhYi749OP--96CbwVk8ETGsjevELPWj-XiwlrnU6iidJW5QN1MhDzY2u9J60hMQ");
        String jsonString = JSON.toJSONString(value);
        //校验key是否存在，如果不存在则返回-2
        Long expire = stringRedisTemplate.getExpire(key, TimeUnit.SECONDS);
        System.out.println(expire);
        //存储数据
        stringRedisTemplate.boundValueOps(key).set(jsonString,30, TimeUnit.SECONDS);
        //获取数据
        String string = stringRedisTemplate.opsForValue().get(key);
        System.out.println(string);


    }


}
