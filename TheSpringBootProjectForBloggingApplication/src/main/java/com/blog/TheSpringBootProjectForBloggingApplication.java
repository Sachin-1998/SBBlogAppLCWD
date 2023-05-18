package com.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.blog.config.AppConstants;
import com.blog.entities.Role;
import com.blog.repositories.RoleRepo;

@SpringBootApplication
@EnableWebMvc
public class TheSpringBootProjectForBloggingApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;
	public static void main(String[] args) {
		SpringApplication.run(TheSpringBootProjectForBloggingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println(this.passwordEncoder.encode("Kartik@123"));
		
		try 
		{
			Role userRole = new Role();
			userRole.setId(AppConstants.NORMAL_USER);
			userRole.setName("ROLE_NORMAL");

			Role adminRole = new Role();
			adminRole.setId(AppConstants.ADMIN_USER);
			adminRole.setName("ROLE_ADMIN");

			List<Role> roles = List.of(userRole, adminRole);
			List<Role> saveRoles = this.roleRepo.saveAll(roles);
			saveRoles.forEach(s -> {
				System.out.println(s.getName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
