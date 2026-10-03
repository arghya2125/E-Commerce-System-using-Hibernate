package crud;

import java.math.BigDecimal;
import java.sql.Timestamp;

import entity.OrderDetails;
import entity.Orders;
import entity.Product;
import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateOrder {

	private SessionFactory sessionFactory;

	public CreateOrder(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//get the user
		Users user=session.get(Users.class, 1);

		//get the products
		Product product1=session.get(Product.class, 1);
		Product product2=session.get(Product.class, 2);

		//create the order
		Orders order=new Orders(
				new Timestamp(System.currentTimeMillis()),
				new BigDecimal("55000.00"),
				user
		);

		//save the order
		session.persist(order);

		//create first order detail
		OrderDetails orderDetails1=new OrderDetails(
				1,
				new BigDecimal("25000.00"),
				order,
				product1
		);

		//save the first order detail
		session.persist(orderDetails1);

		//create second order detail
		OrderDetails orderDetails2=new OrderDetails(
				1,
				new BigDecimal("30000.00"),
				order,
				product2
		);

		//save the second order detail
		session.persist(orderDetails2);

		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Order is created successfully");
	}
}
