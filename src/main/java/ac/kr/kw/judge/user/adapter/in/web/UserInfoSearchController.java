package ac.kr.kw.judge.user.adapter.in.web;

import ac.kr.kw.judge.commons.api.ApiResult;
import ac.kr.kw.judge.commons.api.ApiUtils;
import ac.kr.kw.judge.commons.auth.AuthorizedUser;
import ac.kr.kw.judge.user.dto.out.UserDto;
import ac.kr.kw.judge.user.service.port.in.UserSearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserInfoSearchController {
    private final UserSearchService userSearchService;

    @GetMapping("/api/users")
    public ApiResult<UserDto> searchUserInfo(@AuthorizedUser String username) {
        return ApiUtils.success(userSearchService.searchUserInfo(username));
    }
}
