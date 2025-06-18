////package com.example.newsaggregator.dao;
////
////import org.springframework.data.jpa.repository.JpaRepository;
////import org.springframework.stereotype.Repository;
////
////import com.example.newsaggregator.bean.UserBean;
////
////@Repository
////public interface UserDao extends JpaRepository<UserBean, Integer> {
////    UserBean findByUsername(String username);
////
////	UserBean findByUsernameAndPasswor(String username, String password);
////}
//package com.example.newsaggregator.dao;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import com.example.newsaggregator.bean.UserBean;
//
//@Repository
//public interface UserDao extends JpaRepository<UserBean, Integer> {
//
//    // Custom method to find user by username
//    UserBean findByUsername(String username);
//
//    // Custom method to find user by username and password
//    UserBean findByUsernameAndPassword(String username, String password);
//}
package com.example.newsaggregator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.newsaggregator.bean.UserBean;

@Repository
public interface UserDao extends JpaRepository<UserBean, Integer> {
    UserBean findByUsername(String username);
    UserBean findByUsernameAndPassword(String username, String password);
}

