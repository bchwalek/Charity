package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}