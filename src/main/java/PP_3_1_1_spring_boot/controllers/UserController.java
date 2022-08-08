package PP_3_1_1_spring_boot.controllers;
import PP_3_1_1_spring_boot.models.User;
import PP_3_1_1_spring_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("user_list", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/new")
    public String showNewUserPage(@ModelAttribute("user") User user) {
        return "new_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/user";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") long id) {
        userService.removeUser(id);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.show((int) id));
        return "edit_user";
    }

    @PostMapping("/edit")
    public String update(User user) {
        userService.addUser(user);
        return "redirect:/user";
    }
}
