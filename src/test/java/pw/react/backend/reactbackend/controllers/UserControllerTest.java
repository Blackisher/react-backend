package pw.react.backend.reactbackend.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pw.react.backend.reactbackend.dao.UserRepository;
import pw.react.backend.reactbackend.entities.User;

import java.sql.Date;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
    @Mock
    UserController userController;

    @Test
    public void add() {
        User myUser = new User("My Login", "My firstname", "My lastname", new Date(15l), "T");
        userController.add(myUser);
//        verify(repository, times(1));

//        Mockito
//          .when(userController.add(myUser);getForEntity(
//            “http://localhost:8080/employee/E001”, Employee.class))
//          .thenReturn(new ResponseEntity(emp, HttpStatus.OK));
//
//        Employee employee = empService.getEmployee(id);
//        Assert.assertEquals(emp, employee);
    }


}