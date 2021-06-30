package General.hackerEarth.june18Challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author cnayak
 *
 */
public class ArrayUpdate {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		if (str.length() > 0) {

			int length = Integer.parseInt(str);

			String data = br.readLine(); // Reading input from STDIN

			String[] dataArr = data.split("[\\s]{1,}");

			int num = 0;

			if (length != 0) {

				if (dataArr.length == length) {

					int[] ints = new int[dataArr.length];

					int sum = 0;
					for (int iCount = 0; iCount < ints.length; iCount++) {
						ints[iCount] = Integer.parseInt(dataArr[iCount].trim());
						sum = sum + ints[iCount];
					}

					while (true) {

						int newSum = length * num;

						if (newSum > sum) {

							break;
						}

						num++;

					}

					System.out.println(num);
				}

			}
		}

	}

}
