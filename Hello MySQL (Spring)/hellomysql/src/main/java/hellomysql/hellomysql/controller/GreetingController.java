package hellomysql.hellomysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="name", required = false, defaultValue = "World!") String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @GetMapping("/homeSign")
//    public String homeSign(Principal principal) {
//        return principal != null ? "homeSignedIn" : "homeNotSignedIn";
//    }
    public ModelAndView homeSign(Principal principal){
        ModelAndView modelAndView = new ModelAndView();
        if (principal != null) {
            modelAndView.setViewName("homeSignedIn");
            modelAndView.addObject(principal);
            System.out.print(principal);
            return modelAndView;
        }
        else {
            modelAndView.setViewName("homeNotSignedIn");
            return modelAndView;
        }
    }

    @GetMapping("/baselayout") //failed
    public String baselayout(){
        return "fragments/layout";
    }

    @GetMapping("/customlayout")
    public String customlayout() {
        return "fragments/template";
    }

    @GetMapping("/customlayout1")
    public String customlayout1() {
        return "fragments/terusantemplate";
    }

}
