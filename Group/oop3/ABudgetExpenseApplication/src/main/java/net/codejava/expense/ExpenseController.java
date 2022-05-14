package net.codejava.expense;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.codejava.category.Category;
import net.codejava.category.CategoryRepository;

@Controller 
public class ExpenseController {

	@Autowired
	private ExpenseRepository expenserepo;
	
	@Autowired
	private CategoryRepository categoryrepo;
	
	@GetMapping ("/expense/new")
	public String ShowNewProductForm(Model model ) 
	{List<Category> listCategories = categoryrepo.findAll();
	
		model.addAttribute("expense",new Expense());
		model.addAttribute("listCategories", listCategories);
	
		return "expense_form";
	}
	
	@PostMapping("/expense/save")
	public String saveExpense(Expense expense)
	{
		expenserepo.save(expense);
		return "redirect:/expenses";
	}
	
	
	@GetMapping("/expenses")
	public String listExpenses(Model model)
	{
		List<Expense> listExpenses =expenserepo.findAll();
		model.addAttribute("listExpenses", listExpenses);
		return "expenses";
		
	}
	
	@GetMapping("expenses/edit/{id}")
	public String ShowEditProductForm(@PathVariable("id") Integer id, Model model) {
		Expense expense = expenserepo.findById(id).get();
		List<Category> listCategories = categoryrepo.findAll();
		
	
		model.addAttribute("listCategories", listCategories);
	
		
		model.addAttribute("expense", expense);
		
		return "expense_form";
		
	}
	
	@GetMapping("expenses/delete/{id}")
	public String deleteExpense(@PathVariable("id") Integer id, Model model) {
	expenserepo.deleteById(id);
	
	return "redirect:/expenses";
	
}

	
	    @GetMapping("/expense")
	    public String sendForm(Model model) {
	        model.addAttribute("exp", new Expense());
	        return "expense";
	    }

	    @PostMapping("/expense_form")
	    public String processForm(@ModelAttribute Expense exp, BindingResult result, Model model)
	    {
	        model.addAttribute("exp", exp);
	        return "reg_success";
	    }
}
