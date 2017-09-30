package com.glemontree.mybatis.utils;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

public class Utils {
    public static String md5(String pass){
        String saltSource = "blog";
        String hashAlgorithmName = "MD5";
        Object salt = new Md5Hash(saltSource);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, pass, salt, hashIterations);
        String password = result.toString();
        return password;
    }
}
