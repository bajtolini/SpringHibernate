package pl.coderslab.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {

	@RequestMapping("/")
	public String helloView(HttpServletRequest request) {
		
		return "hello";
	}
	
	@ModelAttribute("skills")
	public Collection<String> skills() {
		List<String> skills = new ArrayList<>();
		skills.add("JAVA");
		skills.add("Python");
		skills.add("Ruby");
		skills.add("PHP");
		
		return skills;
	}
	
	@RequestMapping("/form-skills")
	public String indexAction() {
		return "skills";
	}
}
