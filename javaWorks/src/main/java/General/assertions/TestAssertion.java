package General.assertions;

public class TestAssertion {

	public static void main(String[] args) {

		int x = makePositive(-10);

		assert (x >= 0) : "Impossible : " + x + " came negative !";

		x = makePositive(Integer.MIN_VALUE);

		assert (x >= 0) : "Impossible : " + x + " came negative !";

	}

	private static int makePositive(int i) {
		if (i < 0)
			return -i;
		else
			return i;
	}

}
