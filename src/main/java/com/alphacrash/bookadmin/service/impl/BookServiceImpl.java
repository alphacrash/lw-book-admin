package com.alphacrash.bookadmin.service.impl;

import com.alphacrash.bookadmin.model.Book;
import com.alphacrash.bookadmin.payload.BookRequestDTO;
import com.alphacrash.bookadmin.payload.BookResponseDTO;
import com.alphacrash.bookadmin.repository.BookRepository;
import com.alphacrash.bookadmin.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookResponseDTO> fetchBooks() {
        List<Book> bookList = bookRepository.findAll();
        List<BookResponseDTO> bookResponseDTOList = bookList.stream().map(book -> mapBookEntityToDTO(book)).collect(Collectors.toList());
        return bookResponseDTOList;
    }

    @Override
    public BookResponseDTO addBook(BookRequestDTO bookRequestDTO) {
        Book bookRequest = modelMapper.map(bookRequestDTO, Book.class);
        Book persistedBook = bookRepository.save(bookRequest);
        BookResponseDTO bookResponseDTO = modelMapper.map(persistedBook, BookResponseDTO.class);
        return bookResponseDTO;
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    public BookResponseDTO mapBookEntityToDTO(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setBookId(book.getBookId());
        bookResponseDTO.setName(book.getName());
        bookResponseDTO.setAuthor(book.getAuthor());
        bookResponseDTO.setAmount(book.getAmount());
        bookResponseDTO.setPublisher(book.getPublisher());
        bookResponseDTO.setLanguage(book.getLanguage());
        return bookResponseDTO;
    }
}
