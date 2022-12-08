package hwangjihun.mydashboard.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

@Getter @Setter
@ToString
public class MemberAddDto {

    @Length(min = 4, max = 20)
    private String userId;
    @Length(min = 4, max = 20)
    private String password;
    @Length(min = 1, max = 20)
    private String userName;
    @Email
    private String emailAddress;
    @Length(max = 1000)
    private String memo;
}
