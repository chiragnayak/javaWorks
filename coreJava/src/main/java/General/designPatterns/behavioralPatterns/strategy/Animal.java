package General.designPatterns.behavioralPatterns.strategy;


/**
 * 
 * Animal is context in which we have composed a stratgey
 * 
 * At runtime : the specific type of animal (say dog or bird) will choose 
 * which concrete strategy to initialize this composed reference to.
 * 
 * @author cnayak
 *
 */
public class Animal {
	
	private String name;
	private String breed;
	private String color;
	private int NumberOfLegs;
	
	//for Stratgy pattern, compose the behaviour 
	private IFlys flyType ;
	
	public Animal (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfLegs() {
		return NumberOfLegs;
	}

	public void setNumberOfLegs(int numberOfLegs) {
		NumberOfLegs = numberOfLegs;
	}

	public IFlys getFlyType() {
		return flyType;
	}

	public void setFlyType(IFlys flyType) {
		this.flyType = flyType;
	}

}
