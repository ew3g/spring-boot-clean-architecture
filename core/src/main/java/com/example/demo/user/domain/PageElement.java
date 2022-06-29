package com.example.demo.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageElement<T> implements Serializable {
    private static final long serialVersionUID = 156098353292011161L;

    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private List<T> data;
}
