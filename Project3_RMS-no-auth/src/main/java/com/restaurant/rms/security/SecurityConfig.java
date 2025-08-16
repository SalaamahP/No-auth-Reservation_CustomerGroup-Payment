//package com.restaurant.rms.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//import java.io.IOException;
//
//// help from: https://www.youtube.com/watch?v=xAaGxhDiGg8
//// use this URL: http://localhost:8080/login/oauth2/code/google
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
////        http
////                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
////                .oauth2Login(Customizer.withDefaults());
////
////        return http.build();
////    }
//
//
//    // help from: https://youtu.be/k7k3lkpl4X4?t=856
//    // sign in with google or username
//    // need to modify POM file
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
////        http
////                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
////                .formLogin(Customizer.withDefaults()) // only added this line
////                .oauth2Login(Customizer.withDefaults());
////
////        return http.build();
////    }
//
//
//    // help from: https://www.youtube.com/watch?v=tIaWE9WthSQ
//    // GitHub: https://github.com/afsalashyana/Spring-Boot-Tutorials/tree/master/LearnSpringOAuth
//    // has open routes
//    // also used thyme leaf
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(registry -> {
////            registry.requestMatchers("/").permitAll();
//            registry.requestMatchers("/", "/login").permitAll();
//                    registry.anyRequest().authenticated();
//                })
////                .oauth2Login(Customizer.withDefaults())
//
//                // -------------------
//                // this is used to re-direct the user to the profile page once he logs in
//                .oauth2Login(oauth2login -> {
//                    oauth2login
////                             .loginPage("/login") // for custom login page
//                            .successHandler(new AuthenticationSuccessHandler() {
//                                @Override
//                                public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                                    response.sendRedirect("/dashboard");
//                                }
//                            });
//                })
//                // -------------------
//
////                .formLogin(Customizer.withDefaults())
//                .build();
//    }
//}
