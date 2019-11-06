package pw.react.backend.reactbackend.dao;

import org.springframework.data.repository.CrudRepository;
import pw.react.backend.reactbackend.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
