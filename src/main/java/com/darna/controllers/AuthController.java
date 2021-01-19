package com.darna.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.darna.dto.UserDto;
import com.darna.models.ERole;
import com.darna.models.Role;
import com.darna.models.User;
import com.darna.repository.RoleRepository;
import com.darna.repository.UserRepository;
import com.darna.request.LoginRequest;
import com.darna.request.SignupRequest;
import com.darna.response.JwtResponse;
import com.darna.response.MessageResponse;
import com.darna.security.jwt.JwtUtils;
import com.darna.security.services.UserDetailsImpl;
import com.darna.services.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;


	@Autowired
	ModelMapper modelMapper;
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	ServletContext context;
	
	private static String UPLOAD_DIR ="C:\\wamp64\\www\\imageDarna";

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getNom(),
												 userDetails.getPrenom(),
												 userDetails.getEmail(), 
												 userDetails.getFonction(),
												 userDetails.getDateNaissance(),
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}  
		// Create new user's account
		User user = new User(null, signUpRequest.getUsername(),
				signUpRequest.getNom(),
				signUpRequest.getPrenom(),
							 signUpRequest.getEmail(),
					         encoder.encode(signUpRequest.getPassword()),
							 signUpRequest.isEnabled(),
							 null,
						     signUpRequest.getFonction(),
						     signUpRequest.getDateNaissance(),
						     signUpRequest.getDateInscription(), signUpRequest.getPath(),
						     signUpRequest.getFile()
						  								);
		

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "visiteur":
					Role modRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				case "membre":
					Role responsableRole = roleRepository.findByName(ERole.ROLE_MEMBRE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(responsableRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	
	

	@PostMapping("/AddMembre")
	public ResponseEntity<?> AddMembre(@Valid @RequestBody SignupRequest signUpRequest) {
	if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		// Create new user's account
		User user = new User(null, signUpRequest.getUsername(),
				signUpRequest.getNom(),
				signUpRequest.getPrenom(),
							 signUpRequest.getEmail(),
					         encoder.encode(signUpRequest.getPassword()),
							 true,
							 null,
						     signUpRequest.getFonction(),
						     signUpRequest.getDateNaissance(),  signUpRequest.getDateInscription(),
						     signUpRequest.getPath(),
						     signUpRequest.getFile()
						  


								);

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "visiteur":
					Role modRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				case "membre":
					Role responsableRole = roleRepository.findByName(ERole.ROLE_MEMBRE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(responsableRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@GetMapping("/user/{id}")
	 public Object DetailsUser(@PathVariable("id") Long id)
    {
		User user=userService.getAUserById(id);
		UserDto userDto=modelMapper.map(user,UserDto.class);
		return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }
	
	 @DeleteMapping("/User/delete/{id}")
	 public Object deleteUser(@PathVariable("id")Long id )
	    {
		 userService.deleteUser(id);;
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	    }

	 

	   @PutMapping(value="/update/{id}")
		public ResponseEntity<?> Update(@PathVariable("id") long id, @Valid @RequestBody SignupRequest signUpRequest) {
	
			// Create new user's account
			User user=userService.getAUserById(id);
			 user = new User(id, signUpRequest.getUsername(),
					signUpRequest.getNom(),
					signUpRequest.getPrenom(),
								 signUpRequest.getEmail(),
						         encoder.encode(signUpRequest.getPassword()),
								 signUpRequest.isEnabled(),
								 null,
							     signUpRequest.getFonction(),
							     signUpRequest.getDateNaissance(),  signUpRequest.getDateInscription(),
							     signUpRequest.getPath(),
							     signUpRequest.getFile()
							     
									);
						Set<String> strRoles = signUpRequest.getRole();
			Set<Role> roles = new HashSet<>();

			if (strRoles == null) {
				Role userRole = roleRepository.findByName(ERole.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
				roles.add(userRole);
			} else {
				strRoles.forEach(role -> {
					switch (role) {
					case "admin":
						Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					case "visiteur":
						Role modRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(modRole);

						break;
					case "membre":
						Role responsableRole = roleRepository.findByName(ERole.ROLE_MEMBRE)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(responsableRole);

						break;
					default:
						Role userRole = roleRepository.findByName(ERole.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);
					}
				});
			}

			user.setRoles(roles);
			userRepository.save(user);

			return ResponseEntity.ok(new MessageResponse("User updated successfully!"));
		}

	
	   @PutMapping(value="/updateUser/{id}")
	    public Object updateUser(@PathVariable("id") long id,@RequestBody UserDto userDto) {
			User user=modelMapper.map(userDto, User.class);
		   user =userService.updateUser(id, user);
		   userDto =modelMapper.map(user, UserDto.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
	   }
	    
	  

	

     @GetMapping("/activate/{id}")
	 public MessageResponse activate(@PathVariable Long id) {
			return userService.activate(id);
	 }
     
     @GetMapping(value = "/listUser")
 	public List<User> findAll() {
 		return userService.findAll();

 	}



 	@PostMapping("/registerUpload")
 	public ResponseEntity<MessageResponse> RegisterWithImage( @RequestParam("file") MultipartFile file,@RequestParam("data") String DesExp,HttpServletRequest request) throws IOException,JsonParseException , JsonMappingException{
 			//DesignExperience designExperience=modelMapper.map(designExperienceDto, DesignExperience.class);
 			
 		   ResponseEntity<MessageResponse>  response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is not saved"),HttpStatus.BAD_REQUEST);
 		
 				  SignupRequest signUpRequest =new ObjectMapper().readValue(DesExp, SignupRequest.class);
 					if (userRepository.existsByUsername(signUpRequest.getUsername())) {
 					return ResponseEntity
 							.badRequest()
 							.body(new MessageResponse("Error: Username is already taken!"));
 				}

 				if (userRepository.existsByEmail(signUpRequest.getEmail())) {
 					return ResponseEntity
 							.badRequest()
 							.body(new MessageResponse("Error: Email is already in use!"));
 				}
 		
 				// Create new user's account
 				User user = new User(null, signUpRequest.getUsername(),
 						signUpRequest.getNom(),
 						signUpRequest.getPrenom(),
 									 signUpRequest.getEmail(),
 							         encoder.encode(signUpRequest.getPassword()),
 									 signUpRequest.isEnabled(),
 									 null,
 								     signUpRequest.getFonction(),
 								     signUpRequest.getDateNaissance(),  signUpRequest.getDateInscription(),
 								     signUpRequest.getPath(),
 								     signUpRequest.getFile()


 										);

 				Set<String> strRoles = signUpRequest.getRole();
 				Set<Role> roles = new HashSet<>();

 				if (strRoles == null) {
 					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
 							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 					roles.add(userRole);
 				} else {
 					strRoles.forEach(role -> {
 						switch (role) {
 						case "admin":
 							Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
 									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 							roles.add(adminRole);

 							break;
 						case "visiteur":
 							Role modRole = roleRepository.findByName(ERole.ROLE_VISITEUR)
 									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 							roles.add(modRole);

 							break;
 						case "membre":
 							Role responsableRole = roleRepository.findByName(ERole.ROLE_MEMBRE)
 									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 							roles.add(responsableRole);

 							break;
 						default:
 							Role userRole = roleRepository.findByName(ERole.ROLE_USER)
 									.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
 							roles.add(userRole);
 						}
 					});
 				}

 				  
 				  
 						  
 				user.setFile(file.getBytes());
 					
// 			
 			       String filename= file.getOriginalFilename();
 			       String modifiedFileName=FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);
 			       user.setPath(modifiedFileName);
 			       Path rootLocation = Paths.get(UPLOAD_DIR);
 			       Files.copy(file.getInputStream(), rootLocation.resolve(modifiedFileName));
 			       user.setRoles(roles);
 					userRepository.save(user);	
 			       if(user!=null)
 			       {
 			   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is saved successfully"),HttpStatus.OK);
 			       }
 			       else {
 			   		response = new ResponseEntity<MessageResponse>(new MessageResponse("Image is not saved"),HttpStatus.BAD_REQUEST);

 			       }	
 			
 			return response;
 		 
 			
 		}



  @GetMapping("/DesactiverRenouvellemnt")
    		public  List<User> renouvellemnt() {
     	List<User> listUsers  =userService.findAll();

     	for(User user:listUsers) {
     		
 		     //////////date courante///////////////////////////////         
             Calendar c = Calendar.getInstance();            
             int yearCurrent = c.get(Calendar.YEAR);
             int MonthCurrent = c.get(Calendar.MONTH);
             int DayCurrent = c.get(Calendar.DAY_OF_MONTH);
 		     System.out.println(yearCurrent);
 		     System.out.println(MonthCurrent);
 		     System.out.println(DayCurrent);
    
 		     //////////date d'inscription///////////////////////////////         
 		     Calendar cal = user.getDateInscription();
 		     System.out.println(cal.get(Calendar.YEAR));
 		     int  yearDateInscription =cal.get(Calendar.YEAR);
 		     int  MonthDateInscription =cal.get(Calendar.MONTH);
 		     int  DayDateInscription =cal.get(Calendar.DAY_OF_MONTH);
 		     System.out.println(yearDateInscription);
 		     System.out.println(MonthDateInscription);
 		     System.out.println(DayDateInscription);
 		     int yearDateInscriptionUpdated= yearDateInscription+1;
 		     System.out.println(yearDateInscription);
 		     
 		     
 		     //////////test pour renouvellemnt///////////////////////////////         
 		     if(yearDateInscriptionUpdated <= yearCurrent  && MonthDateInscription==MonthCurrent  && DayCurrent== DayDateInscription) {
 			  	     user.setEnabled(false);
 				     System.out.println(user.isEnabled());
 				     userRepository.save(user);	
 			 }
     	}
  		return userService.findAll();

 		 }
     
     @GetMapping("/ActivateRenouvellement/{id}")
 	public MessageResponse ActivateRenouvellement(@PathVariable Long id) {
     	
     	User user = userRepository.findById(id).orElse(null);
 		if(user.isEnabled()==false){
 	    	 user.setEnabled(true);
 		     user.setDateInscription(Calendar.getInstance());      
 		     System.out.println(user.isEnabled());
 		     userRepository.save(user);	
    		 return new MessageResponse("renouvellemnt activé");
    		 } else {
    	   		 return new MessageResponse("renouvellemnt désactivé");

    			 
    		 }
 	     
 	 }

	
   	
   		
}
