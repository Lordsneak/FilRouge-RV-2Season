package ma.revend.app.ws.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ma.revend.app.ws.entity.AppRole;
import ma.revend.app.ws.entity.AppUser;
import ma.revend.app.ws.repository.AppRoleRepository;
import ma.revend.app.ws.repository.AppUserRepository;
import ma.revend.app.ws.services.AccountService;
import ma.revend.app.ws.shared.Utils;
import ma.revend.app.ws.shared.dto.UserDto;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
    
	@Autowired
	Utils util;


    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public AppUser saveUser(String username, String password, String email, String address, String firstName, String lastName) {
        AppUser  user=appUserRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        AppUser appUser=new AppUser();
        appUser.setUserId(util.generateStringId(6));
        appUser.setUsername(username);
        appUser.setActived(false);
        appUser.setPassword(bCryptPasswordEncoder.encode(password));
        appUser.setEmail(email);
        appUser.setAddress(address);
        appUser.setFirstName(firstName);
        appUser.setLastName(lastName);
        appUser.setType("FREE");
        appUserRepository.save(appUser);
        addRoleToUser(username,"USER");
        return appUser;
    }

    @Override
    public AppRole save(AppRole role) {
        return appRoleRepository.save(role);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        AppUser appUser=appUserRepository.findByUsername(username);
        AppRole appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoles().add(appRole);
    }

	@Override
	public List<UserDto> getUsers(int page, int limit) {
		if (page > 0)
			page = page - 1;

		List<UserDto> usersDto = new ArrayList<>();

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<AppUser> userPage = appUserRepository.findAll(pageableRequest);

		List<AppUser> users = userPage.getContent();

		for (AppUser appUser : users) {
			UserDto user = new UserDto();

			BeanUtils.copyProperties(appUser, user);

			usersDto.add(user);
		}

		return usersDto;
	}


	@Override
	public UserDto getUser(String email) {
		
		AppUser userEntity = appUserRepository.findByEmail(email);

		if (userEntity == null)
			throw new UsernameNotFoundException(email);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntity, userDto);

		return userDto;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		
		AppUser userEntity = appUserRepository.findByUserId(userId);

		if (userEntity == null)
			throw new UsernameNotFoundException(userId);

		UserDto userDto = new UserDto();

		BeanUtils.copyProperties(userEntity, userDto);

		return userDto;
	}
	

	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		
		AppUser userEntity = appUserRepository.findByUserId(id);

		if (userEntity == null)
			throw new UsernameNotFoundException(id);

		userEntity.setFirstName(userDto.getFirstName());
		userEntity.setLastName(userDto.getLastname());

		AppUser userUpdated = appUserRepository.save(userEntity);

		UserDto user = new UserDto();

		BeanUtils.copyProperties(userUpdated, user);

		return user;
	}

	@Override
	public void deleteUser(String userId) {
		
		AppUser userEntity = appUserRepository.findByUserId(userId);
		
		if(userEntity == null) throw new UsernameNotFoundException(userId); 
		
		appUserRepository.delete(userEntity);
		
	}

	@Override
	public UserDto activeUser(String id, UserDto userDto) {
		
		AppUser userEntity = appUserRepository.findByUserId(id);
		
		if (userEntity == null)
			throw new UsernameNotFoundException(id);

		userEntity.setActived(true);
		
		AppUser userUpdated = appUserRepository.save(userEntity);

		UserDto user = new UserDto();

		BeanUtils.copyProperties(userUpdated, user);

		return user;
	}
    
    
    
    
}
