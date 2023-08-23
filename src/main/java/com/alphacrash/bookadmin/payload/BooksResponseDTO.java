package com.alphacrash.bookadmin.payload;

import lombok.Data;

import java.util.List;

@Data
public class BooksResponseDTO {
    List<BookResponseDTO> books;
}
