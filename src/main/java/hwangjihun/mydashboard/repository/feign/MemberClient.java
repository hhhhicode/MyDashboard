package hwangjihun.mydashboard.repository.feign;

import hwangjihun.mydashboard.model.Member;
import hwangjihun.mydashboard.model.MemberLoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "memberClient", url = "http://localhost:8091")
public interface MemberClient {

    @PostMapping(value = "/external/members/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    Member loginClient(MemberLoginDto memberLoginDto);
}
