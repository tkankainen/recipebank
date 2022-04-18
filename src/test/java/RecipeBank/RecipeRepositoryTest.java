package RecipeBank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import RecipeBank.domain.Category;
import RecipeBank.domain.CategoryRepository;
import RecipeBank.domain.Recipe;
import RecipeBank.domain.RecipeRepository;

@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class RecipeRepositoryTest {
	
	@Autowired
	RecipeRepository repository;
	@Autowired
	CategoryRepository categoryRepository;
	
	@Test
	public void findByNameShouldReturnName() {
		List<Recipe> recipes = repository.findByName("Green Curry");
		assertThat(recipes.get(0).getName()).isEqualTo("Green Curry");
	}

	@Test
	public void findByDifficultyShouldReturnSize() {
		List<Recipe> recipes = repository.findByDifficultylevel(2);
		assertThat(recipes).hasSize(2);
	}

	@Test
	public void insertNewRecipe() {
		categoryRepository.save(new Category("Lunch"));
		Recipe recipe = new Recipe("Pad Thai", "Tasty", 2, categoryRepository.findByName("Lunch").get(0));
		repository.save(recipe);
		List<Recipe> recipes = repository.findByName("Pad Thai");
		assertThat(recipes.get(0).getName()).isEqualTo("Pad Thai");
		assertThat(recipe.getId()).isNotNull();
	}

	@Test 
	public void deleteRecipe() {
		 
		List<Recipe> recipes = repository.findByName("Green Curry");
		repository.deleteById(recipes.get(0).getId());
		recipes = repository.findByName("Green Curry");
		assertThat(recipes).hasSize(0);
	}
}
