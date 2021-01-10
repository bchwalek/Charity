package pl.coderslab.charity.role;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class RoleService {

    RoleRepository roleRepository;

    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }
    public Optional<Role> getRole(Long id){
        return roleRepository.findById(id);
    }
    public Role getRoleByName(String name){
        return roleRepository.findByRole(name);
    }


}
