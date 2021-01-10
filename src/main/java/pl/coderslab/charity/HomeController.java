package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;

@AllArgsConstructor
@Controller
public class HomeController {

    InstitutionService institutionService;
    DonationService donationService;

    @RequestMapping("/")
    public String homeAction(Model model){
        model.addAttribute("institutions", institutionService.getAllInstitution());
        model.addAttribute("bags", donationService.quantityBags());
        model.addAttribute("donation", donationService.quantityDonation());
        return "index";
    }

    @GetMapping("/login")
    public String loginForm(){
        return "login";
    }

}
