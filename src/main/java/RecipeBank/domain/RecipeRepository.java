package RecipeBank.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{
	
	List<Recipe> findByName(String name);

	List<Recipe> findByDifficultylevel(int difficultylevel);

	Recipe getOne(Long id);

}
