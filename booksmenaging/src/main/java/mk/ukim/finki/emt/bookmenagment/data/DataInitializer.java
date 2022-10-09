package mk.ukim.finki.emt.bookmenagment.data;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.bookmenagment.domain.model.Book;
import mk.ukim.finki.emt.bookmenagment.domain.repository.BookRepository;
import mk.ukim.finki.emt.sharedkernel.service.Currency;
import mk.ukim.finki.emt.sharedkernel.service.Money;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataInitializer {

    private final BookRepository bookRepository;

    //    Book create(String bookName, String authorName, String img, String synapse, Money price, String genre);
    @PostConstruct
    public void initData() {
//    public Book create(String bookName, String authorName, String img, String synapse, Money price, String genre) {
        //Money mon = new Money(Currency.MKD, 30);
        //this.bookRepository.save( Book.build("Goran", "Isajloski", "x", "cool", mon , "Goran"));
        Book book1 = Book.build("Anna Karenina",
                "Leo Tolstoy",
                "https://images-na.ssl-images-amazon.com/images/I/71dD4ALhDhL.jpg",
                "The story centers on an extramarital affair between Anna and dashing cavalry officer Count Alexei Kirillovich Vronsky that scandalizes the social circles of Saint Petersburg and forces the young lovers to flee to Italy in a search for happiness.",
                Money.valueOf(Currency.MKD, 500),
                "Novel",
                3
        );
        Book book2 = Book.build("Crime and Punishment",
                "Fyodor Dostoevsky",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/02bbc540531495.57836e92d8e40.jpg",
                    "Crime and Punishment follows the mental anguish and moral dilemmas of Rodion Raskolnikov, an impoverished ex-student in Saint Petersburg who plans to kill an unscrupulous pawnbroker, an old woman who stores money and valuable objects in her flat.",
                Money.valueOf(Currency.MKD, 350),
                "Novel",
                3);

        Book book3 = Book.build("The Hobbit",
                "J.R.R Tolkein",
                "https://i.imgur.com/hlrPg0U.jpg",
                " the quest of home-loving Bilbo Baggins, the titular hobbit, to win a share of the treasure guarded by a dragon named Smaug. Bilbo's journey takes him from his light-hearted, rural surroundings into more sinister territory.",
                Money.valueOf(Currency.MKD, 400),
                "Fantasy",
                5);

        Book book4 = Book.build("The Stranger",
                "Albert Camus",
                "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/08866229118995.55e397fa16455.jpg",
                "Meursault  is a French settler in Algeria who learns of his mother's death by telegram. Meursault's indifference to his mother's death demonstrates some emotional detachment from his environment.",
                Money.valueOf(Currency.MKD, 350),
                "Philosophy",
                2);

        Book book5 = Book.build("Don Quixote",
                "Miguel de Cervantes ",
                "https://static.displate.com/857x1200/displate/2020-10-01/52f8961d1f4562a350d99c74128e1782_aa1bea8c299d972dec012a862e285740.jpg",
                "The plot revolves around the adventures of a member of the lowest nobility from La Mancha named Alonso Quijano, who reads so many chivalric romances that he either loses or pretends to have lost his mind in order to become a knight-errant",
                Money.valueOf(Currency.MKD, 420),
                "Novel",
                5);

        Book book6 = Book.build("Hamlet",
                "William Shakespeare",
                "https://i.pinimg.com/originals/01/bd/c2/01bdc285d890b422504f10604b619fea.jpg",
                "This play is an exquisite work that sets up some astonishing themes such as themes betrayal, love, and revenge. The play is basically centered around King Hamlet's death, or best said, murder.",
                Money.valueOf(Currency.MKD, 200),
                "Play",
                3);

        if (bookRepository.findAll().isEmpty()) {
            bookRepository.saveAll(Arrays.asList(book5, book2, book4, book1, book3, book6));
        }


//      books.add(new Book("Anna Karenina","Leo Tolstoy", "Novel" ,"books/1.jpg","Acclaimed by many as the world's greatest novel, Anna Karenina provides a vast panorama of contemporary life in Russia and of humanity in general. In it Tolstoy uses his intense imaginative insight to create some of the most memorable characters in all of literature. Anna is a sophisticated woman who abandons her empty existence as the wife of Karenin and turns to Count Vronsky to fulfil her passionate nature - with tragic consequences. Levin is a reflection of Tolstoy himself, often expressing the author's own views and convictions. Throughout, Tolstoy points no moral, merely inviting us not to judge but to watch. As Rosemary Edmonds comments, 'He leaves the shifting patterns of the kaleidoscope to bring home the meaning of the brooding words following the title, 'Vengeance is mine, and I will repay", 20));

    }
}