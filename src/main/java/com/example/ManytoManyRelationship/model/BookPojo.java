package com.example.ManytoManyRelationship.model;



import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

@Entity
@Table(name="BOOK")
public class BookPojo 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="BOOKID")
	private int bookid;
	
	
	@Column(name="BOOKNAME")
	private String bookname;
	
	
	
	public BookPojo()
	{}
	
	public BookPojo(String bookname)
			{
	    	this.bookname=bookname;
		
			}
	
	
	
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
	/*  for Many to many Relationship................*/
	
	//Step 1
	@ManyToMany(cascade = CascadeType.ALL)
    //step 2
	@JoinTable(name = "BOOK_PUBLISHER",
               joinColumns = @JoinColumn(name = "FORGIENERBOOKID", referencedColumnName = "BOOKID"),
               inverseJoinColumns = @JoinColumn(name = "FORGIENERPUBLISHERID", referencedColumnName = "PUBLISHERID"))
    
	//step 3 for Second Table(which is inverse table)
	private Set<PublisherPojo> publishers;
	
	
  
	
	// step 4
    public BookPojo(String bookname, PublisherPojo ...publis) {
        this.bookname = bookname;
        // Convert array of Publisher Objects into  Set of Collections
        this.publishers = Stream.of(publis).collect(Collectors.toSet());
        
        
         // use this line if compiler JDK above 7
      //  this.publishers.forEach(x -> x.getBooks().add(this));
       
        
        //  old technique
         Iterator it=this.publishers.iterator();
        
         while(it.hasNext()) 
         {
        	 PublisherPojo  pojo  =  (PublisherPojo)it.next();
        	 Set<BookPojo>  s=pojo.getBooks();
        	 s.add(this);
         }
        
        
        
        
    }
	
	

}
