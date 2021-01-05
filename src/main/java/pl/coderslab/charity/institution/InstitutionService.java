package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Transactional
@Service
public class InstitutionService {

    InstitutionRepository institutionRepository;

    public List<Institution> getAllInstitution(){
        return institutionRepository.findAll();
    }
}
