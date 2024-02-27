package com.hiperbootexample.entity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "author")
public class Author {
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    private Date birthday;

    @JsonBackReference
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}