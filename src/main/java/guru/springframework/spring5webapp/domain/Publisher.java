package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String city;
	private String state;
	private String zip;
	
	@OneToMany(mappedBy = "publisher")
	private Set<Book> book = new HashSet<>();
	
	public Publisher() {
	}
	
	
	public Publisher(Long id, String addressLine1, String city, String state, String zip) {
		this.id = id;
		this.name = addressLine1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	
	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state
				+ ", zip=" + zip + ", books=" + book + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}

	public Set<Book> getBooks() {
		return book;
	}


	public void setBooks(Set<Book> books) {
		this.book = books;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publisher other = (Publisher) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
