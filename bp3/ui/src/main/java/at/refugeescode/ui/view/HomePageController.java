package at.refugeescode.ui.view;

import at.refugeescode.ui.controller.PatientController;
import at.refugeescode.ui.model.LocalPatient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

    private PatientController patientController;

    public HomePageController(PatientController patientController) {
        this.patientController = patientController;
    }

    @ModelAttribute("newPatient")
    LocalPatient localPatient() {
        return new LocalPatient();
    }

    @PostMapping()
    String addNewPatient(LocalPatient localPatient) {
        patientController.addNewPatient(localPatient);
        return "redirect:/";
    }

    @GetMapping
    String page() {
        return "home";
    }


}
