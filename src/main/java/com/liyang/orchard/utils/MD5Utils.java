package com.liyang.orchard.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    // 固定盐值
    private static final String salt = "b3JjaGFyZA==";

    public static String inputPassToFormPass(String inputPass) {
        String str = inputPass + salt;
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = formPass  + salt;
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

}
