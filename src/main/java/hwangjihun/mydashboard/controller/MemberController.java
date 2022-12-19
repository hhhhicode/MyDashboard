package hwangjihun.mydashboard.controller;

import hwangjihun.mydashboard.domain.memberconst.SessionConst;
import hwangjihun.mydashboard.model.*;
import hwangjihun.mydashboard.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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

        Member loginMember = memberService.loginRequest(memberLoginDto);
        if (loginMember.getId() == null) {
            bindingResult.addError(new ObjectError("memberLoginDto", new String[]{"login"}, null, null));
        }
        if (bindingResult.hasErrors()) {
            return "members/login";
        }


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

    @GetMapping("/add")
    public String addForm(@ModelAttribute("memberAddDto") MemberAddDto memberAddDto) {

        return "members/add";
    }

    @PostMapping("/add")
    public String add(@Validated @ModelAttribute MemberAddDto memberAddDto, BindingResult bindingResult) {

        Boolean isUserIdDuplicate = memberService.isUseridDuplicate(memberAddDto.getUserId());
        if (isUserIdDuplicate) {
            bindingResult.addError(new FieldError("memberAddDto", "userId", memberAddDto.getUserId(),
                    false, new String[]{"userIdDuplicate"}, null, null));
        }

        if (bindingResult.hasErrors()) {
            return "members/add";
        }

        Member addMember = memberService.addRequest(memberAddDto);

        if (addMember == null || addMember.getId() == null) {
            return "members/add";
        }

        return "redirect:/members/login";
    }

    @GetMapping("/profile/{userId}")
    public String profileForm(@PathVariable String userId,
                              HttpServletRequest request,
                              Model model) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "redirect:/";
        }

        MemberProfileDto memberProfileDto = memberService.profileRequest(userId);
        model.addAttribute("memberProfileDto", memberProfileDto);

        return "members/profile";
    }

    @PostMapping("/delete")
    public String delete(HttpServletRequest request,
                         @ModelAttribute Member member, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        HttpSession session = request.getSession(false);
        if (session == null) {
            return "";
        }

        MemberSessionDto memberSessionDto = (MemberSessionDto) session.getAttribute(SessionConst.LOGIN_MEMBER_ID);
        Boolean resultBoolean = memberService.memberDelete(memberSessionDto.getUserId());
        if (!resultBoolean) {
            bindingResult.reject("fail", "계정 삭제 실패.");
            return "";
        }

        return "redirect:/";
    }
}
