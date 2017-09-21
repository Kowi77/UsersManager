package kov.develop.service;

import kov.develop.model.User;
import kov.develop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll (){
        return repository.findAll();
    }

    /*public List<User> getFiltredAll(String part){
        return repository.findAllByLastNameContainsAllIgnoreCaseOrderByLastName(part);
    }*/
    public User get (int id){
        return repository.findOne(id);
    }

    public void delete (int id){
        repository.delete(id);
    }

    public User save (User user){
        return repository.save(user);
    }
}
