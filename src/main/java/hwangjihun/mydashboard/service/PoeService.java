package hwangjihun.mydashboard.service;

import hwangjihun.mydashboard.model.poe.CardsDataListDto;
import hwangjihun.mydashboard.repository.feign.PoeClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class PoeService {

    private final PoeClient poeClient;

    public PoeService(PoeClient poeClient) {
        this.poeClient = poeClient;
    }

    public CardsDataListDto currencyDashboard() {

        return poeClient.currencyDashboardClient();
    }

    public CardsDataListDto fragmentDashboard() {

        return poeClient.fragmentDashboardClient();
    }
}
