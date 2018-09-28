package hellomysql.hellomysql.controller;

import hellomysql.hellomysql.entity.User;
import hellomysql.hellomysql.repository.UserRepository;
import hellomysql.hellomysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        User userbaru = new User();
        userbaru.setName(name);
        userbaru.setEmail(email);
        userRepository.save(userbaru);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/userservice")
    public String userService(Model model){
        List<User> userList = userRepository.findAll();
        model.addAttribute(userList);
        return "userservice.html";
    }
//    https://o7planning.org/en/11897/spring-boot-and-spring-data-jpa-tutorial
    @GetMapping(path = "/userservice/{name}")
//    public ModelAndView userservice(@PathVariable String name){
//        ModelAndView modelAndView = new ModelAndView();
//        List<User> userList = userService.findByName(name);
//        modelAndView.addObject(userList);
//        modelAndView.setViewName("userservice");
//        return modelAndView;
//    }
    public String userserviceOrang(Model model, @PathVariable String name){
        List<User> userList = userService.findByName(name);
        model.addAttribute(userList);
        return "userservice.html";
    }

}
