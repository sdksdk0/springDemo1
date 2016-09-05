package cn.tf.demo2;

public class BookServiceImpl implements BookService {
	
	//private BookDao bookDao = new BookDaoImpl();
	
	private BookDao bookDao;
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	public void addBook(){
		bookDao.save();
	}
}
