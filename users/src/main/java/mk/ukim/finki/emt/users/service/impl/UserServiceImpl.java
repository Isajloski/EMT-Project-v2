package mk.ukim.finki.emt.users.service.impl;

import mk.ukim.finki.emt.users.domain.excep.InvalidPassword;
import mk.ukim.finki.emt.users.domain.excep.SomethingException;
import mk.ukim.finki.emt.users.domain.model.Role;
import mk.ukim.finki.emt.users.domain.model.BookUser;
import mk.ukim.finki.emt.users.domain.model.UserId;
import mk.ukim.finki.emt.users.domain.repository.UserRepository;
import mk.ukim.finki.emt.users.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return (UserDetails) userRepository.findByUsername(s).orElseThrow(() -> new UsernameNotFoundException(s));
    }


    @Override
    public BookUser register(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidPassword(password);
        if (this.userRepository.findByUsername(username).isPresent())
            throw new InvalidPassword(username);
        BookUser user=new BookUser(username,passwordEncoder.encode(password));
        return this.userRepository.save(user);
    }

    @Override
    public BookUser register(String username, String password, Role role) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty())
            throw new InvalidPassword(password);
        if (this.userRepository.findByUsername(username).isPresent())
            throw new InvalidPassword(username);
        BookUser user=new BookUser(username,passwordEncoder.encode(password), role);
        return this.userRepository.save(user);
    }

    @Override
    public List<BookUser> findAll() {
        return this.userRepository.findAll();
    }

    public BookUser findById(UserId id){
        return this.userRepository.findById(id).orElseThrow(SomethingException::new);
    }
}