package com.example.demo.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageElement<T> {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private List<T> data;
}
