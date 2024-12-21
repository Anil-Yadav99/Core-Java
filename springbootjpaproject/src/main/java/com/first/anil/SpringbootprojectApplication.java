package com.first.anil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.first.anil.dao.UserRepository;
import com.first.anil.entities.User;

@SpringBootApplication
public class SpringbootprojectApplication {

    public static void main(String[] args) {
        // Use ConfigurableApplicationContext for better compatibility
        ConfigurableApplicationContext context = SpringApplication.run(SpringbootprojectApplication.class, args);
        
        // Get the UserRepository bean from the application context
        UserRepository userRepository = context.getBean(UserRepository.class);
        
        // Create and set values for a new User entity
        //Saving single user
    /*    User user = new User();
        user.setName("Anil Yadav");
        user.setCity("Jaunpur");
        user.setStatus("Active");
        
        User user1 = new User();
        user1.setName("Jyoti Yadav");
        user1.setCity("Jaunpur");
        user1.setStatus("Active");
        // Save the user entity using the repository
     
        
        // save multiple users
        List<User> u=List.of(user,user1);
        userRepository.saveAll(u);
        
        System.out.println("User saved successfully!");*/
        
        // update userid 2
 /*       Optional<User> user=userRepository.findById(2);
        
        User u=user.get();
        u.setName("Jyoti Yadav");
        userRepository.save(u); */
        
     // retrive the data 
//        Iterable<User> itr=userRepository.findAll();
//        Iterator<User> itrator=itr.iterator();
//        while(itrator.hasNext())
//        {
//        	User user=itrator.next();
//        	System.out.println(user);
//        }
        
        // deleting the user 
        
        userRepository.deleteById(1);
/*
 Default Methods given by CrudRepository
 findAllById()
 findById()
 findAll()
*/      
        
 /*
  * data by name
  * data by name and password
  * data by prefix and suffix
 */
        
 /*
  Custom finder methods 
 */
  
        List<User> users=userRepository.findByName("Jyoti Yadav");
        users.forEach(e->System.out.println(e));
        List<User> cities=userRepository.findByCity("Jaunpur");
        cities.forEach(e->System.out.println(e));
        List<User> nameCities=userRepository.findByNameAndCity("Jyoti Yadav", "Jaunpur");
        nameCities.forEach(e->System.out.println(e));
        List<User> city=userRepository.findByCityStartingWith("jau");
        city.forEach(e->System.out.println(e));
        
/*
 * Query
 * JPQL Query Java persistent query language
 * native query
 */
        List<User> allUsers=userRepository.getAllUser();
        allUsers.forEach(e->System.out.println(e));
        
        List<User> userName=userRepository.getUserByNameAndCityNative("Jyoti Yadav","Jaunpur");
        userName.forEach(e->System.out.println(e));
        

        
    }
}
