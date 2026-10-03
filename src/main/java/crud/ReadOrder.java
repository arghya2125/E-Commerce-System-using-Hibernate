package crud;


import entity.OrderDetails;
import entity.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadOrder {

	private SessionFactory sessionFactory;

	public ReadOrder(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//get the order
		Orders order=session.get(Orders.class, 1);

		//display order information
		System.out.println("Order ID: " + order.getId());
		System.out.println("Order Date: " + order.getOrderDate());
		System.out.println("Total Amount: " + order.getTotalAmount());

		//display user information
		System.out.println("Username: " + order.getUser().getUsername());
		System.out.println("Email: " + order.getUser().getEmail());

		//display order details
		for(OrderDetails orderDetails : order.getOrderDetails()) {

			System.out.println("Product: "
					+ orderDetails.getProduct().getName());

			System.out.println("Quantity: "
					+ orderDetails.getQuantity());

			System.out.println("Unit Price: "
					+ orderDetails.getUnitPrice());
		}

		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Order is read successfully");
	}
}