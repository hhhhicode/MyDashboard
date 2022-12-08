package hwangjihun.mydashboard.service;

import hwangjihun.mydashboard.model.Member;
import hwangjihun.mydashboard.model.MemberLoginDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("로그인 결과 받는지?")
    void loginRequest() {

        MemberLoginDto memberLoginDto = new MemberLoginDto();
        memberLoginDto.setUserId("test4");
        memberLoginDto.setPassword("1234");
        assertThat(memberService.loginRequest(memberLoginDto)).isInstanceOf(Member.class);
    }
}