package com.mainacad.util;

import org.apache.commons.codec.digest.DigestUtils;

public class TestUtil {

    public static void main(String[] args) {
        String pass = "123456789";
        String encodedPass = DigestUtils.md5Hex(pass);
        System.out.println(encodedPass);
    }
}
