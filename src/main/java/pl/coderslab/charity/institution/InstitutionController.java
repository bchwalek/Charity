package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@AllArgsConstructor
@Secured("ROLE_ADMIN")
@Controller
public class InstitutionController {

    InstitutionService institutionService;

    @GetMapping("/institution")
    public String institutionAll(Model model) {

        model.addAttribute("institutionAll", institutionService.getAllInstitution());
        return "institutionCRUD";
    }

    @GetMapping("/addinstitution")
    public String addInstitutionForm(Model model) {
        model.addAttribute("institution", new Institution());
        return "institutionCRUD-Create";
    }

    @PostMapping("/addinstitution")
    public String addInstitution(Institution institution) {
        institutionService.addInstitution(institution);
        return "redirect:/institution";
    }

    @GetMapping("updateinstitution/{id}")
    public String updateInstitutionForm(Model model, @PathVariable Long id) {
        model.addAttribute("institutionUpdate", institutionService.getInstitution(id).get());

        return "institutionCRUD-Update";
    }

    @PostMapping("/updateinstitution")
    public String updateInstitution(Institution institution) {
        institutionService.addInstitution(institution);
        return "redirect:/institution";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable Long id) {

        institutionService.deleteInstitution(id);
        return "redirect:/institution";
    }

}
