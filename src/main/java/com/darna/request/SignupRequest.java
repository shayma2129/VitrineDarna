package com.darna.request;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Lob;
import javax.validation.constraints.*;

 
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
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

    
    private String fonction;
    private String dateNaissance;
    Calendar dateInscription = Calendar.getInstance();



	 @Column(name="PATH")
		private String path;
		/**
		 * file
		 */
		 @Column
		 @Lob
		 private byte[] file;
    

	private boolean enabled;
    
    private Set<String> role;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
  
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
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
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

	public Calendar getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Calendar dateInscription) {
		this.dateInscription = dateInscription;
	}
	

}

