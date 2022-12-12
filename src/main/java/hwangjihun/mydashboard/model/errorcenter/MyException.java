package hwangjihun.mydashboard.model.errorcenter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @Setter
@ToString
public class MyException {
    private Long id;
    private int projectId;
    private Timestamp date;
    private String errorMessage;
}
