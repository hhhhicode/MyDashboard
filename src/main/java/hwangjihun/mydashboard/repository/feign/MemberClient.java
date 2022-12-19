package hwangjihun.mydashboard.repository.feign;

import hwangjihun.mydashboard.model.Member;
import hwangjihun.mydashboard.model.MemberAddDto;
import hwangjihun.mydashboard.model.MemberLoginDto;
import hwangjihun.mydashboard.model.MemberProfileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "memberClient", url = "http://localhost:8091")
public interface MemberClient {

    @PostMapping(value = "/external/members/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    Member loginClient(MemberLoginDto memberLoginDto);

    @PostMapping(value = "/external/members/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    Member addClient(MemberAddDto memberAddDto);

    @GetMapping("/external/members/{userId}/exist")
    String userIdExistCheckClient(@PathVariable("userId") String userId);

    @GetMapping(value = "/external/members/{userId}")
    MemberProfileDto findByUserIdForProfileClient(@PathVariable("userId") String userId);

    @DeleteMapping("/external/members/{userId}")
    Boolean deleteClient(@PathVariable("userId") String userId);
}
