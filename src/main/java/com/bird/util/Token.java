package com.bird.util;

import com.bird.domain.User;
import org.joda.time.DateTime;
import org.json.simple.JSONObject;
import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


/**
 * author: 牛虻.
 * time:2018/1/18
 * email:pettygadfly@gmail.com
 * doc:
 * 获取token,解决的问题是session和cookies的问题，而不是安全性的问题
 */
public class Token {
    private static String secret = "TJVA95OrM7E2cBab30RMHrH";//加密key
    private static String sign = "HmacSHA256";//加密方式
    private static String encodeType = "UTF-8";//编码方式

    private static String getHeader() {
        JSONObject h = new JSONObject();
        h.put("typ", "JWT");
        h.put("alg", "HS256");
        return new String(Base64Utils.encode(h.toJSONString().getBytes()));
    }

    /**
     * 请存放非敏感信息
     *
     * @return
     */
    private static String getPlayload(User user) {
        JSONObject h = new JSONObject();
        h.put("iss", "");
        h.put("aud", "");
        h.put("nbf", "");
        h.put("iat", DateTime.now());//签发时间
        h.put("jti", "");
        h.put("uid", user.getId());
        h.put("uname", user.getName());
//        h.put("uip", "127.0.0.1");//是否考虑换浏览器
        h.put("exp", "600");//有效时间秒

        return new String(Base64Utils.encode(h.toJSONString().getBytes()));
    }

    private static String getSignature(String header, String playLoad) {
        try {
            String h = URLEncoder.encode(header, encodeType);
            String p = URLEncoder.encode(playLoad, encodeType);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), sign);
            Mac mac = Mac.getInstance(sign);
            mac.init(secretKeySpec);
            return byte2hex(mac.doFinal((h + "." + p).getBytes()));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String byte2hex(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b != null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1)
                hs.append('0');
            hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    public static String getToken(User user) {
        String h = getHeader();
        String p = getPlayload(user);
        String sign = getSignature(h, p);
        return h + "." + p + "." + sign;
    }

    public static boolean authToken(String token) {
        try {
            String[] s = token.split("\\.");
            if (null == s || s.length != 3) {
                throw new RuntimeException("illegality token!");
            }
            if (getSignature(s[0], s[1]).equals(s[2])) {//确保数据没有被篡改
                String h = URLDecoder.decode(s[0], encodeType);
                h = new String(Base64Utils.decode(h.getBytes()));
                String p = URLDecoder.decode(s[1], encodeType);
                p = new String(Base64Utils.decode(p.getBytes()));
                //有效期等判断省略
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

}
