//package com.example.newsaggregator.service;
//
//import com.example.newsaggregator.bean.AdminBean;
//import com.example.newsaggregator.bean.UserBean;
//import com.example.newsaggregator.dao.AdminDao;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AdminService {
//
//    @Autowired
//    private AdminDao adminRepository;
//
//	public AdminDao getAdminRepository() {
//		return adminRepository;
//	}
//
//    public int registerAdmin(AdminBean user) {
//        if (adminRepository.findByUsername(user.getUsername()) == null) {
//            adminRepository.save(user);
//            return 1;
//        }
//        return 0;
//    }
//
//	public void setAdminRepository(AdminDao adminRepository) {
//		this.adminRepository = adminRepository;
//	}
//	public AdminBean loginUser(UserBean user) {
//	      List<AdminBean> all = adminRepository.findAll();
//	      AdminBean ub=new AdminBean();
//	      int flag=0;
//	      for(AdminBean u:all)
//	      {
//	    	  if(u.getUsername().equals(user.getUsername())&&(u.getPassword().equals(user.getPassword())))
//	    			  {
//	    		  		ub=u;
//	    		  		System.out.println(u);
//	    		  		flag=1;
//	    			  }
//	      }
//	      if(flag==0)
//	      {
//	    	  System.out.println("Not Present");
//	    	  return null;
//	      }
//	        return ub;
//	    }
//
//}
package com.example.newsaggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsaggregator.bean.AdminBean;
import com.example.newsaggregator.bean.UserBean;
import com.example.newsaggregator.dao.AdminDao;

@Service
public class AdminService {

    @Autowired
    private AdminDao adminRepository;

    public int registerAdmin(AdminBean admin) {
        if (adminRepository.findByUsername(admin.getUsername()) == null) {
            adminRepository.save(admin);
            return 1;
        }
        return 0;
    }

    public AdminBean loginUser(UserBean user) {
        return adminRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
