package com.SpringFramework5.SpringBootDemo.bootstrap;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.SpringFramework5.SpringBootDemo.model.Author;
import com.SpringFramework5.SpringBootDemo.model.Book;
import com.SpringFramework5.SpringBootDemo.model.Publisher;
import com.SpringFramework5.SpringBootDemo.repositories.AuthorRepository;
import com.SpringFramework5.SpringBootDemo.repositories.BookRepository;
import com.SpringFramework5.SpringBootDemo.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(
			AuthorRepository authorRepository, 
			BookRepository bookRepository, 
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Book a = new Book("Silmarillion", "123456789");
		Book b = new Book("The Fellowship", "223456788");
		Book c = new Book("The Two Towers", "323456787");
		Book d = new Book("The Return of the King", "123456789");
		Book e = new Book("The Hobbit", "323456787");
		
		Author john = new Author("JRR", "Tolkien");
		Author chris = new Author("Christopher", "Tolkien");
		
		Publisher tree = new Publisher("Old Tree Editions", "East Road", "Cambridge", "England", 28678);
		Publisher volt = new Publisher("Voltage Books", "Downhill Road", "Oxford", "England", 29008);
		
		// Save repositories
		authorRepository.save(john);
		authorRepository.save(chris);
		bookRepository.save(a);
		bookRepository.save(b);
		bookRepository.save(c);
		bookRepository.save(d);
		bookRepository.save(e);
		publisherRepository.save(tree);
		publisherRepository.save(volt);
		
		// Add books to authors
		john.getBooks().add(d);
		john.getBooks().add(b);
		john.getBooks().add(c);
		john.getBooks().add(e);
		john.getBooks().add(a);
		chris.getBooks().add(a);
		
		// Add authors to books
		a.getAuthors().add(john);
		b.getAuthors().add(john);
		c.getAuthors().add(john);
		d.getAuthors().add(john);
		e.getAuthors().add(john);
		a.getAuthors().add(chris);
		
		// Add Publishers to books
		a.setPublisher(tree);
		b.setPublisher(tree);
		c.setPublisher(tree);
		d.setPublisher(tree);
		e.setPublisher(tree);
		
		// Add authors to publishers
		tree.getAuthors_p().add(john);
		tree.getAuthors_p().add(chris);
		volt.getAuthors_p().add(chris);
		
		// Add books to publishers
		tree.getBooks_p().add(a);
		tree.getBooks_p().add(b);
		tree.getBooks_p().add(c);
		tree.getBooks_p().add(d);
		tree.getBooks_p().add(e);		
		
		// Save repositories
		authorRepository.save(john);
		authorRepository.save(chris);
		bookRepository.save(a);
		bookRepository.save(b);
		bookRepository.save(c);
		bookRepository.save(d);
		bookRepository.save(e);
		publisherRepository.save(tree);
		publisherRepository.save(volt);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of Authors: " + authorRepository.count());
		System.out.println("Number of Publishers: " + publisherRepository.count());
		
		
	}

}
