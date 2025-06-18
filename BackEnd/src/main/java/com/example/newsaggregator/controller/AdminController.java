////package com.example.newsaggregator.controller;
////
////import com.example.newsaggregator.bean.AdminBean;
////import com.example.newsaggregator.bean.UserBean;
////import com.example.newsaggregator.service.AdminService;
////
////import jakarta.servlet.http.HttpServletResponse;
////
////import java.io.IOException;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////@RestController
////@CrossOrigin(origins = "*")
////@RequestMapping("/admin")
////public class AdminController {
////
////    @Autowired
////    private AdminService adminService;
//// // Register a new user
////    @GetMapping("/register")
////    public String registerUser(@ModelAttribute("user") AdminBean user) {
////        int result = adminService.registerAdmin(user);
////        if (result == 1) {
////            return "<h1>User registered successfully!</h1>";
////        } else {
////            return "<h1>Registration failed. Username already exists.</h1>";
////        }
////    }
////
////    @GetMapping("/login")
////    public void loginUser(@RequestParam("username")String uname,@RequestParam("password")String pass,HttpServletResponse res) {
////       UserBean u1=new UserBean();
////       u1.setUsername(uname);
////       u1.setPassword(pass);
////       System.out.println(u1);
////    	AdminBean u=adminService.loginUser(u1);
////    	System.out.println("Under controller "+u);
////    	if(u!=null)
////    	{
////    		try {
////				res.sendRedirect("http://localhost:5500/Admin.html");
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////    	}
////    	else if(u==null)
////    	{
////    		try {
////				res.sendRedirect("http://localhost:5500/error.html");
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////    	}
////        
////    }
////}
//package com.example.newsaggregator.controller;
//
//import com.example.newsaggregator.bean.AdminBean;
//import com.example.newsaggregator.bean.UserBean;
//import com.example.newsaggregator.service.AdminService;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private AdminService adminService;
//
//    // Register a new admin
//    @GetMapping("/register")
//    public String registerAdmin(@ModelAttribute("admin") AdminBean admin) {
//        int result = adminService.registerAdmin(admin);
//        if (result == 1) {
//            return "<h1>Admin registered successfully!</h1>";
//        } else {
//            return "<h1>Registration failed. Username already exists.</h1>";
//        }
//    }
//
//    // Admin login
//    @GetMapping("/login")
//    public void loginAdmin(@RequestParam("username") String uname, @RequestParam("password") String pass, HttpServletResponse res) {
//        UserBean user = new UserBean();
//        user.setUsername(uname);
//        user.setPassword(pass);
//        AdminBean admin = adminService.loginUser(user);
//        if (admin != null) {
//            try {
//                res.sendRedirect("http://localhost:5500/Admin.html");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
//            try {
//                res.sendRedirect("http://localhost:5500/error.html");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
//
package com.example.newsaggregator.controller;

import com.example.newsaggregator.bean.AdminBean;
import com.example.newsaggregator.bean.UserBean;
import com.example.newsaggregator.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow React frontend
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Register a new admin
    @PostMapping("/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminBean admin) {
        int result = adminService.registerAdmin(admin);
        if (result == 1) {
            return ResponseEntity.ok("{\"message\": \"Admin registered successfully!\"}");
        } else {
            return ResponseEntity.badRequest().body("{\"message\": \"Registration failed. Username already exists.\"}");
        }
    }

    // Admin login
    @PostMapping("/login")
    public ResponseEntity<?> loginAdmin(@RequestBody UserBean user) {
        AdminBean admin = adminService.loginUser(user);
        if (admin != null) {
            return ResponseEntity.ok("{\"message\": \"Login successful!\", \"redirect\": \"/dashboard\"}");
        } else {
            return ResponseEntity.status(401).body("{\"message\": \"Invalid credentials\"}");
        }
    }
}
