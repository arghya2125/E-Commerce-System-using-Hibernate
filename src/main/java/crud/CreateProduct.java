package crud;


import java.math.BigDecimal;

import entity.Category;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateProduct {

	private SessionFactory sessionFactory;

	public CreateProduct(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//create the object of Category
		Category category=session.get(Category.class, 1);

		//create the object of Product
		Product product=new Product(
				"Laptop",
				new BigDecimal("55000.00"),
				10,
				category
		);

		//save the object
		session.persist(product);

		//second object
		product=new Product(
				"Mobile Phone",
				new BigDecimal("25000.00"),
				20,
				category
		);

		//save the object
		session.persist(product);

		//third object
		product=new Product(
				"Headphones",
				new BigDecimal("2000.00"),
				30,
				category
		);

		//save the object
		session.persist(product);

		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Product is created successfully");
	}
}
