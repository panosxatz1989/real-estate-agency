package demo.pxportfolio.realestateagency.misc.agents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AgentDto {

    private Long id;
    private String lastname;
    private String firstname;
    private String phone;
    private String cellularPhone;
    private String email;
    private String profilePic;
}
