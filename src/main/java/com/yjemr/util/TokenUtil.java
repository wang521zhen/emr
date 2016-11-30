package com.yjemr.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import javax.annotation.security.PermitAll;
/** 
* @ClassName: TokenUtil 
* @Description: TODO(token管理工具类) 
* @author 
* @date 
*  
*/
@PermitAll
public class TokenUtil {
    public static String getJWTString(String tel,Date expires,Key key,String commpanyId,Map<String,Object> claims){
        if (tel == null) {
            throw new NullPointerException("null username is illegal");
        }
        if (expires == null) {
            throw new NullPointerException("null expires is illegal");
        }
        if (key == null) {
            throw new NullPointerException("null key is illegal");
        }
        SignatureAlgorithm signatureAlgorithm =SignatureAlgorithm.HS256;
        String jwtString = Jwts.builder()
                .setIssuer("Jersey-Security-Basic")
                .setSubject(tel)
                .setAudience("user")
                .setExpiration(expires)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setId(commpanyId)
                .signWith(signatureAlgorithm,key)
                .compact();
        return jwtString;
    }
    public static boolean isValid(String token, Key key) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token.trim());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public static String getName(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            String name = String.valueOf(claimsJws.getBody().get("name"));
            return name;
        }
        return null;
    }
    public static String[] getRoles(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().getAudience().split(",");
        }
        return new String[]{};
    }
    public static int getVersion(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return Integer.parseInt(claimsJws.getBody().getId());
        }
        return -1;
    }
    /** 
    * @Title: getCompanyId 
    * @Description: TODO(获取企业ID) 
    * @param @param jwsToken
    * @param @param key
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    */
    public static String getCompanyId(String jwsToken, Key key) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            String companyid = String.valueOf(claimsJws.getBody().get("id"));
          return companyid;
        }
        return null;
    }
    /** 
    * @Title: setAcccessToken 
    * @Description: TODO(存放鉴权中心token) 
    * @param @param accessToken
    * @param @param key
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws 
    */
    public static void setAcccessToken(String authToken, Key key,String accessToken) {
        if (isValid(authToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(authToken);
            claimsJws.getBody().put("acessToken", accessToken);
        }
    }
    /**
     * 获取token键值
     * @param jwsToken
     * @param key
     * @param obj
     * @return
     */
    public static Object getValue(String jwsToken ,Key key ,Object obj) {
        if (isValid(jwsToken, key)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(jwsToken);
            return claimsJws.getBody().get(obj);
        }
        return null;
    }
}
