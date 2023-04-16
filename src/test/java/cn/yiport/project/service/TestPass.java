package cn.yiport.project.service;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.digest.DigestUtil;
import org.springframework.util.DigestUtils;

import java.util.Scanner;


public class TestPass {    private static final String SALT = "yiport";
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String pa = sc.next();
        String pass = DigestUtils.md5DigestAsHex((SALT + pa).getBytes());
        System.out.println("passwd:"+pass);
        String userAccount = sc.next();
        String accessKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(5));
        String secretKey = DigestUtil.md5Hex(SALT + userAccount + RandomUtil.randomNumbers(8));
        System.out.println("ak:"+accessKey+"   sk:"+secretKey);
    }
}
