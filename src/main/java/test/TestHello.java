package test;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;
import java.util.Calendar;

/**
 * author: 牛虻.
 * time:2017/11/11
 * email:pettygadfly@gmail.com
 * doc:
 */
public class TestHello {

    @Test
    public void sayHello() {
        System.out.println(Calendar.getInstance().getTime());
        Assert.assertNotNull(null);
    }

    @Test
    public void getApplicatioContext() {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml").getBeanFactory();
    }

    @Test
    public void testClassLoader() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        ClassLoader classLoader = Thread.currentThread().getClass().getClassLoader();
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class classt = classLoader.loadClass(TestReflect.class.getName());
//        classt.getDeclared**//获取全部信息，但是不包含父类的
        TestReflect testReflect = (TestReflect) classt.newInstance();

    }
}
