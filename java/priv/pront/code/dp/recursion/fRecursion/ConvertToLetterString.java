package priv.pront.code.dp.recursion.fRecursion;

/**
 * 规定1和A对应、2和B对应、3和C对应...
 * 那么一个数字字符串比如"111"，就可以转化为"AAA"、"KA"和"AK"。
 */
public class ConvertToLetterString {

	//i之前的位置，如何转换已经做过决定了
	//i...有多少种转换结果
	public static int number(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		return process(str.toCharArray(), 0);
	}

	public static int process(char[] chs, int i) {
		if (i == chs.length) {
			return 1;
		}
		if (chs[i] == '0') {
			return 0;
		}
		if (chs[i] == '1') {
			int res = process(chs, i + 1);  //i自己所谓单独的部分，后续有多少种方法
			if (i + 1 < chs.length) {
				res += process(chs, i + 2); //(i和i+1)作为单独的部分，后续有多少种方法
			}
			return res;
		}
		if (chs[i] == '2') {
			int res = process(chs, i + 1);  //i自己作为单独的部分，后续有多少种方法
//			(i和i+1)作为一个单独的部分二并且没有超过26，后续有多少种解法
			if (i + 1 < chs.length && (chs[i + 1] >= '0' && chs[i + 1] <= '6')) {
				res += process(chs, i + 2);
			}
			return res;
		}
//		chs[i] =='3'~'9'
		return process(chs, i + 1);
	}

	public static void main(String[] args) {
		System.out.println(number("11111"));
	}

}
