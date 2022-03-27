package ac.kr.kw.judge.user.service.port.in;

import ac.kr.kw.judge.user.dto.out.UserDto;

public interface UserSearchService {
    UserDto searchUserInfo(String username);
}
