package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.role.Role;
import pl.coderslab.charity.role.RoleRepository;
import pl.coderslab.charity.role.RoleService;

@AllArgsConstructor
@Controller
public class UserController {

    UserService userService;
    RoleService roleService;
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String userRegistrationForm(Model model){
        model.addAttribute("user", new User());
        return "register-form";
    }

    @PostMapping("/register")
    public String userRegister(Model model, User user, @ModelAttribute("password2") String password2, BindingResult bindingResult){
        if(!user.getPassword().equals(password2)){
            model.addAttribute("message", "Hasła nie są identyczne");
            return "redirect:/login";
        }

        user.setRole(roleService.getRoleByName("ROLE_USER"));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "register-form";
    }

    @GetMapping("/userslist")
    public String getAllAdmin(Model model){
           model.addAttribute("adminList", userService.getUserByRole(roleService.getRoleByName("ROLE_ADMIN")));
           model.addAttribute("userList", userService.getUserByRole(roleService.getRoleByName("ROLE_ADMIN")));
        return "redirect:/";
    }
}
