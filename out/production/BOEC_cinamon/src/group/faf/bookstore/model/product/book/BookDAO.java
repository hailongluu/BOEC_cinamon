package group.faf.bookstore.model.product.book;


import java.util.List;

public interface BookDAO {


	void addBook( Book book);


	List<Book> getListBook();

	List<Book> getAllBook();

	Book getBookById(int id);

	void updateBook(Book book, Book newBook);


	void deleteBook(Book book);

}