package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.demain.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by abdelkader on 09/09/2020.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {



}
