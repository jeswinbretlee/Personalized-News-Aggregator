//package com.example.newsaggregator.dao;
//
//import com.example.newsaggregator.bean.AdminBean;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//public interface AdminDao extends JpaRepository<AdminBean, Integer> {
//    AdminBean findByUsername(String username);
//
//	AdminBean findByUsernameAndPassword(String username, String password);
//
//	AdminBean findByUsernameAndPassword(String username, String password);
//}
package com.example.newsaggregator.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.newsaggregator.bean.AdminBean;

@Repository
public interface AdminDao extends JpaRepository<AdminBean, Integer> {

    // Custom method to find admin by username
    AdminBean findByUsername(String username);

    // Custom method to find admin by username and password
    AdminBean findByUsernameAndPassword(String username, String password);
}
