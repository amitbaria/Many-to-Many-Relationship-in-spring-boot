package com.example.ManytoManyRelationship;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ManytoManyRelationship.model.BookPojo;
import com.example.ManytoManyRelationship.model.PublisherPojo;
import com.example.ManytoManyRelationship.repository.*;
@SpringBootApplication
public class ManytoManyRelationshipApplication implements CommandLineRunner {

	@Autowired
	private BookRepository  bookRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ManytoManyRelationshipApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
		
        // Create a couple of Book and Publisher
        bookRepository.save(new BookPojo("Book 1", new PublisherPojo("Publisher A"), new PublisherPojo("Publisher B")));
        bookRepository.save(new BookPojo("Book 1", new PublisherPojo("Publisher A"), new PublisherPojo("Publisher B")));
        bookRepository.save(new BookPojo("Book1234", new PublisherPojo("Publisher A"), new PublisherPojo("Publisher B")));
     
        bookRepository.save(new BookPojo("Book1234", new PublisherPojo("Publisher A"), new PublisherPojo("Publisher B")));
		
	
	
		
	
	  
		
	
		
		
		   
		   
		
    }

}
