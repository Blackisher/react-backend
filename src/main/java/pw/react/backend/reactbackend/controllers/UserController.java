package pw.react.backend.reactbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pw.react.backend.reactbackend.dao.UserRepository;
import pw.react.backend.reactbackend.entities.User;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    //https://docs.spring.io/spring/docs/5.1.10.RELEASE/spring-framework-reference/web-reactive.html#webflux-ann-requestmapping
    //to run send
    // POST to http://localhost:8080/users
    //with body raw:
    //    {
    //    "login": "9257",
    //    "firstname": "Black"
    //    "lastname": "White"
    //    "dateofbirth": "2000-01-01"
    //    "active": "T"
    //    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void add(@RequestBody User user) {
        //Lab3task2point4 create a controller and define rest endpoint to create new user,
        Object a = repository.save(user);
        System.out.println(a.toString());
    }

    //Lab3task2point5 create service that will check if a user with given login have bean already created, if yes then return proper status code and message to the calling client,
    @RequestMapping(value="/{login}", method = RequestMethod.HEAD)
    public ResponseEntity<String> checkIfFreeLogin(@PathVariable String login, Model model) {
        User u = getByLogin(login, model);
        if (null != u) {
            // login free
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Login free", "false");
            return new ResponseEntity<String>(null, responseHeaders, HttpStatus.FORBIDDEN);
        } else {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Login free", "true");
            return new ResponseEntity<String>("{Hello World}", responseHeaders, HttpStatus.OK);
        }
    }

    @RequestMapping(value="/{login:[a-z]([0-9]|[a-z])+}", method = RequestMethod.GET)
    public User getByLogin(@PathVariable String login, Model model) {
        //Lab3task2point6 create the repository that will find the user by the login.
        Iterable<User> result = repository.findAll();
        boolean found = false;
        long id = 0l;
        for (User u : result){
            if (login.equals(u.getLogin())) {
                found = true;
                id = u.getId();
            }
        }
        if (found) {
            Optional<User> asd = repository.findById(id);
            return asd.get();
        } else {
            return null;
        }
    }

    //LAB03task03
    //    create rest endpoint to retrieve the User when exists or return proper message and status code when it does not,
    //getting by id
    @RequestMapping(value="/{id:[1-9][0-9]*}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable String id, Model model) {
        Optional<User> result = repository.findById(Long.valueOf(id));
        if (Optional.empty().equals(result)) {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("User by id", "not found");
            return new ResponseEntity<User>(null, responseHeaders, HttpStatus.FORBIDDEN);
        } else {
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("User by id", "found");
            User userToReturn = result.get();
            return new ResponseEntity<User>(userToReturn, responseHeaders, HttpStatus.OK);
        }
    }

    //    create rest endpoint to update the User when exists or return proper message and status code when it does not,
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        Optional<User> result = repository.findById(Long.valueOf(user.getId()));
        if (Optional.empty().equals(result)) {
            //user does not exists.
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Unable to update", "user not found");
            return new ResponseEntity<User>(null, responseHeaders, HttpStatus.BAD_REQUEST);
        } else {
            User updatedTo = repository.save(user);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("User updated", "true");
            return new ResponseEntity<User>(updatedTo, responseHeaders, HttpStatus.OK);
        }
    }

    //    create rest endpoint to delete the User if exist or return proper message and status code when it does not.
    @DeleteMapping
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        Optional<User> result = repository.findById(Long.valueOf(user.getId()));
        if (Optional.empty().equals(result)) {
            //user does not exists.
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Unable to delete", "user not found");
            return new ResponseEntity<User>(null, responseHeaders, HttpStatus.BAD_REQUEST);
        } else {
            repository.delete(user);
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("User deleted", "true");
            return new ResponseEntity<User>(null, responseHeaders, HttpStatus.OK);
        }
    }
}
