package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Controller
public class PersonController {

	@Autowired
	PersonDao personDao;
	
	@RequestMapping("/addPerson")
	@ResponseBody
	public String add() {
		Person person = new Person(
				"login",
				"password",
				"lll@lll.com",
				new PersonDetails());
		personDao.save(person);
		return "New person ID - " + person.getId();
	}
	
	@RequestMapping("/modifyPerson/{id}")
	@ResponseBody
	public String modify(@PathVariable Long id) {
		Person person = new Person(
				"newLogin",
				"newPassword",
				"lll@lll.com",
				new PersonDetails());
		person.setId(id);
		personDao.update(person);
		return "Updated person with ID - " + id;
	}
	
	@RequestMapping("/getPerson/{id}")
	@ResponseBody
	public String get(@PathVariable Long id) {
		return personDao.findById(id).toString();
	}
	
	@RequestMapping("/deletePerson/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		personDao.delete(personDao.findById(id));
		return "Deleted person with ID - " + id;
	}
}
