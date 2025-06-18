////package com.example.newsaggregator.controller;
////
////import java.io.IOException;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.web.bind.annotation.*;
////
////import com.example.newsaggregator.bean.UserBean;
////import com.example.newsaggregator.service.UserService;
////
////import jakarta.servlet.http.HttpServletResponse;
////
////@RestController
////@CrossOrigin(origins = "*")
////@RequestMapping("/user")
////public class UserController {
////
////    @Autowired
////    private UserService userService;
////
////    @GetMapping("/welcome")
////    public String home() {
////        return "<h1>Welcome to the User Dashboard</h1>";
////    }
////
////    // Register a new user
////    @GetMapping("/register")
////    public String registerUser(@ModelAttribute("user") UserBean user) {
////        int result = userService.registerUser(user);
////        if (result == 1) {
////            return "<h1>User registered successfully!</h1>";
////        } else {
////            return "<h1>Registration failed. Username already exists.</h1>";
////        }
////    }
////
////    // User login
////    @GetMapping("/login")
////    public void loginUser(@RequestParam("username")String uname,@RequestParam("password")String pass,HttpServletResponse res) {
////       UserBean u1=new UserBean();
////       u1.setUsername(uname);
////       u1.setPassword(pass);
////       System.out.println(u1);
////    	UserBean u=userService.loginUser(u1);
////    	System.out.println("Under controller "+u);
////    	if(u!=null)
////    	{
////    		try {
////				res.sendRedirect("http://localhost:5500/User.html");
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
////
////    // Update user preferences
////    @PostMapping("/updatePreferences")
////    public String updatePreferences(@RequestParam("username") String username, @RequestParam("preferences") String preferences) {
////        int result = userService.updatePreferences(username, preferences);
////        if (result == 1) {
////            return "<h1>Preferences updated successfully!</h1>";
////        } else {
////            return "<h1>Failed to update preferences. User not found.</h1>";
////        }
////    }
////
////    // Get user profile
////    @GetMapping("/profile")
////    public UserBean getUserProfile(@RequestParam("username") String username) {
////        return userService.getUserByUsername(username);
////    }
////}
//package com.example.newsaggregator.controller;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.newsaggregator.bean.UserBean;
//import com.example.newsaggregator.service.UserService;
//
//import jakarta.servlet.http.HttpServletResponse;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    // Register a new user
//    @GetMapping("/register")
//    public String registerUser(@ModelAttribute UserBean user) {
//        int result = userService.registerUser(user);
//        if (result == 1) {
//            return "<h1>User registered successfully!</h1>";
//        } else {
//            return "<h1>Registration failed. Username already exists.</h1>";
//        }
//    }
//
//    // User login
//    @GetMapping("/login")
//    public void loginUser(@RequestParam("username") String uname, @RequestParam("password") String pass, HttpServletResponse res) {
//        UserBean user = new UserBean();
//        user.setUsername(uname);
//        user.setPassword(pass);
//        UserBean loggedInUser = userService.loginUser(user);
//        
//        if (loggedInUser != null) {
//            try {
//                res.sendRedirect("http://localhost:5500/User.html");
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
//
//    // Update user preferences
//    @PostMapping("/updatePreferences")
//    public String updatePreferences(@RequestParam("username") String username, @RequestParam("preferences") String preferences) {
//        int result = userService.updatePreferences(username, preferences);
//        if (result == 1) {
//            return "<h1>Preferences updated successfully!</h1>";
//        } else {
//            return "<h1>Failed to update preferences. User not found.</h1>";
//        }
//    }
//
//    // Get user profile
//    @GetMapping("/profile")
//    public UserBean getUserProfile(@RequestParam("username") String username) {
//        return userService.getUserByUsername(username);
//    }
//}
//
package com.example.newsaggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.newsaggregator.bean.UserBean;
import com.example.newsaggregator.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody UserBean user) {
        int result = userService.registerUser(user);
        return result == 1 ? "User registered successfully!" : "Registration failed. Username already exists.";
    }

    // User login
    @PostMapping("/login")
    public UserBean loginUser(@RequestBody UserBean user) {
        return userService.loginUser(user);
    }

    // Update user preferences
    @PostMapping("/updatePreferences")
    public String updatePreferences(@RequestParam("username") String username, @RequestParam("preferences") String preferences) {
        int result = userService.updatePreferences(username, preferences);
        return result == 1 ? "Preferences updated successfully!" : "Failed to update preferences. User not found.";
    }

    // Get user profile
    @GetMapping("/profile")
    public UserBean getUserProfile(@RequestParam("username") String username) {
        return userService.getUserByUsername(username);
    }
}

