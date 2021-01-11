package pl.coderslab.charity.donation;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DonationRepository extends JpaRepository<Donation, Long>{

 @Query("SELECT SUM(quantity) FROM Donation")
 Integer quantity();

 @Query("SELECT COUNT (id)  FROM Donation")
 Integer donation();

 @Query("SELECT d FROM Donation d where d.institution.id=?1")
 List<Donation>donationToDeleteByInstitution(Long id);
}
