package com.example.pm.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtils {

    private static Integer EXPIRATION_TIME = 1000 * 60 * 60;
    private static String JWT_SECERT = "testjwtsaltkey";

    public static String generatorToken(String id) {
       String jwt = Jwts.builder()
               .setHeaderParam("typ","JWT")
               .signWith(SignatureAlgorithm.HS512,JWT_SECERT)
               .setId(id)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
               .compact();
       return jwt;
    }

    public static String parseToken(String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SECERT).parseClaimsJws(token).getBody();
        return claims.getId();
    }
}
