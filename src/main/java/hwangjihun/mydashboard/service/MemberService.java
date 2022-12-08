package hwangjihun.mydashboard.service;

import hwangjihun.mydashboard.model.Member;
import hwangjihun.mydashboard.model.MemberAddDto;
import hwangjihun.mydashboard.model.MemberLoginDto;
import hwangjihun.mydashboard.model.MemberSessionDto;
import hwangjihun.mydashboard.repository.feign.MemberClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

    private final MemberClient memberClient;

    public MemberService(MemberClient memberClient) {
        this.memberClient = memberClient;
    }

    public Member loginRequest(MemberLoginDto memberLoginDto) {

        return memberClient.loginClient(memberLoginDto);
    }

    public Member addRequest(MemberAddDto memberAddDto) {

        return memberClient.addClient(memberAddDto);
    }

    public Boolean isUseridDuplicate(String userId) {

        return Boolean.parseBoolean(memberClient.userIdExistCheckClient(userId));
    }

    public MemberSessionDto memberToMemberSessionDto(Member member) {
        MemberSessionDto memberSessionDto = new MemberSessionDto();
        memberSessionDto.setUserId(member.getUserId());
        memberSessionDto.setUserName(member.getUserName());
        memberSessionDto.setEmailAddress(member.getEmailAddress());
        memberSessionDto.setIcon(member.getIcon());
        memberSessionDto.setDisplayPrograms(member.getDisplayPrograms());

        return memberSessionDto;
    }
}
