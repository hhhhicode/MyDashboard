package hwangjihun.mydashboard.controller;

import hwangjihun.mydashboard.model.poe.CardsDataListDto;
import hwangjihun.mydashboard.service.PoeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/poeitemvalues")
public class PoeItemValuesController {

    private final PoeService poeService;

    public PoeItemValuesController(PoeService poeService) {
        this.poeService = poeService;
    }

    @GetMapping("/dashboard")
    public String dashboardForm(Model model) {

        CardsDataListDto currencyCardsDataListDto = poeService.currencyDashboard();
        model.addAttribute("currencyCardsDataListDto", currencyCardsDataListDto);

        CardsDataListDto fragmentCardsDataListDto = poeService.fragmentDashboard();
        model.addAttribute("fragmentCardsDataListDto", fragmentCardsDataListDto);

        return "poeitemvalues/dashboard";
    }
}
