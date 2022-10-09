package mk.ukim.finki.emt.users.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.service.AbstractEntity;
import mk.ukim.finki.emt.users.domain.valueobjects.OrderId;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;


@Entity
@Getter
public class BookUser extends AbstractEntity<UserId> {

    private String username;
    private String password;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Transient

    private OrderId order;

    public BookUser(String username, String password) {
        super(UserId.randomId(UserId.class));
        this.username = username;
        this.password = password;
        this.role = Role.ROLE_USER;
        this.order = OrderId.randomId(OrderId.class);
    }

    public BookUser(String username, String password, Role role) {
        super(UserId.randomId(UserId.class));
        this.username = username;
        this.password = password;
        this.role = role;
        this.order = OrderId.randomId(OrderId.class);
    }


    public BookUser() {
        super(UserId.randomId(UserId.class));
        this.username = "";
        this.password = "";
        this.role = Role.ROLE_USER;
        this.order = OrderId.randomId(OrderId.class);
    }


}



