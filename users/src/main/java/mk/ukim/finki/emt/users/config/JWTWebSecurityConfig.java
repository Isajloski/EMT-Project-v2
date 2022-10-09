package mk.ukim.finki.emt.users.config;


import lombok.AllArgsConstructor;

import  mk.ukim.finki.emt.users.config.filters.JWTAuthorizationFilter;
import  mk.ukim.finki.emt.users.config.filters.JwtAuthenticationFilter;
import mk.ukim.finki.emt.users.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(200)
@Configuration
@AllArgsConstructor
public class JWTWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final CustomUsernamePasswordAuthenticationProvider authenticationProvider;
    private final UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/home", "/assets/**", "/register", "/products", "/api/login","/api/products", "/login","/h2/**", "/h2**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), (UserDetailsService) userService, passwordEncoder))
                .addFilter(new JWTAuthorizationFilter(authenticationManager(), (UserDetailsService) userService))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);


    }


}
