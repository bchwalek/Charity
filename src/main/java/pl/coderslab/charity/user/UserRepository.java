package pl.coderslab.charity.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.role.Role;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    User findByUserEmail (String email);

//    @Query("select u FROM User u where u.role.role=?1")
    List<User> findAllByRole(Role Role);
}
