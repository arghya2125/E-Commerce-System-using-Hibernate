package crud;

import java.math.BigDecimal;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateProduct {

	private SessionFactory sessionFactory;

	public UpdateProduct(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//get the product
		Product product=session.get(Product.class, 1);

		//update the product details
		product.setName("Gaming Laptop");
		product.setPrice(new BigDecimal("65000.00"));
		product.setStockQuantity(15);

		//commit the transaction
		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Product is updated successfully");
	}
}