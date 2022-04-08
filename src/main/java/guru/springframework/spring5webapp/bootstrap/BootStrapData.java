package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		Publisher publisher = new Publisher();
		publisher.setName("SFG Publishing");
		publisher.setCity("St' Petersburg");
		publisher.setZip("FL");
		
		Author eric = new Author("Eric","Evans");
		Book ddd = new Book("Domain Driven Design", "123123");
		
		ddd.setPublisher(publisher);
		publisher.getBooks().add(ddd);
		
		ddd.getAuthors().add(eric);
		eric.getBooks().add(ddd);
		authorRepository.save(eric);
		publisherRepository.save(publisher);
		bookRepository.save(ddd);
		
		
		Author rod = new Author("Rod","Johnson");
		Book noEJB = new Book("J2EE development without EJB", "3254564821");
		
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);
		
		noEJB.setPublisher(publisher);
		publisher.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		publisherRepository.save(publisher);
		
		System.out.println("Started in Bootstrap");
		System.out.println("Number of Books: " + bookRepository.count());
		System.out.println("Number of books by publisher: " + publisher.getBooks().size());
	}
}
