package utils;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie getCookie(String name,String value){
        Cookie cookie=new Cookie(name,value);
        cookie.setMaxAge(60*60*24);
        return cookie;
    }

    public static String getCookieValue(Cookie[] cookies,String cookieName){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(cookieName)){
                return cookie.getValue();
            }
        }
        return null;
    }
}
