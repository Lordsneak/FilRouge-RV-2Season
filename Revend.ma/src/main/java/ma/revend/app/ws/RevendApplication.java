package ma.revend.app.ws;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.revend.app.ws.entity.AppRole;
import ma.revend.app.ws.services.AccountService;

@SpringBootApplication
public class RevendApplication {

	public static void main(String[] args) {
		SpringApplication.run(RevendApplication.class, args);
	}
	
 /* @Bean
    CommandLineRunner start(AccountService accountService){
        return args->{
            accountService.save(new AppRole(null,"USER"));
            accountService.save(new AppRole(null,"ADMIN"));
            Stream.of("user1","user2","user3","admin").forEach(un->{
                accountService.saveUser(
                      un,  "123456","Hamza1Gh@gmail.com",
                       " Maroc","Hamza","Gh"
                		);
            });
            accountService.addRoleToUser("admin","ADMIN");
        };
    } 
	*/
	@Bean
	public SpringApplicationContext springApplicationContext() {
		return new SpringApplicationContext();
	}
    @Bean
    BCryptPasswordEncoder getBCPE(){
        return new BCryptPasswordEncoder();
    }
    
}
