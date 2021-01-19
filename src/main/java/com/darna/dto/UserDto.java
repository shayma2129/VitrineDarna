package com.darna.dto;



public class UserDto {
	
	private Long id;


	private String username;


	private String nom;
	
	
	private String prenom;
	

	private String email;

	private String password;

    
  
    private boolean enabled;
    private String fonction;
    private String dateNaissance;
    
	/*@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();*/

		private String path;
		/**
		 * file
		 */
		
		 private byte[] file;

	public UserDto() {
			super();
			// TODO Auto-generated constructor stub
		}

	public UserDto(Long id, String username, String nom, String prenom, String email, String password,
				boolean enabled, String fonction, String dateNaissance,  String path, byte[] file) {
			super();
			this.id = id;
			this.username = username;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.password = password;
			this.enabled = enabled;
			this.fonction = fonction;
			this.dateNaissance = dateNaissance;
			this.path = path;
			this.file = file;
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
