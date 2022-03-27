package ac.kr.kw.judge.user.service;

import ac.kr.kw.judge.user.domain.User;
import ac.kr.kw.judge.user.dto.out.UserDto;
import ac.kr.kw.judge.user.repository.UserRepository;
import ac.kr.kw.judge.user.service.port.in.UserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserSearchServiceImpl implements UserSearchService {
    private final UserRepository userRepository;

    @Override
    public UserDto searchUserInfo(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("해당 username이 존재하지 않습니다.");
                });
        return UserDto.fromEntity(user);
    }
}
