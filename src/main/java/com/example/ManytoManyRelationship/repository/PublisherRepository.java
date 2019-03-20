package com.example.ManytoManyRelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ManytoManyRelationship.model.PublisherPojo;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherPojo,Integer>{

}
