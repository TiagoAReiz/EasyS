package Easys.Easys.Infra.Config.Security;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


@Service
public class JwtTokenService {
    public String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .sign(Algorithm.HMAC256("secret"));
    }
    public String getUsernameFromToken(String token) {
        return JWT.decode(token).getSubject();
    }
    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256("secret")).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
