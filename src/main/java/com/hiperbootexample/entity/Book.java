package com.hiperbootexample.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hiperboot.db.persistence.RetrievalStrategy;
import com.hiperboot.db.persistence.Strategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "author_id")
    @RetrievalStrategy(Strategy.JOIN)
    // RetrievalStrategy it is not a default configuration and should be used only when necessary
    // In this scenario the absence of this annotation will cause the error: Query specified join fetching, but the owner of the fetched association was not present in the select list
    private Author author;
    private BigDecimal price;
    private LocalDateTime published;

    @Column(nullable = false)
    private Boolean deleted;
}