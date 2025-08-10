package com.bookstore.order.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderDTO {
    private Long id;
    private Long userId;
    private Long bookId;
    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    public OrderDTO() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;

    }
}