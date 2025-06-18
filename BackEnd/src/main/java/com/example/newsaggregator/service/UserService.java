////package com.example.newsaggregator.service;
////
////import java.util.ArrayList;
////import java.util.List;
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Service;
////
////import com.example.newsaggregator.bean.NewsBean;
////import com.example.newsaggregator.bean.UserBean;
////import com.example.newsaggregator.dao.UserDao;
////
////@Service
////public class UserService {
////
////    @Autowired
////    private UserDao userDao;
////
////    public int registerUser(UserBean user) {
////        if (userDao.findByUsername(user.getUsername()) == null) {
////            userDao.save(user);
////            return 1;
////        }
////        return 0;
////    }
////
////    public UserBean loginUser(UserBean user) {
////      List<UserBean> all = userDao.findAll();
////      UserBean ub=new UserBean();
////      int flag=0;
////      for(UserBean u:all)
////      {
////    	  if(u.getUsername().equals(user.getUsername())&&(u.getPassword().equals(user.getPassword())))
////    			  {
////    		  		ub=u;
////    		  		System.out.println(u);
////    		  		flag=1;
////    			  }
////      }
////      if(flag==0)
////      {
////    	  System.out.println("Not Present");
////    	  return null;
////      }
////        return ub;
////    }
////
////    public int updatePreferences(String username, String preferences) {
////        UserBean user = userDao.findByUsername(username);
////        if (user != null) {
////            user.setPreferences(preferences);
////            userDao.save(user);
////            return 1;
////        }
////        return 0;
////    }
////
////    public UserBean getUserByUsername(String username) {
////        return userDao.findByUsername(username);
////    }
////  
//// 
////}
//package com.example.newsaggregator.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.newsaggregator.bean.UserBean;
//import com.example.newsaggregator.dao.UserDao;
//
//import java.util.List;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//    public int registerUser(UserBean user) {
//        if (userDao.findByUsername(user.getUsername()) == null) {
//            userDao.save(user);
//            return 1;
//        }
//        return 0;
//    }
//
//    public UserBean loginUser(UserBean user) {
//        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }
//
//    public int updatePreferences(String username, String preferences) {
//        UserBean user = userDao.findByUsername(username);
//        if (user != null) {
//            user.setPreferences(preferences);
//            userDao.save(user);
//            return 1;
//        }
//        return 0;
//    }
////
////    public UserBean getUserByUsername(String username) {
////        return userDao.findByUsername(username);
////    }
////
////    // Get the list of user preferences (categories)
////    public List<String> getUserPreferences(String username) {
////        UserBean user = userDao.findByUsername(username);
////        if (user != null) {
////            // Assuming preferences are stored as a comma-separated string
////            return List.of(user.getPreferences().split(","));
////        }
////        return null; // User not found or no preferences
////    }
//    public UserBean getUserByUsername(String username) {
//        return userDao.findByUsername(username);
//    }
//
//    // Get user preferences (categories they are interested in)
//    public List<String> getUserPreferences(String username) {
//        UserBean user = userDao.findByUsername(username);
//        if (user != null && user.getPreferences() != null) {
//            // Split preferences by comma and return as list
//            return List.of(user.getPreferences().split(","));
//        }
//        return null;  // No preferences found for the user
//    }
//}
//
package com.example.newsaggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsaggregator.bean.UserBean;
import com.example.newsaggregator.dao.UserDao;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    // Register a new user
    public int registerUser(UserBean user) {
        if (userDao.findByUsername(user.getUsername()) == null) {
            userDao.save(user);
            return 1;
        }
        return 0;
    }

    // Login user
    public UserBean loginUser(UserBean user) {
        return userDao.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    // Update user preferences
    public int updatePreferences(String username, String preferences) {
        UserBean user = userDao.findByUsername(username);
        if (user != null) {
            user.setPreferences(preferences);
            userDao.save(user);
            return 1;
        }
        return 0;
    }

    // Get user profile by username
    public UserBean getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    // Get user preferences
    public List<String> getUserPreferences(String username) {
        UserBean user = userDao.findByUsername(username);
        if (user != null && user.getPreferences() != null) {
            return List.of(user.getPreferences().split(","));
        }
        return null;  
    }
}

