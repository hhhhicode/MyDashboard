package hwangjihun.mydashboard.model.poe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CardsDataListDto {

    private List<TotalChange5Currency> currencyTop5Cards;
    private List<TotalChange5Currency> currencyBottom5Cards;
}
