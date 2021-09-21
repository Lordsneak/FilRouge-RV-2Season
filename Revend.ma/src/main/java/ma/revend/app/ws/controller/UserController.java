package ma.revend.app.ws.controller;


import lombok.Data;
import ma.revend.app.ws.entity.AppUser;
import ma.revend.app.ws.services.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
    @Autowired
    private AccountService accountService;
    
    @PostMapping("/register")
    public AppUser register(@RequestBody UserForm userForm){
        return  accountService.saveUser(
                userForm.getUsername(),userForm.getPassword(),userForm.getEmail(),
                userForm.getAddress(),userForm.getFirstName(),userForm.getLastName()
        		);
    }

}

@Data
class UserForm{

	private String username;
	private String password;
	private String email;
	private String address;
	private String firstName;
	private String lastName;
	
	
}
