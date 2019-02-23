package General.courseEra.utils;

import java.util.Arrays;

public class CEUtils {

	public static String print(Object[]... objects) {

		StringBuilder sb = new StringBuilder();

		for (Object[] x : objects) {

			sb.append("[ ");
			Arrays.stream(x).forEach(y -> sb.append(y.toString() + " "));
			sb.append(" ]\n");

		}

		String str = sb.toString();
		
		return str;
	}

}
