package com.example.springStarter.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="textbook")
public class Textbook implements Serializable{




			private static final long serialVersionUID = 1L;

			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			private int textbook_id;
			private String title;
			private String author;
			private String copyright;
			private String edition;
			private String isbn;
			private String publisher;
			private boolean iscoderequired;
			private boolean isebooksok;
			private String acceptableeditions;


			@OneToMany(targetEntity = ClassOrder.class, mappedBy = "textbook",fetch=FetchType.LAZY, cascade=CascadeType.ALL)
			private Set<ClassOrder> classOrders;


			public Textbook() {
				super();
			}


			public int getTextbook_id() {
				return textbook_id;
			}


			public void setTextbook_id(int textbook_id) {
				this.textbook_id = textbook_id;
			}


			public String getTitle() {
				return title;
			}


			public void setTitle(String title) {
				this.title = title;
			}


			public String getAuthor() {
				return author;
			}


			public void setAuthor(String author) {
				this.author = author;
			}


			public String getCopyright() {
				return copyright;
			}


			public void setCopyright(String copyright) {
				this.copyright = copyright;
			}


			public String getEdition() {
				return edition;
			}


			public void setEdition(String edition) {
				this.edition = edition;
			}


			public String getIsbn() {
				return isbn;
			}


			public void setIsbn(String isbn) {
				this.isbn = isbn;
			}


			public String getPublisher() {
				return publisher;
			}


			public void setPublisher(String publisher) {
				this.publisher = publisher;
			}


			public boolean isIscoderequired() {
				return iscoderequired;
			}


			public void setIscoderequired(boolean iscoderequired) {
				this.iscoderequired = iscoderequired;
			}


			public boolean isIsebooksok() {
				return isebooksok;
			}


			public void setIsebooksok(boolean isebooksok) {
				this.isebooksok = isebooksok;
			}


			public Set<ClassOrder> getClassOrders() {
				return classOrders;
			}


			public void setClassOrders(Set<ClassOrder> classOrders) {
				this.classOrders = classOrders;
			}


			public String getAcceptableeditions() {
				return acceptableeditions;
			}


			public void setAcceptableeditions(String acceptableeditions) {
				this.acceptableeditions = acceptableeditions;
			}



}
