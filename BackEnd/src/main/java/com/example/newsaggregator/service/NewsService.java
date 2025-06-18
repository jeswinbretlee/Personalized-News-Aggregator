//package com.example.newsaggregator.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.example.newsaggregator.bean.NewsBean;
//import com.example.newsaggregator.dao.NewsDao;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class NewsService {
//
//    @Autowired
//    private NewsDao newsDao;
//    
//
//    public NewsDao getNewsDao() {
//		return newsDao;
//	}
//
//
//	public void setNewsDao(NewsDao newsDao) {
//		this.newsDao = newsDao;
//	}
//
//
//	public int addNews(NewsBean news) {
//        if (news != null) {
//            newsDao.save(news);
//            return 1;
//        }
//        return 0;
//    }
//    
//
//    public int updateNews(NewsBean news) {
//        if (news != null && newsDao.existsById(news.getId())) {
//            newsDao.save(news);
//            return 1;
//        }
//        return 0;
//    }
//
//    public int deleteNews(int id) {
//        if (id != 0 && newsDao.existsById(id)) {
//            newsDao.deleteById(id);
//            return 1;
//        }
//        return 0;
//    }
//
//    public ArrayList<NewsBean> getAllNews() {
//        return (ArrayList<NewsBean>) newsDao.findAll();
//    }
//
//
//        // Method to get news based on user preferences (categories)
//        public List<NewsBean> getNewsByPreferences(String username) {
//            if (username == null || username.isEmpty()) {
//                return new ArrayList<>(); // Return an empty list if no preferences are set
//            }
//            return newsDao.findAll(); // Fetch news that matches the preferences
//        }
//
//    
//
//
// 
//
//
//	
//}

package com.example.newsaggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.newsaggregator.bean.NewsBean;
import com.example.newsaggregator.dao.NewsDao;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    private NewsDao newsDao;

    public int addNews(NewsBean news) {
        if (news != null) {
            newsDao.save(news);
            return 1;
        }
        return 0;
    }

//    public int updateNews(NewsBean news) {
//        if (news != null && newsDao.existsById(news.getId())) {
//            newsDao.save(news);
//            return 1;
//        }
//        return 0;
//    }
    public int updateNews(NewsBean news) {
        // Check if the news item exists
        if (news != null && newsDao.existsById(news.getId())) {
            newsDao.save(news); // Update the record
            return 1; // Successfully updated
        }
        return 0; // Record not found
    }

//    public int deleteNews(int id) {
//        if (id != 0 && newsDao.existsById(id)) {
//            newsDao.deleteById(id);
//            return 1;
//        }
//        return 0;
//    }
    public int deleteNews(int id) {
        if (newsDao.existsById(id)) {
            newsDao.deleteById(id);
            return 1;
        }
        return 0;
    }
//
//    public List<NewsBean> getAllNews() {
//        return newsDao.findAll();
//    }
    public List<NewsBean> getAllNews() {
        return newsDao.findAll();
    }
//    public List<NewsBean> getNewsByPreferences(String username) {
//        return newsDao.findByCategory(username);
//    }
    

        // Get news based on the user's categories/preferences
//        public List<NewsBean> getNewsByCategories(String prefdet) {
//        	List<NewsBean> selList=new ArrayList<NewsBean>();
//        	List<NewsBean> all=newsDao.findAll();
//        	System.out.println(all);
//        	for(NewsBean nb:all)
//        	{
//        		if(nb.getCategory().equalsIgnoreCase(prefdet))
//        		{
//        			selList.add(nb);
//        		}
//        	}
//        	System.out.println("SEL LIST");
//        	System.out.println(selList);
//        	return selList;
//        }
//    
    public List<NewsBean> getNewsByCategories(String prefdet) {
        return newsDao.findByCategory(prefdet);
    }

}

