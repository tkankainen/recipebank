package RecipeBank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import RecipeBank.domain.Recipe;
import RecipeBank.domain.RecipeRepository;

@RestController
public class RestRecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@GetMapping("recipes")
	Iterable<Recipe> getAll() {
		return recipeRepository.findAll();
	}
	
	@PostMapping("recipes")
	Recipe newRecipe(@RequestBody Recipe newRecipe) {
		return recipeRepository.save(newRecipe);
	}
	
	@PutMapping("/recipes/{id}")
	Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
		newRecipe.setId(id);
		return recipeRepository.save(newRecipe);
	}

	@DeleteMapping("/recipes/{id}")
	void deleteRecipe(@PathVariable Long id) {
		recipeRepository.deleteById(id);
	}
}
