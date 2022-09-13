package com.jpa.test;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.emtities.User;

@SpringBootApplication
public class BootjpaexampleApplication{
	/**
	 * @param args
	 */
	public static void main(String args[])
	{
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		//Creating user
		User user1 = new User();
		user1.setName("Ram");
		user1.setCity("Lucknow");
		user1.setStatus("Manager");
		
		User user2 = new User();
		user2.setName("Sham");
		user2.setCity("Bijapur");
		user2.setStatus("Supervisor");
		
		
//		//Saving a single user
//		//User resultUser = userRepository.save(user1);
//		
//		//Saving multiple users
//		List<User> users = List.of(user1,user2);
//		Iterable<User> result = userRepository.saveAll(users);
//		
//		result.forEach(user->{
//			System.out.println(user);
//		});
//		
//		//System.out.println("Saved user " + resultUser);
//		System.out.println("Data saved successfully");
		
		//Update the user by using ID		
//		Optional<User> optional = userRepository.findById(4);
//		User user = optional.get();		
//		user.setName("Sham Kumar");
//		User result = userRepository.save(user);		
//		System.out.println(result);

		//Display all data.
//		Iterable<User> itr = userRepository.findAll();
//Method 1
//		itr.forEach(user->{System.out.println(user);});		

//Method 2
//		Iterator<User> iterator = itr.iterator();
//		while(iterator.hasNext())
//		{
//			User user = iterator.next();
//			System.out.println(user);
//		}

//Method 3
//		itr.forEach(new Consumer<User>() {
//			@Override
//			public void accept(User t) {
//				System.out.println(t);
//			}
//		});
		
		//Deleting a single user
//		userRepository.deleteById(4);
//		System.out.println("Data deleted successfully!");
		
		//Deleting all users
//		Iterable<User> AllUsers = userRepository.findAll();
//		AllUsers.forEach(user->System.out.println(user));
//		userRepository.deleteAll(AllUsers);
///////////////////////////////////////////////////////////////////////////		
		//Custom Finder Method / Derived Query Methods.
//		List<User> users = userRepository.findByName("Sagar Shinde");
//		users.forEach(e->System.out.println(e));
	
//		List<User> users = userRepository.findByNameAndCity("Sagar Shinde", "Pune");
//		users.forEach(e->System.out.println(e));
//Similarly below methods can be used,
		//findByNameStartingWith(String prefix)
		//findByNameEndingWith(String suffix)
		//findByNameContaining(String words)
		//findByNameLike(String likePattern)
		//findAgeLessThan(int age)

//Executing JPQL
//		List<User> allUser = userRepository.getAllUser();
//		allUser.forEach(e->{System.out.println(e);});
//		
//		List<User> UserByName = userRepository.getUserByName("Sagar Shinde", "Pune");
//		UserByName.forEach(e->{System.out.println(e);});
		
//Executing native queries
//		List<User> allUser = userRepository.getAllUser();
//		allUser.forEach(e->{System.out.println(e);});
		
		//or
		userRepository.getAllUser().forEach(e->System.out.println(e));
		
		
	}
}
