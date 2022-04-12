package RecipeBank.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity 
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Size(min=5, max=50, message="Name must be between 5 and 50 characters")
	private String name;
	
	private String source, link;
	
	@Min(value=1, message = "Difficulty level must be between 1-3 (1=easy, 2=intermediate, 3=hard)")
	@Max(value=3, message = "Difficulty level must be between 1-3 (1=easy, 2=intermediate, 3=hard)")
	private int difficultylevel;
	
	@Column(nullable = true, length = 64)
    private String photos;
	
	@ManyToOne
	@JoinColumn(name = "categoryid")
	private Category category;
	
	public Recipe() {
	}
	
	public Recipe(String name, Category category) {
		super();
		this.name = name;
		this.category = category;
	}


	public Recipe(@Size(min = 5, max = 50) String name, String source, @Min(1) @Max(3) int difficultylevel,
			Category category) {
		super();
		this.name = name;
		this.source = source;
		this.difficultylevel = difficultylevel;
		this.category = category;
	}
	

	public Recipe(@Size(min = 5, max = 50) String name, String source, String link, @Min(1) @Max(3) int difficultylevel,
			Category category) {
		super();
		this.name = name;
		this.source = source;
		this.link = link;
		this.difficultylevel = difficultylevel;
		this.category = category;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int getDifficultylevel() {
		return difficultylevel;
	}

	public void setDifficultylevel(int difficultylevel) {
		this.difficultylevel = difficultylevel;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Recipe [name=" + name + ", source=" + source + ", difficultylevel=" + difficultylevel + "]";
	}
	
}
