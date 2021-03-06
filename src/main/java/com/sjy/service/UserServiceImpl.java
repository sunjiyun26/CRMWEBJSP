package com.sjy.service;

import com.sjy.entities.User;
import com.sjy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
	  
	  @Autowired
	  UserRepository userRepository;
	
	@Override
	public User getByAccount(String account) {
		return this.userRepository.findByAccount(account);
	}
	@Override
	public Page<User> getDepartment_users(int dpId,int page,int size) {
		return this.userRepository.findByDpId(dpId,new PageRequest(page,size));
	}
	@Override
	public void add(User user) {
		this.userRepository.save(user);
		
	}
	@Override
	public void updata(User user) {
     this.userRepository.save(user);		
	}
	@Override
	public User get(int sId) {		
		return this.userRepository.findOne(sId);
	}
	@Override
	public void addUserNumOfDp(int dpId) {		
		this.userRepository.addUserNumOfDp(dpId);
	}
	@Override
	public User getByUsername(String username) {
		return this.userRepository.findByUsername(username);
	}
	@Override
	public void remove(int sId) {
		this.userRepository.delete(sId);
		
	}


}