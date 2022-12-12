package hwangjihun.mydashboard.service;

import hwangjihun.mydashboard.model.errorcenter.MyException;
import hwangjihun.mydashboard.repository.feign.ErrorClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorService {

    private final ErrorClient errorClient;

    public ErrorService(ErrorClient errorClient) {
        this.errorClient = errorClient;
    }

    public List<MyException> errorDashboard() {
        List<MyException> exceptionList = errorClient.errorDashboardClient();
        return exceptionList;
    }
}
