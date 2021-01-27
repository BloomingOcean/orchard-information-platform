package com.liyang.orchard.service;

public interface SmsService {
    /**
     * 发送短信
     * @param iphoneNumber 电话号码
     * @return
     */
    boolean sendSms(String iphoneNumber);
}
