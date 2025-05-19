package api.pojo.requests.Users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PutUsers_Req {
    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}