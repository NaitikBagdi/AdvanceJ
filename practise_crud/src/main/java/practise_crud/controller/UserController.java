package practise_crud.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import practise_crud.model.User;
import practise_crud.service.UserServie;

@Controller
public class UserController {

	@Autowired
	private UserServie userService;

	@RequestMapping("/")
	public String homePage(Model model) {
		List<User> userList = userService.getUserList();
		model.addAttribute("users", userList);
		return "index";
	}

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public String updateUser(@RequestParam("id") Long id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("dateOfBirth") String dob,
			@RequestParam("mobile") String mobile, @RequestParam("address1") String address1,
			@RequestParam("address2") String address2, @RequestParam("age") int age,
			@RequestParam("gender") String gender, @RequestParam("email") String email, Model model) {

		if (userService.existUserEmail(email, id)) {
			model.addAttribute("errorMessage", "Email already exists!");
			return "update_form";
		} else if (userService.existMobileNumber(mobile, id)) {
			model.addAttribute("errorMessage", "Mobile number already exists!");
			return "update_form";
		}

		try {
			userService.updateUser(id, firstName, lastName, dob, mobile, address1, address2, age, gender, email);
			model.addAttribute("successMessage", "User updated successfully!");
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error updating user: ");
		}

		return "update_form";
	}

	// Save user and check email id exist or not
	@RequestMapping(value = "/list-user", method = RequestMethod.POST)
	public String saveUser(@RequestParam("mobile") String mobile, @RequestParam("email") String email, User user,
			Model model) {
		Long id = 0l;
		if (userService.existUserEmail(email, id)) {
			model.addAttribute("errorMessage", "Email already exists!");
			return "add_user";
		} else if (userService.existMobileNumber(mobile, id)) {
			model.addAttribute("errorMessage", "Mobile number already exists!");
			return "add_user";
		}

		try {
			userService.createUser(user);
			model.addAttribute("successMessage", "Add successfully!");
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Error adding user: " + e.getMessage());
		}

		return "add_user";
	}

	@RequestMapping("/add-user")
	public String addUser(Model model) {
		model.addAttribute("title", "Add product");
		return "add_user";
	}

	@RequestMapping("/delete/{userId}")
	public RedirectView deleteUser(@PathVariable("userId") Long id, HttpServletRequest request) {
		this.userService.deleteUser(id);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/update/{userId}")
	public String updateDataRetrive(@PathVariable("userId") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "update_form";
	}

}