package mk.ukim.finki.emt.users.service;

import mk.ukim.finki.emt.users.domain.model.Role;
import mk.ukim.finki.emt.users.domain.model.BookUser;
import mk.ukim.finki.emt.users.domain.model.UserId;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService  {
    UserDetails loadUserByUsername(String username);

    BookUser register(String username, String password);

    BookUser register(String username, String password, Role role);

    List<BookUser> findAll();

    BookUser findById(UserId id);
}
