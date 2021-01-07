package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;

@AllArgsConstructor
@Controller
public class DonationController {

  private CategoryService categoryService;
  private InstitutionService institutionService;

    @GetMapping("/form")
    public String donationForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("institutions", institutionService.getAllInstitution());
        return "form";
    }
}
