package com.mainacad.util;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordUtil {

    private static final String KEY = "klzkjdfghxmfsgvrgikh";

    public static String encodePassword(String pass) {
        return KEY + DigestUtils.md5Hex(pass);
    }
                                        // magic           // 123456
    public static boolean isAnable(String passInDB, String inputPass) {
        String encodedinputPass = encodePassword(inputPass);
        return encodedinputPass.equals(passInDB);
    }
}
