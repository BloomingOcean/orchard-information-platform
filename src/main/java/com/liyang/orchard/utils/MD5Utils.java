package com.liyang.orchard.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    // 固定盐值e28d
    private static final String salt = "e52d78a4a598edd6";

    public static String inputPassToFormPass(String inputPass) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB) {
        String formPass = inputPassToFormPass(inputPass);
        String dbPass = formPassToDBPass(formPass, saltDB);
        return dbPass;
    }

}
