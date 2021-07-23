package br.com.meli.testemongo.repository;


import br.com.meli.testemongo.domain.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, String> {
}
