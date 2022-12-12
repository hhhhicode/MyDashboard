package hwangjihun.mydashboard.controller;

import hwangjihun.mydashboard.model.errorcenter.MyException;
import hwangjihun.mydashboard.service.ErrorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/errorcenter")
public class ErrorCenterController {

    private final ErrorService errorService;

    public ErrorCenterController(ErrorService errorService) {
        this.errorService = errorService;
    }

    @GetMapping("/dashboard")
    public String dashboardForm(Model model) {
        List<MyException> myExceptionList = errorService.errorDashboard();
        model.addAttribute("myExceptionList", myExceptionList);

        return "errorcenter/dashboard";
    }
}
