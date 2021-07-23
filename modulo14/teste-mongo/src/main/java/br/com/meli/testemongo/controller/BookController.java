package br.com.meli.testemongo.controller;

import br.com.meli.testemongo.domain.Book;
import br.com.meli.testemongo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> findAllBooks() {
        return bookService.findAllBooks();
    }

    @PostMapping("register")
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody Book book) {
        return this.bookService.save(book);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteBook(@PathVariable("id") String id) {
        this.bookService.delete(id);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book readBook(@PathVariable("id") String id) {
        return this.bookService.findById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book readBook(@PathVariable("id") String id, @RequestBody Book book) {
        return this.bookService.update(id,book);
    }
}
