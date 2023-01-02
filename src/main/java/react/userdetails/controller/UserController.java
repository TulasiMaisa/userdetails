package react.userdetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import react.userdetails.dto.Result;
import react.userdetails.model.UserDetails;
import react.userdetails.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value ="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	

	
	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ResponseEntity<List<UserDetails>> findAll(){
	List<UserDetails> userDetails= null;
	userDetails=userService.findAll();
	return ResponseEntity.ok(userDetails);
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<UserDetails> save(@RequestBody UserDetails userDetails) {
		userDetails = userService.save(userDetails);
		return new ResponseEntity<UserDetails>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Result>update(@RequestBody UserDetails userDetails){
		userDetails = userService.update(userDetails);
		
		return new ResponseEntity<Result>(HttpStatus.CREATED);
	}
	
	
	/*
	 * @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<UserDetails> update(@PathVariable Long id, @RequestBody
	 * UserDetails userDetails) { UserDetails uDetails =
	 * userRepositary.findById(id).get(); if (uDetails.getId() != 0) {
	 * uDetails.setFirstName(userDetails.getFirstName());
	 * uDetails.setLastName(userDetails.getLastName());
	 * uDetails.setEmail(userDetails.getEmail());
	 * uDetails.setPhoneNumber(userDetails.getPhoneNumber()); }
	 * 
	 * return new ResponseEntity<UserDetails>(userRepositary.save(uDetails),
	 * HttpStatus.OK); }
	 */
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<UserDetails> deleteById(@PathVariable Long id) {
		UserDetails userDetails=userService.deleteById(id);
		return ResponseEntity.ok(userDetails);
	}
	
}
