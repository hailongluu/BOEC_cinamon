package group.faf.bookstore.model.product.book;

import group.faf.bookstore.model.common.TimeConvert;
import group.faf.bookstore.model.connection.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookDAOImpl implements BookDAO {
    Connection connection;

    public BookDAOImpl() {
        DBconnection dBconnection = new DBconnection();
        try {
            this.connection = dBconnection.getConnect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void addBook(Book book) {
        try {
            String sql = "INSERT INTO book ( `name`, `publishDate`, `price`, `numberOfPages`, `category`, `author`, `publisher`) VALUES ( ?, ?, ?, ?, ?, ?, ?);\n";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, book.getName());
            pre.setString(2, TimeConvert.convertToString(book.getPublishDate()));
            pre.setFloat(3, book.getPrice());
            pre.setInt(4, book.getNumberOfPage());
            pre.setString(5, book.getCategory().name());
            pre.setString(6, book.getAuthor());
            pre.setString(7, book.getPublisher());
            pre.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> getListBook() {
        ArrayList<Book> listBook = new ArrayList<>();
        try {
        String sql = "SELECT * FROM book;";
        PreparedStatement pre = connection.prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()){
            Date date = TimeConvert.converToDate(rs.getString(3));
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setName(rs.getString(2));
            book.setPublishDate(date);
            book.setPrice(rs.getFloat(4));
            book.setNumberOfPage(rs.getInt(5));
            book.setCategory(Category.valueOf(rs.getString(6)));
            book.setAuthor(rs.getString(7));
            book.setPublisher(rs.getString(8));
            book.setImageLink(rs.getString(9));
            listBook.add(book);
        }
        return listBook;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Book> getAllBook() {
        return null;
    }

    @Override
    public Book getBookById(int id) {
        Book book = null;
        try {
            String sql = "SELECT * FROM book WHERE id = ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            if (rs.next()){
                Date date = TimeConvert.converToDate(rs.getString(3));
                book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPublishDate(date);
                book.setPrice(rs.getFloat(4));
                book.setNumberOfPage(rs.getInt(5));
                book.setCategory(Category.valueOf(rs.getString(6)));
                book.setAuthor(rs.getString(7));
                book.setPublisher(rs.getString(8));
                book.setImageLink(rs.getString(9));
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return book;
    }


    public List<Book> getListBookByName(String name){
        ArrayList<Book> listBook = new ArrayList<>();
        try {
            String sql = "SELECT * FROM book WHERE name like ?";
            PreparedStatement pre = connection.prepareStatement(sql);
            StringBuilder sb = new StringBuilder("%").append(name).append("%");
            pre.setString(1,sb.toString());
            ResultSet rs = pre.executeQuery();
            while (rs.next()){
                Date date = TimeConvert.converToDate(rs.getString(3));
                Book book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setPublishDate(date);
                book.setPrice(rs.getFloat(4));
                book.setNumberOfPage(rs.getInt(5));
                book.setCategory(Category.valueOf(rs.getString(6)));
                book.setAuthor(rs.getString(7));
                book.setPublisher(rs.getString(8));
                book.setImageLink(rs.getString(9));
                listBook.add(book);
            }
            return listBook;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void updateBook(Book book, Book newBook) {

    }

    @Override
    public void deleteBook(Book book) {

    }

//    private Category getCategory(int id) throws SQLException {
//        String sql = "SELECT * FROM category WHERE Id = ?";
//        PreparedStatement pre = connection.prepareStatement(sql);
//        pre.setInt(1, id);
//        ResultSet rs = pre.executeQuery();
//        Category category = null;
//        while (rs.next()) {
//            category = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
//        }
//        return category;
//    }

//    private Publisher getPublisher(int id) throws SQLException {
//        String sql = "SELECT * FROM publisher WHERE Id = ?";
//        PreparedStatement pre = connection.prepareStatement(sql);
//        pre.setInt(1, id);
//        ResultSet rs = pre.executeQuery();
//        Publisher publisher = null;
//        while (rs.next()) {
//            publisher = new Publisher(rs.getInt(1), rs.getString(2), rs.getString(3), null, rs.getString(5), rs.getString(6));
//        }
//        return publisher;
//    }

}