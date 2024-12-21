package com.first.anil.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.first.anil.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>{

	public List<User> findByCity(String name);
	
	public List<User> findByName(String name);
	
	public List<User> findByNameAndCity(String name,String city);
	
	public List<User> findByCityStartingWith(String prefix);
	
	@Query("select u from User u")
	public List<User> getAllUser();
	
	@Query("SELECT u.name, COUNT(u) FROM User u WHERE u.name = :n AND u.city = :c")
	public List<User> getUserByNameAndCity(@Param("n") String name, @Param("c") String city);

	
	@Query(value = "SELECT * FROM user WHERE name = :n AND city = :c", nativeQuery = true)
	public List<User> getUserByNameAndCityNative(@Param("n") String name, @Param("c") String city);

}
