package mk.ukim.finki.emt.users.domain.repository;

import mk.ukim.finki.emt.users.domain.model.BookUser;
import mk.ukim.finki.emt.users.domain.model.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<BookUser, UserId> {
    Optional<Object> findByUsername(String username);
}
