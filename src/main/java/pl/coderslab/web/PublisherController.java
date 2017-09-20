package pl.coderslab.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;;

@Controller
public class PublisherController {

	@Autowired
	PublisherDao publisherDao;
	
	@RequestMapping("/addPublisher")
	@ResponseBody
	public String add() {
		Publisher publisher = new Publisher(
				"Pomidor Patryk");
		publisherDao.save(publisher);
		return "New publisher ID - " + publisher.getId();
	}
	
	@RequestMapping("/modifyPublisher/{id}")
	@ResponseBody
	public String modify(@PathVariable Long id) {
		Publisher publisher = new Publisher(
				"Brokul Bartek");
		publisher.setId(id);
		publisherDao.update(publisher);
		return "Updated publisher with ID - " + id;
	}
	
	@RequestMapping("/getPublisher/{id}")
	@ResponseBody
	public String get(@PathVariable Long id) {
		return publisherDao.findById(id).toString();
	}
	
	@RequestMapping("/deletePublisher/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		publisherDao.delete(publisherDao.findById(id));
		return "Deleted publisher with ID - " + id;
	}
}
