package ac.kr.kw.judge.user.service;

import ac.kr.kw.judge.user.domain.User;
import ac.kr.kw.judge.user.repository.UserRepository;
import ac.kr.kw.judge.user.service.command.AuthSignupCommand;
import ac.kr.kw.judge.user.service.port.in.AuthSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthSignupServiceImpl implements AuthSignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signUpForNewUser(AuthSignupCommand authSignupCommand) {
        if (userRepository.existsUserByUsername(authSignupCommand.getUsername())) {
            throw new IllegalArgumentException("해당 username이 이미 존재합니다.");
        }
        User user = User.of(authSignupCommand.getUsername(), passwordEncoder.encode(authSignupCommand.getPassword()));
        userRepository.save(user);
    }
}
