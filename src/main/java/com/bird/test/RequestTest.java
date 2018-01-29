package com.bird.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * author: 牛虻.
 * time:2018/1/29
 * email:pettygadfly@gmail.com
 * doc:
 */
public class RequestTest {

    public static void main(String[] args) {
        RequestTest.muliQuery();
    }

    //多线程请求测试，看是否有错误
    public static void muliQuery() {

        for (int i = 0; i < 400; i++) {
            new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {

                            Thread.sleep(1000);

                            DefaultHttpClient httpclient = new DefaultHttpClient();
                            httpclient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
                            HttpPost httpost = new HttpPost("http://localhost:8080/webinter/registerUser");
                            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                            nvps.add(new BasicNameValuePair("uuid", "asdfasdf"));
                            nvps.add(new BasicNameValuePair("gold", "99"));
                            nvps.add(new BasicNameValuePair("name", "password"));
                            nvps.add(new BasicNameValuePair("password", "password"));
                            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
                            HttpResponse response = httpclient.execute(httpost);
                            HttpEntity entity = response.getEntity();
                            String result = EntityUtils.toString(entity, "utf-8");
                            System.out.println(Thread.currentThread().getName() + ":" + result);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        } catch (ClientProtocolException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }).start();
        }
    }

}
