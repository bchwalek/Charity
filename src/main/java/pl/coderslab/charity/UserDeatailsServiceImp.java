package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.UserService;

@Service
@AllArgsConstructor
public class UserDeatailsServiceImp implements UserDetailsService {

    private final UserService userService;



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userService.findByEmail(s);
    }
}
