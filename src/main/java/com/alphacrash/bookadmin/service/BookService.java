package com.alphacrash.bookadmin.service;

import com.alphacrash.bookadmin.payload.BookRequestDTO;
import com.alphacrash.bookadmin.payload.BookResponseDTO;

import java.util.List;

public interface BookService {
    public List<BookResponseDTO> fetchBooks();

    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO);

    public void deleteBook(Long bookId);
}
