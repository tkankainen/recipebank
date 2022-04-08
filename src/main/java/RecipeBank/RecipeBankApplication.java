package RecipeBank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import RecipeBank.domain.Category;
import RecipeBank.domain.CategoryRepository;
import RecipeBank.domain.Recipe;
import RecipeBank.domain.RecipeRepository;
import RecipeBank.domain.User;
import RecipeBank.domain.UserRepository;

@SpringBootApplication
public class RecipeBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeBankApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner recipeDemo(RecipeRepository repository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Breakfast"));
			crepository.save(new Category("Lunch"));
			crepository.save(new Category("Dinner"));
			
			repository.save(new Recipe("Green Curry", "source", 2, crepository.findByName("Lunch").get(0)));
			repository.save(new Recipe("Pesto Eggs", "source", 1, crepository.findByName("Breakfast").get(0)));
		
			urepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			urepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
		};
	}
}
