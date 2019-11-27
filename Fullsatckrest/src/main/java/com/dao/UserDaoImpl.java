package com.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.User;
@Repository
public class UserDaoImpl implements UserDao{
@Autowired //has a relantionship
	private SessionFactory sessionFactory;
	@Override
	public User createUser(User user) {
		Session session=this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user);
		tx.commit();
		return user;
	}

	@Override
	public List<User> readUser() {
		Session session=this.sessionFactory.openSession();
		//HQL
		String readUser="from User";
		List<User> users=session.createQuery(readUser).list();
		return users;
	}

	@Override
	public User readUserById(int userId) {
		Session session=this.sessionFactory.openSession();
		String hqlRead= "FROM User u where userId=:nq";
		List <User> users=session.createQuery(hqlRead).list();
		return users.get(0);
	}

	@Override
	public User readUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		Session session=this.sessionFactory.openSession();
		session.saveOrUpdate(user);
		/*Transaction tx=session.beginTransaction();
		String hql="update User where userId=:ID";
		
		Query query=session.createQuery(hql);
		query.setParameter("name",user.getUsername());
		query.setParameter("ID",user.getPassword());*/
		return user;
		
	}

	@Override
	 public  int deleteUserById(int userId){

		Session session=this.sessionFactory.openSession();
		
		//session.load(User.class,userId);
		Transaction tx=session.beginTransaction();
		String hql="delete from User where userId=:ID";
		
		Query query=session.createQuery(hql);
		query.setParameter("ID","id");
		int res=query.executeUpdate();
		tx.commit();
		return res;
		/*session.load(User.class,new Integer(userId));
		User obj=session.load(User.class,userId);
		session.delete(obj);
		return obj;*/
		
	}

}
