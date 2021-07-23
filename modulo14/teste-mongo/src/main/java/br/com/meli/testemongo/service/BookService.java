package br.com.meli.testemongo.service;

import br.com.meli.testemongo.domain.Book;
import br.com.meli.testemongo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllBooks() {
        return this.bookRepository.findAll();
    }

    public Book save(Book book) {
        return this.bookRepository.save(book);
    }

    public void delete(String id) {
        Book book = this.findById(id);
        this.bookRepository.delete(book);
    }

    public Book findById(String id) {
        return this.bookRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Book update(String id, Book book) {
        Book bookRegistered = null;

        try {
            bookRegistered = this.findById(id);
            bookRegistered.setBookTitle(book.getBookTitle());
            bookRegistered.setAuthor(book.getAuthor());
            this.save(bookRegistered);
        }catch (NoSuchElementException ex) {
            bookRegistered = this.save(book);
        }

        return bookRegistered;
    }
}
