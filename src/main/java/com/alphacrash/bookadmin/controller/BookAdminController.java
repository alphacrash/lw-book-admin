package com.alphacrash.bookadmin.controller;

import com.alphacrash.bookadmin.payload.BookRequestDTO;
import com.alphacrash.bookadmin.payload.BookResponseDTO;
import com.alphacrash.bookadmin.payload.BooksResponseDTO;
import com.alphacrash.bookadmin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class BookAdminController {

    @Autowired
    public BookService bookService;

    @GetMapping("/fetchBooks")
    ResponseEntity<BooksResponseDTO> fetchBooks() {
        BooksResponseDTO booksResponseDTO = new BooksResponseDTO();
        List<BookResponseDTO> bookList = bookService.fetchBooks();
        booksResponseDTO.setBooks(bookList);
        return new ResponseEntity<>(booksResponseDTO, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    ResponseEntity<BookResponseDTO> addBook(@RequestBody BookRequestDTO bookRequestDTO) {
        BookResponseDTO bookResponseDTO = bookService.addBook(bookRequestDTO);
        return new ResponseEntity<>(bookResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteBook/{bookId}")
    ResponseEntity deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
