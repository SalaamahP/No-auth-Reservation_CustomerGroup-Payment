package com.restaurant.rms.controllers;

//import com.restaurant.rms.repository.EmployeeRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * MainController
 * <br>
 * Number of routes: 6
 */
@Controller
public class _MainController {
    @RequestMapping({"", "/"})
    public String defaultRoute(){
        return "_general/home";
    }
    @RequestMapping("/home")
    public String home(){
        return "_general/home";
    }

    // -------------------------------
    // returns details about a user who logged in
    @GetMapping("/user")
    public Principal user(Principal principalUser){
        return principalUser;
    }

    @GetMapping("/profile")
    public String profile(OAuth2AuthenticationToken token, Model model){
        model.addAttribute("name", token.getPrincipal().getAttribute("name"));
        model.addAttribute("email", token.getPrincipal().getAttribute("email"));
        model.addAttribute("photo", token.getPrincipal().getAttribute("picture"));
        return "./user-page";
    }
    // -------------------------------

    // older //
    @RequestMapping("/user-profile")
    public String profile(){
        return "profile";
    }

    @RequestMapping("/sign-in")
    public String signIn(){
        return "_general/sign-in";
//        return "./custom-login";
    }

    @GetMapping("/login")
    public String logIn(){
        return "_general/custom-login";
    }

}
