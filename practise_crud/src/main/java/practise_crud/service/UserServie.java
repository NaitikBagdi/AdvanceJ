package practise_crud.service;

import java.util.List;

import practise_crud.model.User;

public interface UserServie {

	public void createUser(User user);

	public List<User> getUserList();

	public void deleteUser(Long id);

	public User getUserById(Long id);

	public boolean existMobileNumber(String mobileNumber, Long userId);

	public void updateUser(Long id, String firstName, String lastName, String dateOfBirth, String mobile, String address1, String address2, Integer age, String gender, String email);

	public boolean existUserEmail(String email, Long userId);
}