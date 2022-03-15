package ac.kr.kw.judge.user.dto.in;

public class AuthLoginRequest {
    private String username;
    private String password;

    public AuthLoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
