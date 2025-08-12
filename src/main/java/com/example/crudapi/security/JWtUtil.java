//package com.example.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.SignatureException;
//import io.jsonwebtoken.MalformedJwtException;
//
//import java.util.Date;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class JWtUtil {
//
//    private final String SECRET_KEY = "your_secret_key";
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 jam
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return extractAllClaims(token).getSubject();
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public Boolean validateToken(String token) {
//        try {
//            final String extractedUsername = extractUsername(token);
//            return (extractedUsername.equals(username) && !isTokenExpired(token));
//        } catch (ExpiredJwtException e) {
//            System.out.println("Token expired");
//            return false;
//        } catch (SignatureException | MalformedJwtException e) {
//            System.out.println("Invalid token");
//            return false;
//        } catch (Exception e) {
//            System.out.println("Error validating token: " + e.getMessage());
//            return false;
//        }
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractAllClaims(token).getExpiration().before(new Date());
//    }
//}
