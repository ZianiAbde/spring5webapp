package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.demain.Author;
import guru.springframework.spring5webapp.demain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by abdelkader on 09/09/2020.
 */

@Component
public class BootStrapDAta implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapDAta(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public void run(String... strings) throws Exception {

        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "1234567");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "3265987");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started In BootStrap");
        System.out.println("Number Of Books: " + bookRepository.count());



    }
}
