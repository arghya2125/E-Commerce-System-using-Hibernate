package entity;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//to annotate this class as an entity using JPA annotations
@Entity

//there should be a table in the database with name "product"
@Table(name="product")
public class Product {
	//1. create member variables for the entity class
		//2. annotate the member variables with JPA annotations
		//3. one member variable should be the primary key
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name",length=100,nullable=false)
		private String name;
		
		@Column(name="price",precision=10,scale=2,nullable=false)
		private BigDecimal price;
		
		@Column(name="stock_quantity")
		private int stockQuantity;
		
		//Many Products can belong to One Category
		@ManyToOne
		@JoinColumn(name="category_id",nullable=false)
		private Category category;

		//create a default constructor
		public Product() {
			super();
			this.id=0;
			this.name=null;
			this.price=null;
			this.stockQuantity=0;
			this.category=null;
		}

		//create a parameterized constructor
		public Product(String name, BigDecimal price, int stockQuantity, Category category) {
			super();
			this.name=name;
			this.price=price;
			this.stockQuantity=stockQuantity;
			this.category=category;
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

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price=price;
		}

		public int getStockQuantity() {
			return stockQuantity;
		}

		public void setStockQuantity(int stockQuantity) {
			this.stockQuantity=stockQuantity;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category=category;
		}

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price
					+ ", stockQuantity=" + stockQuantity + "]";
		}
}
