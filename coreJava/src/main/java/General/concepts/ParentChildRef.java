package General.concepts;

/**
 * Instance methods are overridden and variables are hidden. Which method is
 * invoked depends on the class of the actual object, while field is
 * accessed depends on the class of the variable.
 * 
 * @author cnayak
 *
 */
public class ParentChildRef {

	class Baap {
		public int h = 4;

		public int getH() {
			System.out.println("Baap " + h);
			return h;
		}
	}

	public class Beta extends Baap {
		public int h = 44;

		public int getH() {
			System.out.println("Beta " + h);
			return h;
		}
	}

	public static void main(String[] args) {
		ParentChildRef xx = new ParentChildRef();
		Baap b = xx.new Beta();
		System.out.println(b.h + " " + b.getH());
		Beta bb = (Beta) b;
		System.out.println(bb.h + " " + bb.getH());
	}

}
