package hwangjihun.mydashboard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter
@ToString
public class MemberSessionDto {

    private String userId;
    private String userName;
    private String icon;
    private String emailAddress;
    private String displayPrograms;
}
