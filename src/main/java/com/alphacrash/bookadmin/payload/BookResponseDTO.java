package com.alphacrash.bookadmin.payload;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookResponseDTO {
    private Long bookId;
    private String name;
    private String author;
    private BigDecimal amount;
    private String publisher;
    private String language;
}
