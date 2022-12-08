package hwangjihun.mydashboard.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter @Setter
public class MemberLoginDto {

    @Length(min = 4, max = 20)
    private String userId;
    @Length(min = 4, max = 20)
    private String password;
}
