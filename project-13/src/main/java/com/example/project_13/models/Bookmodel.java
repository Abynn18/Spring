package com.example.project_13.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity 
public class Bookmodel {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer id;
    private String BookTitle;
    private String AuthorName;
    private Float price;
	
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook() {
        return BookTitle;
    }

    public void setBook(String name) {
        this.BookTitle = name;
    }

    public String getAuthor() {
        return AuthorName;
    }

    public void setAuthor(String author) {
        this.AuthorName = author;
    }

    public Float getPrice() {
        return price;
    }	
    public void setPrice(Float price) {
        this.price = price;
    }
}