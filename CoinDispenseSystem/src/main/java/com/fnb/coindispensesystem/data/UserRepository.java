package com.fnb.coindispensesystem.data;

/**
 * 
 * @author Benny Pholo
 */

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.fnb.coindispensesystem.model.Users;

@ApplicationScoped
public class UserRepository {

	@Inject
	private EntityManager em ;
	
	public boolean findUser(String username, String password){
	 boolean found = false; 
	 CriteriaBuilder cb = em.getCriteriaBuilder();
	 CriteriaQuery<Users> criteriaQuery = cb.createQuery(Users.class);
	 Root<Users> userRoot = criteriaQuery.from(Users.class); 
	 
	 //Select from users where username=username and password=password;	 
	 CriteriaQuery<Users> select = criteriaQuery.select(userRoot);
	 TypedQuery<Users> typedQuery = em.createQuery(select);
	 List<Users> resultsList = typedQuery.getResultList();
	 
	 for (Object u : resultsList){
		 Users user = (Users) u;
		 if (user.getUsername().equals(username) && user.getPassword().equals(password)){
			 found = true;
			 break;
		 }
	 }	 
	 //criteriaQuery.select(userRoot).where(cb.equal(userRoot.get("username"), username));		
		return found;		
	}
	
	public List<Users> lookupUsers(){
		 boolean found = false; 
		 CriteriaBuilder cb = em.getCriteriaBuilder();
		 CriteriaQuery<Users> criteriaQuery = cb.createQuery(Users.class);
		 Root<Users> userRoot = criteriaQuery.from(Users.class); 
		 
		 //Select from users where username=username and password=password;	 
		 CriteriaQuery<Users> select = criteriaQuery.select(userRoot);
		 TypedQuery<Users> typedQuery = em.createQuery(select);
		 List<Users> resultsList = typedQuery.getResultList();
		 
		 for (Object u : resultsList){
			 Users user = (Users) u;		 
			 System.out.println("Username"+user.getUsername());
		 }	 
		 //criteriaQuery.select(userRoot).where(cb.equal(userRoot.get("username"), username));		
			return resultsList;		
		}
	
}
