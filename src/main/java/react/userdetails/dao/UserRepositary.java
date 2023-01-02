package react.userdetails.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import react.userdetails.model.UserDetails;

public interface UserRepositary extends JpaRepository<UserDetails, Long> {
	
	UserDetails findByEmail(String email);

	UserDetails findAllById(Long id);
	


	
}
