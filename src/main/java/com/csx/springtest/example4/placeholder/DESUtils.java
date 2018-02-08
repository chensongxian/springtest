package com.csx.springtest.example4.placeholder;

import com.mysql.jdbc.util.Base64Decoder;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.io.IOException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/08
 */
public class DESUtils {
    private static Key key;
    private static String KEY_STR="myKey";

    static {
        try {
            KeyGenerator generator=KeyGenerator.getInstance("DES");
            generator.init(new SecureRandom(KEY_STR.getBytes()));
            key=generator.generateKey();
            generator=null;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     * @param str
     * @return
     */
    public static String getEncryptString(String str){
        BASE64Encoder base64Encoder=new BASE64Encoder();
        try {
            byte[] strBytes = str.getBytes("UTF-8");
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] encryptStr = cipher.doFinal(strBytes);
            return base64Encoder.encode(encryptStr);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 解密
     * @param str
     * @return
     */
    public static String getDecryptString(String str){
        BASE64Decoder decoder=new BASE64Decoder();

        try {
            byte[] strBytes=decoder.decodeBuffer(str);
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] decryptStr=cipher.doFinal(strBytes);
            return new String(decryptStr,"UTF-8");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        String str="test";

        String encryptStr=getEncryptString(str);
        System.out.println("加密:"+encryptStr);

        String decryptStr=getDecryptString(encryptStr);
        System.out.println("解密:"+decryptStr);

    }
}
