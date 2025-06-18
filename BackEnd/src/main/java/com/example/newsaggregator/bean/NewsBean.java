//package com.example.newsaggregator.bean;
//
//import jakarta.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name = "news")
//public class NewsBean {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String title;
//    private String content;
//    private String category;
//    private String author;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date publishedDate = new Date();
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public String getContent() {
//		return content;
//	}
//
//	public void setContent(String content) {
//		this.content = content;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getAuthor() {
//		return author;
//	}
//
//	public void setAuthor(String author) {
//		this.author = author;
//	}
//
//	public Date getPublishedDate() {
//		return publishedDate;
//	}
//
//	public void setPublishedDate(Date publishedDate) {
//		this.publishedDate = publishedDate;
//	}
//
//}
package com.example.newsaggregator.bean;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "news")
public class NewsBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String category;
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedDate = new Date();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

	@Override
	public String toString() {
		return "NewsBean [id=" + id + ", title=" + title + ", content=" + content + ", category=" + category
				+ ", author=" + author + ", publishedDate=" + publishedDate + "]";
	}
    
}

