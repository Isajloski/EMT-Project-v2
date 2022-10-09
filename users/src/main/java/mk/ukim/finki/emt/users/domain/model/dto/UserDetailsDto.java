package mk.ukim.finki.emt.users.domain.model.dto;

import lombok.Data;
import mk.ukim.finki.emt.users.domain.model.Role;
import mk.ukim.finki.emt.users.domain.model.BookUser;

@Data
public class UserDetailsDto {
    private String username;
    private Role role;

    public static UserDetailsDto of(BookUser user) {
        UserDetailsDto details = new UserDetailsDto();
        details.username = user.getUsername();
        details.role = user.getRole();
        return details;
    }
}
