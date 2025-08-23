package Easys.Easys.Infra.Config.Security;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;


@Service
public class JwtTokenService {
    
    @Value("${api.security.token.secret:change-me-please-32chars-minimum-secret-key}")
    private String secret;
    public String generateToken(String username, List<String> roles) {
        return JWT.create()
                .withClaim("role", roles)
                .withSubject(username)
                .withIssuer("Easys")
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .sign(Algorithm.HMAC256(secret));
    }
    public String getUsernameFromToken(String token) {
        return JWT.decode(token).getSubject();
    }
    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
