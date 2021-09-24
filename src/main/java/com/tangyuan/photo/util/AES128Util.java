package com.tangyuan.photo.util;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AES128Util {
    public static final String KEY_WORD = "gGeSUnh1k5JKjl7W";

    public static Key createKey() {
        try {
            // 生成key
            KeyGenerator keyGenerator;
            //构造密钥生成器，指定为AES算法,不区分大小写
            keyGenerator = KeyGenerator.getInstance("AES");
            //生成一个128位的随机源,根据传入的字节数组
            keyGenerator.init(128);
            //产生原始对称密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //获得原始对称密钥的字节数组
            byte[] keyBytes = secretKey.getEncoded();
            // key转换,根据字节数组生成AES密钥
            Key key = new SecretKeySpec(keyBytes, "AES");
            return key;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Key getKey(String keyWord) {
        return new SecretKeySpec(keyWord.getBytes(StandardCharsets.UTF_8), "AES");
    }

    public static String jdkAES(String context, String keyWord) {
        return jdkAES(context, getKey(keyWord));
    }

    private static String jdkAES(String context, Key key) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            //将加密并编码后的内容解码成字节数组
            byte[] result = cipher.doFinal(context.getBytes());
            return parseByte2HexStr(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String result, String keyWord) {
        return decrypt(parseHexStr2Byte(result), getKey(keyWord));
    }

    private static String decrypt(byte[] result, Key key) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(result);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    public static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) {
        String content = "admin123";
        String password = "gGeSUnh1k5JKjl7W";
        //加密
        System.out.println("加密前：" + content);
        String encryptResultStr = jdkAES(content, password);
        System.out.println("加密后：" + encryptResultStr);
        //解密
        String decryptResult = decrypt(encryptResultStr, password);
        System.out.println("解密后：" + decryptResult);
    }
}
