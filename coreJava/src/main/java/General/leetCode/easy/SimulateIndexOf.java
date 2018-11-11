package General.leetCode.easy;

public class SimulateIndexOf {

	public static void main(String[] args) {

		System.out.println(strStr("chiraag", "aa"));
		System.out.println(strStr("aaa", "aaa"));
		System.out.println(strStr("chirag", "chirag"));
		System.out.println(strStr("bbaa", "aab"));
		System.out.println(strStr("mississippi", "issip"));
		System.out.println(strStr("mississippi", "sippj"));

	}

	public static int strStr(String haystack, String needle) {

		if (needle.length() == 0) {
			return 0;
		} else if (haystack.length() == 0) {
			return -1;
		} else {

			// sol 1 : // 100%
			// return haystack.indexOf(needle);

			// sol 2 : // 61%

			char[] hsArr = haystack.toCharArray();
			int hsArrLen = hsArr.length;
			char[] nArr = needle.toCharArray();
			int nArrLen = nArr.length;
			int nArrLenMinus1 = nArrLen - 1;

			// iterate over offsets : offset -> first occurance of needle [index 0 character] in haystack.

			// find first occurance (offset)
			int offset = -1;

			for (int i = 0; i < hsArrLen; i++) {
				if (hsArr[i] == nArr[0]) {
					offset = i;
					break;
				}
			}

			int firstO = offset;

			boolean found = false;
			while (offset != -1 && !found) {

				int nIndex = 0;
				for (int i = nIndex; i < nArrLen; i++) {
					if (offset < hsArrLen && hsArr[offset] == nArr[i]) {
						offset++;
						nIndex = i;
					} else {
						break;
					}
				}

				if (nIndex == nArrLenMinus1) {
					found = true;
				} else {
					found = false;

					if (offset == hsArrLen) {
						break;
					}

					boolean newOffset = false;
					for (int i = firstO + 1; i < hsArrLen; i++) {
						if (hsArr[i] == nArr[0]) {
							offset = i;
							newOffset = true;
							break;
						}
					}

					if (newOffset) {
						firstO = offset;

					} else {
						offset = -1;
					}
				}
			}

			return found ? firstO : -1;

		}

	}
}
