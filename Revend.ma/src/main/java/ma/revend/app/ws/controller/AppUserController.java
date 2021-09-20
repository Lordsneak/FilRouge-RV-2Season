package ma.revend.app.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ma.revend.app.ws.reponse.UserResponse;
import ma.revend.app.ws.request.UserRequest;
import ma.revend.app.ws.services.AccountService;
import ma.revend.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("/appusers") // localhost:8080/appusers
public class AppUserController {
	
	@Autowired
	AccountService accountService;
	
	@GetMapping(produces = {MediaType.APPLICATION_XML_VALUE ,MediaType.APPLICATION_JSON_VALUE })  //List All Users
	public List<UserResponse> getAllUsers(@RequestParam(value="page", defaultValue = "1") int page,@RequestParam(value="limit" , defaultValue = "10") int limit) {
		
		List<UserResponse> userResponse = new ArrayList<>();
		
	List<UserDto> users = accountService.getUsers(page, limit);
		
	for(UserDto userDto: users) {
		UserResponse user = new UserResponse();
		
		BeanUtils.copyProperties(userDto, user);
		
		userResponse.add(user);
	}
		return userResponse;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserResponse> getUser(@PathVariable String id) {

		UserDto userDto = accountService.getUserByUserId(id);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(userDto, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<UserResponse> updateUser(@PathVariable String id, @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = accountService.updateUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
	}
	
	@PutMapping(path = "/activeuser/{id}")
	public ResponseEntity<UserResponse> activeUser(@PathVariable String id, @RequestBody UserRequest userRequest) {

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userRequest, userDto);

		UserDto updateUser = accountService.activeUser(id, userDto);

		UserResponse userResponse = new UserResponse();

		BeanUtils.copyProperties(updateUser, userResponse);

		return new ResponseEntity<UserResponse>(userResponse, HttpStatus.ACCEPTED);
	}
	

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable String id) {

		accountService.deleteUser(id);

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
