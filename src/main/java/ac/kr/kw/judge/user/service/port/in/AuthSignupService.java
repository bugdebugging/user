package ac.kr.kw.judge.user.service.port.in;

import ac.kr.kw.judge.user.service.command.AuthSignupCommand;

public interface AuthSignupService {
    void signUpForNewUser(AuthSignupCommand authSignupCommand);
}
