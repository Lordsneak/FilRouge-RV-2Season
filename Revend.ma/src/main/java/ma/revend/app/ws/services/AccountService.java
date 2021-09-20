package ma.revend.app.ws.services;

import java.util.List;

import ma.revend.app.ws.entity.AppRole;
import ma.revend.app.ws.entity.AppUser;
import ma.revend.app.ws.shared.dto.UserDto;

public interface AccountService {
    public AppUser saveUser(String username, String password, String email, String address, String firstName, String lastName);
    public AppRole save(AppRole role);
    public AppUser loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    
	List<UserDto> getUsers(int page, int limit);
	UserDto getUser(String email);
	UserDto getUserByUserId(String id);
	UserDto updateUser(String id, UserDto userDto);
	void deleteUser(String userId);
	
	UserDto activeUser(String id, UserDto userDto);
}
