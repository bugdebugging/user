package ac.kr.kw.judge.user.dto.out;

public class AuthResult {
    private String token;

    private AuthResult(String token) {
        this.token = token;
    }

    public static AuthResult of(String token) {
        return new AuthResult(token);
    }

    public String getToken() {
        return token;
    }
}
