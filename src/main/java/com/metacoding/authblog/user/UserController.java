package com.metacoding.authblog.user;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequiredArgsConstructor
@Controller
public class UserController {
    private final UserService userService;
    private final HttpSession session;

    @PostMapping("/join")
    public String join(UserRequest.JoinDTO joinDTO){
        userService.회원가입(joinDTO);
        return "redirect:/login-form";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        return "user/login-form";
    }

}
