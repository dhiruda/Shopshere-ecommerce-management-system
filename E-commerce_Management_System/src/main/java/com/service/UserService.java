package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository urepo;

	// Save User
	public User saveUser(User user) {
		return urepo.save(user);
	}

	// Save all users
	public List<User> saveAll(List<User> users) {
		return urepo.saveAll(users);
	}

	// Get all users
	public List<User> getAllUsers() {
		return urepo.findAll();
	}

	// Get user by id
	public Optional<User> getUserById(int eid) {
		return urepo.findById(eid);
	}

	// Update user
	public User updateUser(int eid, User user) {

		Optional<User> existingUser = urepo.findById(eid);

		if (existingUser.isPresent()) {
			User u = existingUser.get();

			u.setEname(user.getEname());
			u.setEmail(user.getEmail());
			u.setPassword(user.getPassword());

			return urepo.save(u);
		}

		return null;
	}

	// Delete user
	public void deleteUser(int eid) {
		urepo.deleteById(eid);
	}

	// ------------------------------
	// LOGIN METHOD (NEW)
	// ------------------------------

	public User loginUser(String email, String password) {

		User user = urepo.findByEmailAndPassword(email, password);

		if (user != null) {
			return user;
		}

		throw new RuntimeException("Invalid Email or Password");
	}

}