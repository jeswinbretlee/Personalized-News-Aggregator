package com.example.newsaggregator.dao;

import com.example.newsaggregator.bean.NewsBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao extends JpaRepository<NewsBean, Integer> {

    @Query("SELECT n FROM NewsBean n WHERE n.category IN :categories")
    List<NewsBean> findByCategoryIn(List<String> categories);
    List<NewsBean> findByCategory(@Param("category") String category);
}
