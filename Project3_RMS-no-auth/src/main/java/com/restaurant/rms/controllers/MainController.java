//package com.restaurant.rms.controllers;
//
//import com.restaurant.rms.repository.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * MainController
// * <br>
// * Number of routes: 4
// */
//@Controller
//public class MainController {
//
//    @Autowired
//    private EmployeeRepo empRepo;
//    // **************************
//
//    @RequestMapping("/")
//    public String signIn(){
//        return "sign-in";
//    }
//
//    @RequestMapping("/dashboard")
//    public String dashboard(){
//        return "dashboard";
//    }
//
//    @RequestMapping("/profile")
//    public String profile(){
//        return "profile";
//    }
//
//    @RequestMapping("/create-account")
//    public String createAccount(){
//        return "create-account";
//    }
//    // **************************
//
//    // temp
//    // RESERVATION
////    @RequestMapping("/reservations")
////    public String reservations(){
////        return "reservation/reservations";
////    }
////
////    @RequestMapping("/reservations-add")
////    public String reservationAdd(){
////        return "reservation/reservations-add";
////    }
//    // **************************
//
//    // MENU
//    @RequestMapping("/menu")
//    public String menu(){
//        return "menu/menu";
//    }
//
//    @RequestMapping("/menu-add")
//    public String menuAdd(){
//        return "menu/menu-add";
//    }
//    // **************************
//}


package com.restaurant.rms.controllers;

//import com.restaurant.rms.repository.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * MainController
 * <br>
 * Number of routes: 4
 */
@Controller
public class MainController {

//    @Autowired
//    private EmployeeRepo empRepo;
    // **************************

    @RequestMapping("/")
    public String signIn(){
        return "./custom-login";

//        return "sign-in";
//        return "dashboard";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){
//        return "dashboard-less";
        return "dashboard";
    }

//    @RequestMapping("/profile")
//    public String profile(){
//        return "profile";
//    }

    @RequestMapping("/create-account")
    public String createAccount(){
        return "create-account";
    }

    // NEWER
    @GetMapping("/restricted")
    public String auth(){
        return "You now have access to this page";
    }

    // returns details about a user who logged in
    @GetMapping("/user")
//    @RequestMapping("/user")
    public Principal user(Principal principalUser){
        return principalUser;
    }

//    @GetMapping("/profile")
//    public String profile(OAuth2AuthenticationToken token, Model model){
//        model.addAttribute("name", token.getPrincipal().getAttribute("name"));
//        model.addAttribute("email", token.getPrincipal().getAttribute("email"));
//        model.addAttribute("photo", token.getPrincipal().getAttribute("picture"));
//        return "./user-page";
//    }

    @GetMapping("/login")
    public String login(){
        return "./custom-login";
    }
    // **************************

    // temp
    // MENU
    @RequestMapping("/menu")
    public String menu(){
        return "menu/menu";
    }

    @RequestMapping("/menu-add")
    public String menuAdd(){
        return "menu/menu-add";
    }
    // **************************
}
