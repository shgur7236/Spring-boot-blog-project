package blogproject.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/user/save")
    public String save(){
        return "/layout/user/user-save";
    }
}
