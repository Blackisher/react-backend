package pw.react.backend.reactbackend.entities;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "user", schema = "public")
public class User {
//
//  "User": [
//  {
//    "login": "9257",
//          "firstname": "Black"
//    "lastname": "White"
//    "dateofbirth": "2000-01-01"
//    "active": "T"
//  }
// ]
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String login;
  private String firstname;
  private String lastname;
  private java.sql.Date dateofbirth;
  private String active;

  public User(){

  }
  public User(String login, String firstname, String lastname, Date dateofbirth, String active) {
    this.login = login;
    this.firstname = firstname;
    this.lastname = lastname;
    this.dateofbirth = dateofbirth;
    this.active = active;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }


  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public java.sql.Date getDateofbirth() {
    return dateofbirth;
  }

  public void setDateofbirth(java.sql.Date dateofbirth) {
    this.dateofbirth = dateofbirth;
  }


  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

}
