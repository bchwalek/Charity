package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor

@Service
public class DonationService {

    DonationRepository donationRepository;

    public Integer quantityBags(){
        return donationRepository.quantity();
    }

    public Integer quantityDonation(){
        return donationRepository.donation();
    }

    public void addDonation(Donation donation) {
        donationRepository.save(donation);
    }

    public void deleteDonationByInstitution (Long id) {
        List<Donation> donationsTodelete = donationRepository.donationToDeleteByInstitution(id);
        for (Donation donation :donationsTodelete) {
            donationRepository.delete(donation);
        }
    }
}
