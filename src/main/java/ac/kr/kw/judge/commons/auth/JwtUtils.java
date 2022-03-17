package ac.kr.kw.judge.commons.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.issuer}")
    private String issuer;

    @Value("${jwt.duration_second}")
    private long durationSecond;

    public String createTokenWithUsername(String username) {
        Algorithm algorithm = Algorithm.HMAC512(secret);
        LocalDateTime expiredAt = LocalDateTime.now().plusSeconds(durationSecond);

        return JWT.create()
                .withExpiresAt(Timestamp.valueOf(expiredAt))
                .withIssuer(issuer)
                .withClaim("username", username)
                .sign(algorithm);
    }
}
