package com.anilnayak.springboot.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.anilnayak.springboot.model.UserInfo;

@Repository
@Transactional
@EntityScan("com.anilnayak.springboot.model")
public class UserInfoDAO implements IUserInfoDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	
	public UserInfo getActiveUser(String userName) {
		UserInfo activeUserInfo = new UserInfo();
		short enabled = 1;
		List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=? and enabled=?")
				.setParameter(1, userName).setParameter(2, enabled).getResultList();
		if(!list.isEmpty()) {
			activeUserInfo = (UserInfo)list.get(0);
		}
		return activeUserInfo;
	}
} 