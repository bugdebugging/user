package ac.kr.kw.judge.user.service;

import ac.kr.kw.judge.commons.auth.JwtUtils;
import ac.kr.kw.judge.commons.exception.UnAuthorizedException;
import ac.kr.kw.judge.user.domain.User;
import ac.kr.kw.judge.user.repository.UserRepository;
import ac.kr.kw.judge.user.service.command.AuthLoginCommand;
import ac.kr.kw.judge.user.service.port.in.AuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthLoginServiceImpl implements AuthLoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    @Override
    @Transactional(readOnly = true)
    public String login(AuthLoginCommand command) {
        User user = userRepository.findByUsername(command.getUsername())
                .orElseThrow(() -> {
                    throw new UnAuthorizedException("해당 username의 사용자는 존재하지 않습니다.");
                });
        if(!passwordEncoder.matches(command.getPassword(),user.getPassword())){
            throw new UnAuthorizedException("password가 잘못됬습니다.");
        }
        return jwtUtils.createTokenWithUsername(user.getUsername());
    }
}
