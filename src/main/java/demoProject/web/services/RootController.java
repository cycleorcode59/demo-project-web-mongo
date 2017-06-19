package demoProject.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RootController {
//    @Autowired
//    NamedParameterJdbcTemplate jdbcTemplate;

    @RequestMapping("/")
    ModelAndView index () {
        return new ModelAndView("redirect:/swagger-ui.html");
    }
}
