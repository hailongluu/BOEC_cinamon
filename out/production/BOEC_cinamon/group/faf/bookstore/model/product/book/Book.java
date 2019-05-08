package group.faf.bookstore.model.product.book;


import group.faf.bookstore.model.product.Product;

import java.util.Date;
import java.util.List;

public class Book extends Product {


	private String publisher;
	private Date publishDate;
	private Category category;
	private int numberOfPage;
	private String author;
	private String imageLink;
	private List<Review> listReview;

	public Book(String publisher, Date publishDate, Category category, int numberOfPage, String author, String imageLink, List<Review> listReview) {
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.category = category;
		this.numberOfPage = numberOfPage;
		this.author = author;
		this.imageLink = imageLink;
		this.listReview = listReview;
	}

	public Book() {
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(int numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public List<Review> getListReview() {
		return listReview;
	}

	public void setListReview(List<Review> listReview) {
		this.listReview = listReview;
	}
}