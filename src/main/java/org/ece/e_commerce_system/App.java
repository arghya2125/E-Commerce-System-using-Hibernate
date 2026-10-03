package org.ece.e_commerce_system;


import crud.CreateCategory;
import crud.CreateProduct;
import crud.CreateUser;
import crud.CreateOrder;
import crud.ReadOrder;
import crud.UpdateProduct;
import crud.DeleteProduct;

import entity.Category;
import entity.Product;
import entity.Users;
import entity.Orders;
import entity.OrderDetails;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		//create an object of configuration class and pass the .xml file

		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Category.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Users.class)
				.addAnnotatedClass(Orders.class)
				.addAnnotatedClass(OrderDetails.class)
				.buildSessionFactory();

		//create the objects of CRUD classes

		//new CreateCategory(sessionFactory);

		//new CreateProduct(sessionFactory);

		//new CreateUser(sessionFactory);

		new CreateOrder(sessionFactory);

		//new ReadOrder(sessionFactory);

		//new UpdateProduct(sessionFactory);

		//new DeleteProduct(sessionFactory);

		
	}
}
