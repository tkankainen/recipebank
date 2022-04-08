package RecipeBank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import RecipeBank.domain.CategoryRepository;
import RecipeBank.domain.RecipeRepository;

@DataJpaTest
public class RecipeRepositoryTest {
	
	@Autowired
	RecipeRepository repository;
	CategoryRepository categoryRepository;
	
	
}
