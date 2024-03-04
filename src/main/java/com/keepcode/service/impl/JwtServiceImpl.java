package com.keepcode.service.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.keepcode.service.JwtService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

/**
 * Implementación del servicio de JWT
 */
@Slf4j
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${jwt.token.secret}")
    private String secret;

    @Override
    public String getToken(UserDetails userDetails) {
        return this.getToken(new HashMap<>(), userDetails);
    }

    /**
     * Obtención de token
     * 
     * @param userClaims Reclamo de usuario
     * @param user       Detalle de usuario
     * @return Token
     */
    private String getToken(Map<String, Object> userClaims, UserDetails user) {
        log.info("JwtServiceImpl.getToken() - Obtención de token");
        return Jwts
                .builder()
                .claims(userClaims)
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Obtención de clave firmada
     * 
     * @return Clave
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(this.secret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return this.getClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token) {
        // return
        // Jwts.parser().setSigningKey(getSigningKey()).build().parseClaimsJws(token).getBody();
        return Jwts.parser().verifyWith((SecretKey) getSigningKey()).build().parseSignedClaims(token).getPayload();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return this.getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }

}
