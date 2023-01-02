package react.userdetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import react.userdetails.dao.UserRepositary;
import react.userdetails.model.UserDetails;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositary userRepositary;

	@Override
	public List<UserDetails> findAll() {
		return userRepositary.findAll();
	}

	@Override
	public UserDetails save(UserDetails userDetails) {
		UserDetails userInf = userRepositary.findByEmail(userDetails.getEmail());
		if (userInf == null) {
			return userRepositary.save(userDetails);
		} else {
			return null;
		}
	}
	

//	@Override
//	public UserDetails update(UserDetails userDetails) {
//		
//		UserDetails userInf = userRepositary.findByEmail(userDetails.getEmail());
//		
//		if(userInf != null) {
////			userInf.setFirstName(userDetails.getFirstName());
////			userInf.setLastName(userDetails.getLastName());
////			userInf.setPhoneNumber(userDetails.getPhoneNumber());
//			userRepositary.save(userDetails);
//			System.out.println(userDetails);
//		}else {
//			UserDetails userDetails3 = new UserDetails();
//			userDetails3.setId(userDetails.getId());
//			userDetails3.setFirstName(userDetails.getFirstName());
//			userDetails3.setLastName(userDetails.getLastName());
//			userDetails3.setPhoneNumber(userDetails.getPhoneNumber());
//			userDetails3.setEmail(userDetails.getEmail());
//			userRepositary.save(userDetails3);
//			System.out.println(userDetails);
//		}
//		return null;
//	}
	
	@Override
	public UserDetails update(UserDetails userDetails) {
//		UserDetails userInf = userRepositary.findByEmail(userDetails.getEmail());
//		if (userInf == null) {
//			return userRepositary.save(userDetails);
//		} else {
//			return null;
//		}
		return userRepositary.save(userDetails);
	}
	@Override
	public UserDetails deleteById(Long id) {
		userRepositary.deleteById(id);
		return null;

	}

	

	
}
