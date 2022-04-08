package RecipeBank.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import RecipeBank.domain.CategoryRepository;
import RecipeBank.domain.Recipe;
import RecipeBank.domain.RecipeRepository;

@Controller 
public class RecipeBankController {
	@Autowired
	private RecipeRepository repository;
	@Autowired
	private CategoryRepository crepository;
	
	@GetMapping("/index")
	public String recipebank(Model model) {
		model.addAttribute("recipes", repository.findAll());
		return "index";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/addrecipe")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("categories", crepository.findAll());
		return "addrecipe";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping("/save")
	public String save(@Valid Recipe recipe, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("Validation error");
        	return "/addrecipe";
        }
		repository.save(recipe);
		return "redirect:/index";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteRecipe(@PathVariable("id") Long id) {
    	repository.deleteById(id);
        return "redirect:/index";
    }
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/editrecipe/{id}")
	public String editRecipe(@PathVariable("id") Long id, Model model) {
		model.addAttribute("recipe", repository.findById(id));
		model.addAttribute("categories", crepository.findAll());
		return "editrecipe";
	} 
}
