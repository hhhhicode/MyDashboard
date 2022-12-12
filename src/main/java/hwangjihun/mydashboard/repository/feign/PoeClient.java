package hwangjihun.mydashboard.repository.feign;

import hwangjihun.mydashboard.model.poe.CardsDataListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "poeClient", url = "http://localhost:8080")
public interface PoeClient {

    @GetMapping(value = "/external/currencies/currency/dashboard")
    CardsDataListDto currencyDashboardClient();

    @GetMapping(value = "/external/currencies/fragment/dashboard")
    CardsDataListDto fragmentDashboardClient();
}
