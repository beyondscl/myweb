package test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: 牛虻.
 * time:2018/1/22
 * email:pettygadfly@gmail.com
 * doc:
 */
public class RegTest {

    @Test
    public void regTest(){
        Pattern pattern = Pattern.compile("");
        Matcher matcher= pattern.matcher("");
        matcher.matches();
        String abc = "999999999".replaceAll("/()/g",",");
        System.out.println(abc);
    }
}
