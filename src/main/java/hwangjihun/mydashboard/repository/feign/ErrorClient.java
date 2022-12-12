package hwangjihun.mydashboard.repository.feign;

import hwangjihun.mydashboard.model.errorcenter.MyException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "errorClient", url = "http://localhost:8090")
public interface ErrorClient {

    @GetMapping("/external/dashboard")
    List<MyException> errorDashboardClient();
}
