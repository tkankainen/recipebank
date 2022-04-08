package RecipeBank;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import RecipeBank.web.RecipeBankController;

@SpringBootTest
class RecipeBankApplicationTests {

	@Autowired
	private RecipeBankController controller;
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}


