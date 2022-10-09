package mk.ukim.finki.emt.bookmenagment.domain.repository;

import mk.ukim.finki.emt.bookmenagment.domain.model.Book;
import mk.ukim.finki.emt.bookmenagment.domain.model.BookId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository  extends JpaRepository<Book, BookId> {



    List<Book> findAllByBookNameContainingOrAuthorNameContainingOrGenreContaining(String bookName, String authorName, String genre);
}