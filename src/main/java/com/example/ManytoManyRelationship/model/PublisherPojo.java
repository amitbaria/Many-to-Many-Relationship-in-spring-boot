package com.example.ManytoManyRelationship.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="PUBLISHER")
public class PublisherPojo 
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="PUBLISHERID")
    private  int publisherid;
   
    @Column(name="PUBLISHERNAME")
    private  String publishername;
   
   // step 1
    @ManyToMany(mappedBy = "publishers")
    private Set<BookPojo>  books=new HashSet<BookPojo>();
    
    public Set<BookPojo> getBooks() {
		return books;
	}




	public void setBooks(Set<BookPojo> books) {
		this.books = books;
	}




// step 2
  public  PublisherPojo(String publishername)
  {
	  this.publishername=publishername;
	  
  }
    
    
    
   
   public int getPublisherid() {
	return publisherid;
}
public void setPublisherid(int publisherid) {
	this.publisherid = publisherid;
}
public String getPublishername() {
	return publishername;
}
public void setPublishername(String publishername) {
	this.publishername = publishername;
}

	
	

}
