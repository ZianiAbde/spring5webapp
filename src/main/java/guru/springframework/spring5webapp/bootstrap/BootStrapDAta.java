package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.demain.Author;
import guru.springframework.spring5webapp.demain.Book;
import guru.springframework.spring5webapp.demain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by abdelkader on 09/09/2020.
 */

@Component
public class BootStrapDAta implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapDAta(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository ) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... strings) throws Exception {
        System.out.println("Started In BootStrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("ST Petersburg");
        publisher.setState("FL");
        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");

        Book ddd = new Book("Domain Driven Design", "1234567");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);


        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development Without EJB", "3265987");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);


        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);



        System.out.println("Number Of Books: " + bookRepository.count());
        System.out.println("Publisher Number Of Book: " + publisher.getBooks().size() );



    }
}
