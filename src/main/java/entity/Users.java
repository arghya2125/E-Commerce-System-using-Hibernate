package entity;
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

//there should be a table in the database with name "users"
@Table(name="users")
public class Users {
	//1. create member variables for the entity class
		//2. annotate the member variables with JPA annotations
		//3. one of the member variables should be the primary key
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="username",length=50,nullable=false,unique=true)
		private String username;
		
		@Column(name="password",length=255,nullable=false)
		private String password;
		
		@Column(name="email",length=100,nullable=false,unique=true)
		private String email;
		
		@Column(name="role",length=20,nullable=false)
		private String role;
		
		//One User can have many Orders
		@OneToMany(mappedBy="user",
				   cascade=CascadeType.ALL)
		private List<Orders> orders = new ArrayList<>();

		//create a default constructor
		public Users() {
			super();
			this.id=0;
			this.username=null;
			this.password=null;
			this.email=null;
			this.role=null;
		}

		//create a parameterized constructor
		public Users(String username, String password, String email, String role) {
			super();
			this.username=username;
			this.password=password;
			this.email=email;
			this.role=role;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id=id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username=username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password=password;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email=email;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role=role;
		}

		public List<Orders> getOrders() {
			return orders;
		}

		public void setOrders(List<Orders> orders) {
			this.orders=orders;
		}

		@Override
		public String toString() {
			return "Users [id=" + id + ", username=" + username
					+ ", email=" + email + ", role=" + role + "]";
		}
}
