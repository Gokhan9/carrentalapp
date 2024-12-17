//JWT token'ı generate ediyoruz. Her user için bir jwt token(backendte). Login olduklarında bu tokenları userlara dönücek.

package com.api.carrentalapp.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${carrentalapp.app.secret}")
    private static String APP_SECRET; //Token oluştururken ki özel key

    @Value("${carrentalapp.expires.in}")
    private Long EXPIRES_IN;   //Kaç saniyede tokenler geçerliliğini yitiriyor.

    //token generate olucağı metod

    public String generateJwtToken(Authentication auth) {
        JwtUserDetails userDetails = (JwtUserDetails) auth.getPrincipal(); //auth'tan user'ı çağırdık.
        Date expireDate = new Date(new Date().getTime() + EXPIRES_IN);  //ne zaman expire olacak?
        return Jwts.builder().setSubject(Long.toString(userDetails.getId()))
                .setIssuedAt(new Date()).setExpiration(expireDate) //şuan oluşturuldu, expire olacak,
                .signWith(SignatureAlgorithm.HS512, APP_SECRET).compact(); // ve bu key'i bu algoritma ile oluştur dedik.
    }

    //metod
    static Long getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

    //front end'ten istek gelince token doğru mu kontrol etmemiz gerek.(validate etmek gerek)
    boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
            return !isTokenExpired(token);
        }catch (SignatureException e) {
            return false;
        }catch (MalformedJwtException e) {
            return false;
        }catch (ExpiredJwtException e) {
            return false;
        }catch (UnsupportedJwtException e) {
            return false;
        }catch (IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
