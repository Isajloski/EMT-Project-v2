package mk.ukim.finki.emt.users.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import mk.ukim.finki.emt.users.config.filters.JwtAuthenticationFilter;
import mk.ukim.finki.emt.users.domain.model.BookUser;
import mk.ukim.finki.emt.users.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/user")

public class UserController {


    private final JwtAuthenticationFilter filter;


    private final UserService userService;

    public UserController(UserService userService, JwtAuthenticationFilter filter) {
        this.userService = userService;
        this.filter = filter;
    }


    @GetMapping("/")
    public List<BookUser> findAll(){
        return this.userService.findAll();
    }

    @PostMapping("/login")
    public String doLogin(HttpServletRequest request,
                          HttpServletResponse response) throws JsonProcessingException {
        Authentication auth = this.filter.attemptAuthentication(request, response);
        return this.filter.generateJwt(response, auth);

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "Sucesful logout!";
    }

    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String password) {
        this.userService.register(username, password);
        return "Sucesful registration";
    }

}
