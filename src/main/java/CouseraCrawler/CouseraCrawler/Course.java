package CouseraCrawler.CouseraCrawler;

public class Course {
	private String name, id, slug;

	// Track for their: newCareer%, tangibleCareerBenefit, payIncreaseOrPromotion
	private int newCareer = -1, benefit = -1, promotion = -1;

	public Course(String name, String id, String slug) {
		this.name = name;
		this.id = id;
		this.slug = slug;
	}

	public void updateCareer (int rate) {
		newCareer = rate;
	}

	public void updateBenefit (int rate) {
		benefit = rate;
	}

	public void updatePromotion (int rate) {
		promotion = rate;
	}
	

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getSlug() {
		return slug;
	}
	
	public int getCareer() {
		return newCareer;
	}
	public int getBenefit() {
		return benefit;
	}
	public int getPromotion() {
		return promotion;
	}
}
