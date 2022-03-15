package ac.kr.kw.judge.user.adapter.in.web;

import ac.kr.kw.judge.commons.api.ApiResult;
import ac.kr.kw.judge.commons.api.ApiUtils;
import ac.kr.kw.judge.user.dto.in.AuthSignupRequest;
import ac.kr.kw.judge.user.service.command.AuthSignupCommand;
import ac.kr.kw.judge.user.service.port.in.AuthSignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AuthSignUpController {
    private final AuthSignupService authSignupService;

    @PostMapping("/api/users")
    public ApiResult signUp(@Valid @RequestBody AuthSignupRequest authSignupRequest) {
        authSignupService.signUpForNewUser(new AuthSignupCommand(authSignupRequest.getUsername(), authSignupRequest.getPassword()));
        return ApiUtils.simpleMessage("successfully sign up.");
    }
}
