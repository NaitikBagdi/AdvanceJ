package practise_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import practise_crud.model.User;
import practise_crud.repository.UserRepository;

@Service
@Repository
public class UserServiceImpl implements UserServie {

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public void createUser(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(Long id) {
		Optional<User> op = userRepository.findById(id);
		User user = op.get();
		return user;
	}

	@Override
	public void updateUser(Long id, String firstName, String lastName, String dateOfBirth, String mobile, String address1, String address2, Integer age, String gender, String email) {
		 if (existUserEmail(email, id) || existMobileNumber(mobile, id)) {
		        throw new IllegalArgumentException("Email is already in use by another user.");
		    }
		
		// Update user logic
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dateOfBirth);
        user.setMobile(mobile);
        user.setAddress1(address1);
        user.setAddress2(address2);
        user.setAge(age);
        user.setGender(gender);
        user.setEmail(email);
        userRepository.save(user);
    }

	@Override
	public boolean existUserEmail(String email, Long userId) {
		return userRepository.existsByEmail(email , userId);
	}

	@Override
	public boolean existMobileNumber(String mobileNumber, Long userId) {
		return userRepository.existsByMobileNumber(mobileNumber, userId);
	}
}