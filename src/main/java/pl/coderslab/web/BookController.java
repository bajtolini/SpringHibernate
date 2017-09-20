package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;

@Controller
public class BookController {

	@Autowired
	BookDao bookDao;
	
	@RequestMapping("/addBook")
	@ResponseBody
	public String add() {
		Book book = new Book(
				"Swiezaczek",
				new Author("Pomidor", "Patryk"),
				10.0,
				new Publisher("pubMla"),
				"Mi bello");
		bookDao.save(book);
		return "New book ID - " + book.getId();
	}
	
	@RequestMapping("/modifyBook/{id}")
	@ResponseBody
	public String modify(@PathVariable Long id) {
		Book book = new Book(
				"Swiezaczek",
				new Author("Brokul", "Bartek"),
				5.0,
				new Publisher("pub"),
				"MlaskMlask");
		book.setId(id);
		bookDao.update(book);
		return "Updated book with ID - " + id;
	}
	
	@RequestMapping("/getBook/{id}")
	@ResponseBody
	public String get(@PathVariable Long id) {
		return bookDao.findById(id).toString();
	}
	
	@RequestMapping("/deleteBook/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		bookDao.delete(bookDao.findById(id));
		return "Deleted book with ID - " + id;
	}
	
}
