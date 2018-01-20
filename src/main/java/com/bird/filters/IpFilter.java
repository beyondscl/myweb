package com.bird.filters;

/**
 * author: 牛虻.
 * time:2018/1/20 0020
 * email:pettygadfly@gmail.com
 * doc:
 */
public class IpFilter {
    public static boolean checkIp(String ip) {
        return true;
    }

    public static void addUnIllegalIp(String ip) {
    }

    public static void removeUnIllegalIp(String ip) {
    }

    /**
     * 对服务降级，是否所有ip,ip 段不允许登录
     */
    public static boolean isIllegal() {
        return true;
    }

    public static void setIllegal(boolean f) {
    }
}
