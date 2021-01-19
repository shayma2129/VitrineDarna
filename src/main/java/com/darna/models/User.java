package com.darna.models;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	//@NotBlank
	@Size(max = 20)
	private String nom;
	
	//@NotBlank
	@Size(max = 20)
	private String prenom;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

    
  
    private boolean enabled;
    private String fonction;
    private String dateNaissance;
    Calendar dateInscription  = Calendar.getInstance();
    
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	 @Column(name="PATH")
		private String path;
		/**
		 * file
		 */
		 @Column
		 @Lob
		 private byte[] file;

	

			@JsonIgnore
		    @OneToMany(mappedBy = "user")
		    Set<UserAction> userAction;
				 
		    
		    @JsonIgnore
		    @OneToMany(mappedBy = "user")
		    Set<UserCommentaireAction> userCommentaireAction;

	public User(Long id, @NotBlank @Size(max = 20) String username,@NotBlank @Size(max = 20) String nom, @NotBlank @Size(max = 20) String prenom,  @NotBlank @Size(max = 50) @Email String email,
			 @NotBlank @Size(max = 120) String password,	boolean enabled , Set<Role> roles , String fonction  , String dateNaissance, 	Calendar dateInscription,String path, byte[] file) {
		super();
		this.id = id;
		this.username = username;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
		this.fonction=fonction;
		this.dateNaissance=dateNaissance;
		this.dateInscription = dateInscription;
		this.path = path;
		this.file = file;

	}

	











	public Calendar getDateInscription() {
		return dateInscription;
	}













	public void setDateInscription(Calendar dateInscription) {
		this.dateInscription = dateInscription;
	}













	public User(Object id2, String username2, String email2, String encode, boolean enabled2, Object roles2,
			String description2, String date2) {
		super();
		// TODO Auto-generated constructor stub
	}






	public User() {
		super();
		// TODO Auto-generated constructor stub
	}






	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}






	public String getNom() {
		return nom;
	}






	public void setNom(String nom) {
		this.nom = nom;
	}






	public String getPrenom() {
		return prenom;
	}






	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}






	public String getFonction() {
		return fonction;
	}






	public void setFonction(String fonction) {
		this.fonction = fonction;
	}






	public String getDateNaissance() {
		return dateNaissance;
	}






	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}






	public String getPath() {
		return path;
	}






	public void setPath(String path) {
		this.path = path;
	}






	public byte[] getFile() {
		return file;
	}






	public void setFile(byte[] file) {
		this.file = file;
	}
	






	












	













	

}
