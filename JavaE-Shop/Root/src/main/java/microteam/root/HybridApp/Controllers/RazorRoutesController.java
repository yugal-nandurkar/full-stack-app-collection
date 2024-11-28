package microteam.root.HybridApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RazorRoutesController {

    @GetMapping("/")
    public String home(Model model) {
        return "razor-routes-main-layout"; // Use Thymeleaf layout template
    }

    @GetMapping("/page")
    public String page(@RequestParam(required = false) String title, Model model) {
        model.addAttribute("title", title);
        return "razor-routes-page-layout"; // Use Thymeleaf layout for this route
    }
}

