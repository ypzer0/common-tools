package com.example.docking;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DockingApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://47.75.155.53:8615/ZTGJInterfaceServer/ztserver/tabOrderBill/orderBillZT");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("data","{\n" +
                "\t\t\"tradeNo\": \"111123\",\n" +
                "\t\t\"accpetName\": \"123\",\n" +
                "\t\t\"accpetAddress\": \"123\",\n" +
                "\t\t\"accpetCountry\": \"123\",\n" +
                "\t\t\"accpetProv\": \"123\",\n" +
                "\t\t\"accpetCity\": \"1\",\n" +
                "\t\t\"sendName\": \"123\",\n" +
                "\t\t\"sendAddress\": \"123\",\n" +
                "\t\t\"sendCountry\": \"123\",\n" +
                "\t\t\"sendProv\": \"123\",\n" +
                "\t\t\"sendCity\": \"123\",\n" +
                "\t\t\"goodName\": \"123\"\n" +
                "\t}"));
        nvps.add(new BasicNameValuePair("digest","7A9FFE603CE67EB868BC80C4418B5749"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps,"utf-8"));
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        if(entity!=null) {
            String str = new String(EntityUtils.toString(entity));
            System.out.println(str);
        }
    }

    @Test
    public void test() throws UnsupportedEncodingException {
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("data","{\n" +
                "\t\t\"tradeNo\": \"111123\",\n" +
                "\t\t\"accpetName\": \"123\",\n" +
                "\t\t\"accpetAddress\": \"123\",\n" +
                "\t\t\"accpetCountry\": \"123\",\n" +
                "\t\t\"accpetProv\": \"123\",\n" +
                "\t\t\"accpetCity\": \"1\",\n" +
                "\t\t\"sendName\": \"123\",\n" +
                "\t\t\"sendAddress\": \"123\",\n" +
                "\t\t\"sendCountry\": \"123\",\n" +
                "\t\t\"sendProv\": \"123\",\n" +
                "\t\t\"sendCity\": \"123\",\n" +
                "\t\t\"goodName\": \"123\"\n" +
                "\t}"));
        nvps.add(new BasicNameValuePair("digest","064ADE0C49891050B3"));
        UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nvps, "utf-8");


    }

}
