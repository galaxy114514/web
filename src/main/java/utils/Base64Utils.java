package utils;

import java.util.Base64;

public class Base64Utils {
    public static String encode(String src) {
        return Base64.getEncoder().encodeToString(src.getBytes());
    }
    public static String decode(String src){
        byte[] decode = Base64.getDecoder().decode(src);
        return new String(decode);
    }
}
