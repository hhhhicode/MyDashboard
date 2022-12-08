package hwangjihun.mydashboard.controller;

import hwangjihun.mydashboard.domain.memberconst.SessionConst;
import hwangjihun.mydashboard.model.Member;
import hwangjihun.mydashboard.model.MemberLoginDto;
import hwangjihun.mydashboard.model.MemberSessionDto;
import hwangjihun.mydashboard.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequestMapping("/members")
public class MemberController {

    @Value("${homeUri}")
    private String homeUri;

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm(Model model, HttpServletRequest request,
                            @ModelAttribute("memberLoginDto") MemberLoginDto memberLoginDto) {

        return "members/login";
    }

    @PostMapping("/login")
    public String login(HttpServletRequest request,
                        @Validated @ModelAttribute MemberLoginDto memberLoginDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "members/login";
        }

        Member loginMember = memberService.loginRequest(memberLoginDto);
        log.info("loginMember={}", loginMember);
        if (loginMember.getId() != null) {
            MemberSessionDto memberSessionDto = memberService.memberToMemberSessionDto(loginMember);

            HttpSession session = request.getSession(true);
            session.setAttribute(SessionConst.LOGIN_MEMBER_ID, memberSessionDto);
        }

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        String preUri = request.getHeader("REFERER") == null ? homeUri : request.getHeader("REFERER");

        return "redirect:" + preUri;
    }
}
