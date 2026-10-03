package crud;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateCategory {

	private SessionFactory sessionFactory;

	public CreateCategory(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//create the object of Category
		Category category=new Category("Electronics", "Electronic products");

		//save the object
		session.persist(category);

		//second object
		category=new Category("Clothing", "Clothing and fashion products");

		//save the object
		session.persist(category);

		//third object
		category=new Category("Books", "Books and educational products");

		//save the object
		session.persist(category);

		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Category is created successfully");
	}
}