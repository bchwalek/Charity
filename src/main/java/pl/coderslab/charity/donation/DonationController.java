package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionService;

import java.util.List;

@AllArgsConstructor
@Controller
public class DonationController {

  private CategoryService categoryService;
  private InstitutionService institutionService;
  private DonationService donationService;
  List<Category> donationCategories;


    @GetMapping("/donation")
    public String donationForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("institutions", institutionService.getAllInstitution());
        return "form";
    }

    @PostMapping("/donation")
    public String donation(Donation donation, BindingResult bindingResult){
        donationService.addDonation(donation);
        return "form-confirmation";
    }
}
