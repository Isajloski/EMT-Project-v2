package mk.ukim.finki.emt.users.data;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.users.domain.model.BookUser;
import mk.ukim.finki.emt.users.domain.model.Role;
import mk.ukim.finki.emt.users.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {


    final UserService userService;

    public DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initData() {
        this.userService.register("user" + 0, "pass" + 0, Role.ROLE_ADMIN);
        for (int i = 1; i < 6; i++) {
            this.userService.register("user" + i, "pass" + i, Role.ROLE_ADMIN);
        }
    }
}
