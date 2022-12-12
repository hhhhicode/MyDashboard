package hwangjihun.mydashboard.model.poe;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TotalChange5Currency {

    private String currencyTypeName;
    private String icon;
    private String buyPayCurrencyName;
    private String buyPayValue;
    private String buyPayCurrencyIcon;
    private String buyGetCurrencyName;
    private String buyReceiveValue;
    private String buyGetCurrencyIcon;
    private String buyChartId;
    private List<Double> buyChartDataList;
    private String buyTotalChange;
}
