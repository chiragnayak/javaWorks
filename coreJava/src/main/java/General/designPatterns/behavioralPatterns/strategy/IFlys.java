package General.designPatterns.behavioralPatterns.strategy;


/**
 * IFlys interface is a strategy.
 * 
 * Concrete strategies are cantFly() canFly()
 * 
 * 
 * @author cnayak
 *
 */
public interface IFlys {
	
	String fly();

}

//family of algorithms or concrete strategies.
class canFly implements IFlys {

	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "I can Fly High !!";
	}
	
}

class canNotFly implements IFlys {

	@Override
	public String fly() {
		// TODO Auto-generated method stub
		return "can't fly !!";
	}
	
}
