package test.login.login2.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import test.login.login2.dto.UserDto;
import test.login.login2.service.UserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
//@AllArgsConstructor 를 안쓰는 이유는 ?
public class UserController {

    private final UserService userService;

    //★ Mapping : Get(조회), Post(등록), Put(수정), Delete(삭제)

    //메인페이지
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    //회원가입 페이지
    @GetMapping("/user/signup") //화면 가져오는거니까 GetMapping
    public String dispSingup() {
        return "/signup";
    }

    //회원가입 처리
    @PostMapping("/user/signup") //입력된 내용 받아오는 거니까 PostMapping
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
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}
