package nl.novi.les16jwt.repository;

import nl.novi.les16jwt.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
