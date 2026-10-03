package crud;

import entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateUser {

	private SessionFactory sessionFactory;

	public CreateUser(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;

		//create the object of the session using the sessionFactory object
		Session session=sessionFactory.getCurrentSession();

		//to work with the session object we have to start the transaction
		session.beginTransaction();

		//create the object of Users
		Users user=new Users(
				"admin",
				"admin123",
				"admin@gmail.com",
				"ADMIN"
		);

		//save the object
		session.persist(user);

		//second object
		user=new Users(
				"customer1",
				"customer123",
				"customer1@gmail.com",
				"CUSTOMER"
		);

		//save the object
		session.persist(user);

		//third object
		user=new Users(
				"customer2",
				"customer123",
				"customer2@gmail.com",
				"CUSTOMER"
		);

		//save the object
		session.persist(user);

		session.getTransaction().commit();

		//close the session object
		session.close(); //detached

		//message
		System.out.println("Users are created successfully");
	}
}
