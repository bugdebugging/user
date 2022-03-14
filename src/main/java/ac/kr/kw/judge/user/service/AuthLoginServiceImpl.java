package ac.kr.kw.judge.user.service;

import ac.kr.kw.judge.user.repository.UserRepository;
import ac.kr.kw.judge.user.service.command.AuthLoginCommand;
import ac.kr.kw.judge.user.service.port.in.AuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthLoginServiceImpl implements AuthLoginService {
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public String login(AuthLoginCommand command) {
        userRepository.findById(command)
        return null;
    }
}
