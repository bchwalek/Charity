package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


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
}
