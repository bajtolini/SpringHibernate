package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;

@Controller
public class AuthorController {

	@Autowired
	AuthorDao authorDao;
	
	@RequestMapping("/addAuthor")
	@ResponseBody
	public String add() {
		Author author = new Author(
				"Swiezaczek",
				"Pomidor Patryk");
		authorDao.save(author);
		return "New author ID - " + author.getId();
	}
	
	@RequestMapping("/modifyAuthor/{id}")
	@ResponseBody
	public String modify(@PathVariable Long id) {
		Author author = new Author(
				"Swiezaczek",
				"Brokul Bartek");
		author.setId(id);
		authorDao.update(author);
		return "Updated author with ID - " + id;
	}
	
	@RequestMapping("/getAuthor/{id}")
	@ResponseBody
	public String get(@PathVariable Long id) {
		return authorDao.findById(id).toString();
	}
	
	@RequestMapping("/deleteAuthor/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		authorDao.delete(authorDao.findById(id));
		return "Deleted author with ID - " + id;
	}
}
