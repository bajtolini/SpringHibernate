package pl.coderslab.web;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.CartoonDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Cartoon;
import pl.coderslab.entity.Category;

@Controller
@RequestMapping("/cartoon")
public class CartoonController {

	@Autowired
	CartoonDao cartoonDao;
	
	private final CategoryDao categoryDao;
	
	@Autowired
	public CartoonController(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@ModelAttribute("categories")
	public Collection<Category> categories() {
		return this.categoryDao.getList();
	}
	
	@ModelAttribute("colors")
	public String[] color() {
		String[] color = new String[4];
		color[0] = "RED";
		color[1] = "BLUE";
		color[2] = "ORANGE";
		color[3] = "GREEN";
		return color;
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("cartoon", new Cartoon());
		return "cartoonAdd";
	}
	
	@PostMapping({"/add", "/modify/{id}"})
	public String addForm(@ModelAttribute Cartoon cartoon) {
		if (cartoon.getId() == null) {
			cartoonDao.save(cartoon);
		} else {
			cartoonDao.update(cartoon);
		}
		return "redirect:/cartoon/list";
	}
	
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable Long id, Model model) {
		model.addAttribute("cartoon", cartoonDao.findById(id));
		return "cartoonAdd";
	}
	
	@RequestMapping("/get/{id}")
	@ResponseBody
	public String get(@PathVariable Long id) {
		return cartoonDao.findById(id).toString();
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		cartoonDao.delete(cartoonDao.findById(id));
		return "redirect:/cartoon/list";
	}
	
	@RequestMapping("/list")
	public String getAll(Model model) {
		List<Cartoon> cartoons = cartoonDao.getAll();
		model.addAttribute("cartoons", cartoons);
		return "cartoon";
	}
	
	@RequestMapping("/details/{id}")
	public String details(@PathVariable Long id, Model model) {
		model.addAttribute("cartoon", cartoonDao.findById(id));
		return "cartoonDet";
	}
}
