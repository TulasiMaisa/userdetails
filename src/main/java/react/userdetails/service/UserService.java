package react.userdetails.service;

import java.util.List;
import react.userdetails.model.UserDetails;

public interface UserService {

	public List<UserDetails> findAll();

	public UserDetails save(UserDetails userDetails);

	public UserDetails update(UserDetails userDetails);
	
	//public UserDetails updateById(Long id);

	public UserDetails deleteById(Long id);

}
