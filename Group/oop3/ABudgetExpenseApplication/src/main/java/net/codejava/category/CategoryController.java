package net.codejava.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	private CategoryRepository catrepo;
	
	@GetMapping("/categories")
	
	public String listCategories(Model model) {
		List<Category> listCategories = catrepo.findAll();
		model.addAttribute("listCategories",listCategories);
		
		return "categories";
	}
	
	@GetMapping("/category/new")
	public String showCategoriesNewForm(Model model)
	
	{
		model.addAttribute("category", new Category());
		return "category_form";
	}
	
	@PostMapping("/categories/save")
	public String saveCategories(Category category)
	
	{
		catrepo.save(category);
		return "redirect:/categories";
	}
	
}
