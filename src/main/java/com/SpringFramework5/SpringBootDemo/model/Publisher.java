package com.SpringFramework5.SpringBootDemo.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String address;
	private String city;
	private String country;
	private int zip;
	
	@ManyToMany
	@JoinTable(name = "author_publisher", joinColumns = @JoinColumn(name = "publisher_id"),
			inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors_p = new HashSet<>();
	
	@OneToMany(mappedBy = "publisher")
	private Set<Book> books_p = new HashSet<>();
	
	public Publisher() {}

	public Publisher(String name, String address, String city, String country, int zip) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public Set<Author> getAuthors_p() {
		return authors_p;
	}

	public void setAuthors_p(Set<Author> authors_p) {
		this.authors_p = authors_p;
	}

	public Set<Book> getBooks_p() {
		return books_p;
	}

	public void setBooks_p(Set<Book> books_p) {
		this.books_p = books_p;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", country=" + country + ", zip="
				+ zip + ", authors_p=" + authors_p + ", books_p=" + books_p + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

}
