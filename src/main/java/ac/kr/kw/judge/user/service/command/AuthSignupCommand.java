package ac.kr.kw.judge.user.service.command;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class AuthSignupCommand {
    private String username;
    private String password;

    public AuthSignupCommand(String username, String password) {
        checkArgument(isNotEmpty(username), "사용자의 username은 필수입니다.");
        checkArgument(isNotEmpty(password), "사용자의 password는 필수입니다.");
        
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
