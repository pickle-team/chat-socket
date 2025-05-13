package com.pickle.socket.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("register")
    @ResponseBody
    String Register(String username, String password) {
        Member member = new Member();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        memberRepository.save(member);
        return "success";
    }

    @PostMapping("login")
    @ResponseBody
    String Login(String username, String password) {
        var member = memberRepository.findByUsername(username).get();
        if(passwordEncoder.matches(password, member.getPassword())) {
            return member.getUsername();
        } else {
            return "fail";
        }
    }
}
