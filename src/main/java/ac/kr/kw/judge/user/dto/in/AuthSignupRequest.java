package ac.kr.kw.judge.user.dto.in;

import javax.validation.constraints.Size;

public class AuthSignupRequest {
    @Size(min = 5, max = 63, message = "username은 5~63 사이의 길이여야합니다.")
    private String username;
    @Size(min = 10, message = "비밀번호는 적어도 10글자 이상이어야합니다.")
    private String password;

    public AuthSignupRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
