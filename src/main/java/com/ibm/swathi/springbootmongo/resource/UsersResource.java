package com.ibm.swathi.springbootmongo.resource;

import com.ibm.swathi.springbootmongo.document.Users;
import com.ibm.swathi.springbootmongo.repository.UsersRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {

    private UsersRepository usersRepository;

    public UsersResource(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    // Get all records
    @GetMapping("/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }
    
    // Get By user ID
    @GetMapping("/{id}")
    public Optional<Users> getUserByID(@PathVariable(value="id") int id) {
        return usersRepository.findById(id);
    }
    
    // Insert by ID
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Users insertRecord(@RequestBody Users newUser) {
        return usersRepository.insert(newUser);
    }
    
    // Update by ID
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Users updateRecord(@RequestBody Users newUser) {
        return usersRepository.save(newUser);
    }
    
    // Delete by ID
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Void deleteRecord(@PathVariable(value="id") int id) {
        usersRepository.deleteById(id);
		return null;
    }
}
