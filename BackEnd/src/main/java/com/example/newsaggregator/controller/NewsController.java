//package com.example.newsaggregator.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.newsaggregator.bean.NewsBean;
//import com.example.newsaggregator.bean.UserBean;
//import com.example.newsaggregator.service.NewsService;
//import jakarta.servlet.http.HttpServletResponse;
//
//@RestController
//@CrossOrigin(origins = "*")
//@RequestMapping("/admin")
//public class NewsController {
//
//    @Autowired
//    private NewsService newsService;
//
//    @GetMapping("/welcome")
//    public String home() {
//        return "<h1>Welcome to Admin Dashboard</h1>";
//    }
//    
//        
//    @GetMapping("/addNews")
//    public String meth2(@ModelAttribute("nb")NewsBean nb)
//    {
//
//    	
//    	return "<h1>"+newsService.addNews(nb)+" record inserted successfully</h1>";
//    }
//    @GetMapping("/updateNews")
//    public String meth3(@ModelAttribute("nb")NewsBean nb)
//    {
//    	return "<h1>"+newsService.updateNews(nb)+" record updated successfully...</h1>";
//    }
//    @GetMapping("/deleteNews")
//    public String meth4(@RequestParam("eid")int eid)
//    {
//    	return "<h1>"+newsService.deleteNews(eid)+" record deleted successfully</h1>";
//    }
//    @GetMapping("/allEmp")
//    public ArrayList<NewsBean> meth5()
//    {
//    	return newsService.getAllNews();
//    }
// 
//
//}
package com.example.newsaggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.newsaggregator.bean.NewsBean;
import com.example.newsaggregator.service.NewsService;
import com.example.newsaggregator.service.UserService;

import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/admin")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/addNews")
    public String addNews(@RequestBody NewsBean news) {
        return "<h1>" + newsService.addNews(news) + " record inserted successfully</h1>";
    }

    @PutMapping("/updateNews/{id}")
    public ResponseEntity<String> updateNews(@PathVariable int id, @RequestBody NewsBean news) {
        news.setId(id); // Ensure the ID from the URL is set
        int updated = newsService.updateNews(news);
        if (updated > 0) {
            return ResponseEntity.ok("News updated successfully!");
        } else {
            return ResponseEntity.badRequest().body("News update failed. Record not found.");
        }
    }

    @DeleteMapping("/deleteNews/{id}")  // Changed from GET to DELETE for best practice
    public ResponseEntity<String> deleteNews(@PathVariable int id) {
        int result = newsService.deleteNews(id);
        if (result == 1) {
            return ResponseEntity.ok("News deleted successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("News not found.");
        }
    }

    @GetMapping("/allNews")
    public ResponseEntity<List<NewsBean>> getAllNews() {
        return ResponseEntity.ok(newsService.getAllNews());
    }

//    @GetMapping("/personalizedNews")
//    public List<NewsBean> getPersonalizedNews(@RequestParam("username") String username) {
//        return newsService.getNewsByPreferences(username);
//    }

    @Autowired
    private UserService userService;

    // Endpoint to fetch personalized news
    @GetMapping("/personalizedNews")
    public ResponseEntity<List<NewsBean>> getPersonalizedNews(@RequestParam String prefDetails) {
        List<NewsBean> newsList = newsService.getNewsByCategories(prefDetails);
        return ResponseEntity.ok(newsList);
    }
}

