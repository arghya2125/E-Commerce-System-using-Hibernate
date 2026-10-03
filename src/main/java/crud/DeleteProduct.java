package crud;


import entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteProduct {

	private SessionFactory sessionFactory;

	public DeleteProduct(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//get the product
		Product product=session.get(Product.class, 3);

		//delete the product
		session.remove(product);

		//commit the transaction
		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Product is deleted successfully");
	}
}
