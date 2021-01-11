package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.donation.DonationService;

import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Transactional
@Service
public class InstitutionService {

    InstitutionRepository institutionRepository;
    DonationService donationService;

    public List<Institution> getAllInstitution(){
        return institutionRepository.findAll();
    }

    public void addInstitution(Institution institution){
        institutionRepository.save(institution);
    }

    public Optional<Institution> getInstitution (Long id){
        return institutionRepository.findById(id);
    }

    public void deleteInstitution (Long id){
        donationService.deleteDonationByInstitution(id);
        institutionRepository.deleteById(id);
    }
}
