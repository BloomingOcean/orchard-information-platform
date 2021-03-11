package com.liyang.orchard.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil implements Serializable {
    /**
     * 加密的秘钥,相当于服务器私钥,一定保管好,不能泄露
     */
    private static final String secret = "MIIEpQIBAAKCAQEAvIzWvL4OvecUC+C84RAnzbFtdE/X1JOanVT2m/DtxTAxYQlM" +
            "x+z9Fhe6VKh8joLuXjrn4BSE0d/jcK+nxxReJu+PRRqesXzY/BRC7+FY4t2SFo/d" +
            "SCj+6WVM7CZBSa9sbH9eE4fiFo313zapXLyz9y+HQkqPgZ83hcf/+uesegF51qy8" +
            "eWR99ziMlTOGvpkqNr0JCNFmjIQfomBHHriWYKJgwtI4/kcgq3xDZjvFPxT365Tj" +
            "RfH3eoesZPdQGTak1iRyLGEh2kuuIUyECc//tl+YKoLlspjIYFBgUFXJk1Rrd3dq" +
            "6/CQKqdj+r6sNWSZRGzR00snL+z2TOUX3VCdYwIDAQABAoIBAQCSTGl2S7YejYUV" +
            "bkzACQwJYyk9fZJHRDxM5ZbwCrJDNZCq7U9hNTZvBPw0IgN7hIY2IVi3mtQwEJtm" +
            "XTU+mEQxy+GLygrmRqwKdCI4BM82QJvQ29Hj4sNgD5TvCwPPi8kCKpWxa9b2jzH+" +
            "/2fMKDMvkfZObpIJDqRDLpslcMt4YgXSISDkrN+v7cpXaZP8uxB+pU1Y6r6Ccd4Q" +
            "3M4c+xVXEl5A8wXwO1a+QC8kZs0VZ53UsBqS5UiMWRPSIY2ApWyu35eDW7elPb7H" +
            "mXgamqEMZhN6A7QCppHvgaiGsKk3vyJuYGKUe0cVyJh93yvvHvv4mSg9GVEddtEH" +
            "bwEJVtzZAoGBAN52rdeeSq6IiKnLe3T+p/RJl1v7QWevxFIloKziHits0FWOh0Pj" +
            "NsSLT3KELkcQm5QovxKundjTdVT+aejDgyUdjQNXy4OUf5O8dnQwA5DgZCWsv1rn" +
            "xnVDO22FmBq6eok9q7a9QwlzmZDbVXDvSmZ63fNpsIlVpBKShxUO//7dAoGBANj5" +
            "XxRZwBJf6fm6c0nbDUAq6MAv85EwU7kyAS362VhZj3kurZr9fGQxVmCVqYtPXB52" +
            "Uahcpjopd6QcyaVoKZErIs0Ni+wRcYaMpXO56FMm6xTP8CVk8wO6ImesArLq8+Zv" +
            "2Z+6hEmMPR7m4zBWfAJ4Vryr1nF/FVnNNJnxxak/AoGBAJNCUDUorRr3ei+baK+7" +
            "WoZUqILUwSjXqscN7VxDmeD4+LeJz3Ra1YgpB4Awi0mzbqkWh9TgDdDXuRV4C7du" +
            "pENPWmbaGPeStxieanLizZl7UA+4WDrerfo1dQM8qcEXq8FpN1+RzOxWv1KqPday" +
            "L7fCoWVdkuR18lPw9sYz1bVpAoGBAMhzSdXBPOM83SoriMsYpls7yR+UrU7a+N5F" +
            "RjW2ZAltZFEuQJDJ0pu1wPkmCyZ6wL4bzUDfp2pgWPmy5s/7NTu6QEJ0W2pSizEk" +
            "ys3pWKtJbzEhEdlaM/Cji5l/nlaxHXcsqj8Yz5IrD2R3JjjIDXUyu98+WbUtFQqL" +
            "vCbk6Bl9AoGAVdCgN/SF3dOPfaQoU2KnO2jsUo5i1cDcJ2TJy0Ereo86fQ3dJpix" +
            "UuwisbP9ZO2eUknwTOh3Sd9zg2feIuhCGZqRi60rqiNX5nboSdMUV5E/itutgVLW" +
            "MjMqVslsw4i1MaD5YbbjDGJKRcX3b1fmxS6MaR2d4DYlSyCY0r+AQKc=";
    /**
     * 获取token的key,一般token存在请求头和相应头中
     */
    public static final String tokenHeader = "Bearer ";
    /**
     * token的有效时间,不需要自己验证失效,当失效后,会自动抛出异常
     */
    private static final Long expTime = 60 * 2 * 1000L;

    /**
     * 创建一个token
     * @param id
     * @return
     */
    public static String getToken(Integer id, String name) {
        //也可以添加这些之外的其他信息------------------------|
        //这里额外添加一个信息,尝试获取
        String uuid = "这里是额外的信息,UUIDkey";
        Map<String, Object> map = new HashMap<>();
        map.put("uuidkey", id);
        //也可以添加这些之外的其他信息------------------------|

        JwtBuilder builder = Jwts.builder();
        String token = builder
                //设置加密的方式
                .signWith(SignatureAlgorithm.HS256, secret)
                //设置生成token的关键信息,可以将关键的信息加密
                .setId(uuid).setSubject(name)
                //设置token的签发时间和实效的时间
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expTime))
                //这个方法实际上是调用的构造方法,so在获取改内容时,就直接将Claims按照map处理
                .addClaims(map)
                //生成秘钥
                .compact();

        System.out.println("token=" + token);
        return token;
    }

    /**
     * 查看并解析token
     * 这个方法会在token异常的时候自动抛出异常,不用自定异常,
     * 只需要在验证的时候进行捕获即可
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token){
        //这里得到是token中的载荷部分,也是具体信息的所在
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token).getBody();
        //对应的是上边的
        Object uuidkey = claims.get("uuidkey");
        System.out.println(uuidkey);
        return claims;
    }

    /**
     * 获取用户的姓名
     * @param token
     */
    public static String getUserName(String token){
        String name = getTokenBody(token).getSubject();
        System.out.println("name====" + name);
        return name;
    }

    /**
     * 获取用户的id
     * @param token
     */
    public static String getUserId(String token){
        String id = getTokenBody(token).getId();
        System.out.println("id====" + id);
        return id;
    }

    /**
     * 获取用户的uuidkey
     * @param token
     */
    public static String getUUIDKey(String token, String key){
        String UUIDkey = (String) getTokenBody(token).get(key);
        System.out.println("UUIDkey====" + UUIDkey);
        return UUIDkey;
    }

    //测试是否可以去到信息
    public static void main(String[] args) {
        String token = getToken(1, "mmm");
        String uuidkey = getUUIDKey(token, "uuidkey");
        //配置进去的是 uuidkey='这里是额外的信息,UUIDkey'
        System.out.println(uuidkey);
    }
}
