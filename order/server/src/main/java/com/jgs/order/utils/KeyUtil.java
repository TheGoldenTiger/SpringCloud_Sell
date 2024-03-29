package com.imooc.order.utils;

import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * 生成唯一主键
 * 格式：时间+随机数
 */
public class KeyUtil {
    public static synchronized String genUniqueKey(){
        Random random=new Random();
        Integer number=random.nextInt(900000)+(100000);
        return System.currentTimeMillis()+ String.valueOf(number);
    }
}
