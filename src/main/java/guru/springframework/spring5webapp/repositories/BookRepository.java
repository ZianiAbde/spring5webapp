package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.demain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by abdelkader on 09/09/2020.
 */
public interface BookRepository extends CrudRepository<Book, Long> {


}
