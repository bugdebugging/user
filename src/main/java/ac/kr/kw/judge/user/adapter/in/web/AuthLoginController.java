package ac.kr.kw.judge.user.adapter.in.web;

import ac.kr.kw.judge.commons.api.ApiResult;
import ac.kr.kw.judge.commons.api.ApiUtils;
import ac.kr.kw.judge.user.dto.in.AuthLoginRequest;
import ac.kr.kw.judge.user.service.command.AuthLoginCommand;
import ac.kr.kw.judge.user.service.port.in.AuthLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthLoginController {
    private final AuthLoginService authLoginService;

    @PostMapping("/api/users/login")
    public ApiResult login(AuthLoginRequest authLoginRequest) {
        String token = authLoginService.login(new AuthLoginCommand(authLoginRequest.getUsername(), authLoginRequest.getPassword()));
        return ApiUtils.success(token);
    }
}
