package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.role.Role;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class UserService {

   private final UserRepository userRepository;

   public void addUser(User user){
      userRepository.save(user);
   }

   public User findByEmail(String email){
       return userRepository.findByUserEmail(email);
   }

   public List<User> getUserByRole(Role role){
      return userRepository.findAllByRole(role);
   }
}
