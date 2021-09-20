package ma.revend.app.ws.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.revend.app.ws.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
	
    public AppUser findByUsername(String username);
    AppUser findByEmail(String email);
    AppUser findByUserId(String id);
	
}
