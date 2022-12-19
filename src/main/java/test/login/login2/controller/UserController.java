package test.login.login2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import test.login.login2.dto.UserDto;
import test.login.login2.service.UserService;

@Controller
@RequiredArgsConstructor
//@AllArgsConstructor 를 안쓰는 이유는 ?
public class UserController {

    private UserService userService;

    //메인페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    //회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSingup() {
        return "/signup";
    }

    //회원가입 처리
    @GetMapping("/user/signup")
    public String execSignup(UserDto userdto) {
        userService.joinUser(userdto);

        return "redirect:/user/login";
    }

    //로그인 페이지
    @GetMapping("/user/login")
    public String dispLogin() {
        return "/login";
    }

    //로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/loginSuccess";
    }

    //로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/logout";
    }

    //접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    //내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    //어드민 페이지
    @GetMapping("admin")
    public String dispAdmin() {
        return "/admin";
    }
}
