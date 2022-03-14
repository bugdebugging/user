package ac.kr.kw.judge.user.service.port.in;

import ac.kr.kw.judge.user.service.command.AuthLoginCommand;

public interface AuthLoginService {
    String login(AuthLoginCommand command);
}
