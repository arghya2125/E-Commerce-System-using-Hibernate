package 
entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//to annotate this class as an entity using JPA annotations
@Entity

//there should be a table in the database with name "category"
@Table(name="category")
public class Category {

	//1. create member variables for the entity class
	//2. annotate the member variables with JPA annotations
	//3. one member variable should be the primary key
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name",length=50,nullable=false,unique=true)
	private String name;
	
	@Column(name="description",length=200)
	private String description;
	
	//One Category can have many Products
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<>();

	//create a default constructor
	public Category() {
		super();
		this.id=0;
		this.name=null;
		this.description=null;
	}

	//create a parameterized constructor
	public Category(String name, String description) {
		super();
		this.name=name;
		this.description=description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products=products;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
}