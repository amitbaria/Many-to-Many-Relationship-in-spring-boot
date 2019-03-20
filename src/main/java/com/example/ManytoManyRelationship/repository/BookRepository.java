package com.example.ManytoManyRelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManytoManyRelationship.model.BookPojo;

@Repository
public interface BookRepository extends JpaRepository<BookPojo,Integer>{

}
