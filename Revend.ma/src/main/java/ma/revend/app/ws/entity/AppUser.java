package ma.revend.app.ws.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

import org.hibernate.annotations.CreationTimestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Set;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = false)
    private String userId;
    
    @Column(unique = true) // Switch = True
    private String username;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @Column
    private boolean actived;
	
	@Column(nullable=true)
	private String emailVerificationToken;
	
	@Column(nullable=false)
	private Boolean emailVerificationStatuts=false;
	
	@Email
	@Column(nullable=false, length=50,unique = false)
	private String email;
	
	@Column(nullable = false, unique = false, length = 120)
	private String address;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    private Set<AdvertEntity> advertEntities;
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;

    
    @Column(nullable = false)
    private String type;
    

	@Column(nullable=false)
	private Boolean userValid = false;

	
	@CreationTimestamp
    private Date createTime;
    
    
    
}
