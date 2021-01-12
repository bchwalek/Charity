package pl.coderslab.charity.donation;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;
import pl.coderslab.charity.user.User;

import java.util.List;

@AllArgsConstructor
@Controller
public class DonationController {

  private final CategoryService categoryService;
  private final InstitutionService institutionService;
  private final DonationService donationService;
  List<Category> donationCategories;

    @Secured("ROLE_USER")
    @GetMapping("/donation")
    public String donationForm(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("institutions", institutionService.getAllInstitution());
        model.addAttribute("message", "Witaj: " + user.getUserName());
        return "form";
    }

    @PostMapping("/donation")
    public String donation(Donation donation, Model model, @AuthenticationPrincipal User user, BindingResult bindingResult){
        donationService.addDonation(donation);
        model.addAttribute("message", "Witaj: " + user.getUserName());
        return "form-confirmation";
    }
}
