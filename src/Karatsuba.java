
public class Karatsuba {
	public static void main(String[] args) {
		System.out.println(multiply("43524354325", "43254534325435"));
	}
	
	public static String multiply(String x, String y) {
		if(x.length() == 1 && y.length() == 1) {
			return Integer.toString(Integer.parseInt(x) * Integer.parseInt(y));
		}
		int len = Math.max(x.length(), y.length());
		int firstLen = len/2;
		int secondLen = len - firstLen;
		while(x.length() < len) {
			x = "0" + x;
		}
		while(y.length() < len) {
			y = "0" + y;
		}
		String firstX = x.substring(0, firstLen);
		String secondX = x.substring(firstLen, len);
		String firstY = y.substring(0, firstLen);
		String secondY = y.substring(firstLen, len);
		
		String mulX = multiply(firstX, firstY);
		String mulX2 = mulX.substring(0, mulX.length());
		for(int i = 0; i < 2 * secondLen; i++) {
			mulX += "0";
		}
		String mulY = multiply(secondX, secondY);
		String zup = sub(multiply(add(firstX, secondX), add(firstY, secondY)), add(mulX2, mulY));
		for(int i = 0; i < secondLen; i++) {
			zup += "0";
		}
		return normalise(add(add(mulX, mulY), zup));
	}
	
	public static String add(String x, String y) {
		String ret = "";
		int len = Math.max(x.length(), y.length());
		while(x.length() < len) {
			x = "0" + x;
		}
		while(y.length() < len) {
			y = "0" + y;
		}
		String revX = (new StringBuffer(x)).reverse().toString();
		String revY = (new StringBuffer(y)).reverse().toString();
		int carry = 0;
		for(int i = 0; i < len; i++) {
			int xe = Integer.parseInt(revX.substring(i, i+1));
			int ye = Integer.parseInt(revY.substring(i, i+1));
			int res = xe + ye + carry;
			carry = 0;
			if(res > 9) {
				carry += res / 10;
				res %= 10;
			}
			ret += Integer.toString(res);
		}
		if(carry != 0) {
			ret += Integer.toString(carry);
		}
		return (new StringBuffer(ret)).reverse().toString();
	}
	
	public static String sub(String x, String y) {
		String ret = "";
		int len = Math.max(x.length(), y.length());
		while(x.length() < len) {
			x = "0" + x;
		}
		while(y.length() < len) {
			y = "0" + y;
		}
		String revX = (new StringBuffer(x)).reverse().toString();
		String revY = (new StringBuffer(y)).reverse().toString();
		int carry = 0;
		for(int i = 0; i < len; i++) {
			int xe = Integer.parseInt(revX.substring(i, i+1));
			int ye = Integer.parseInt(revY.substring(i, i+1));
			int res = xe - ye + carry;
			carry = 0;
			if(res < 0) {
				carry = -1;
				res = res+10;
			}
			ret += Integer.toString(res);
		}
		return (new StringBuffer(ret)).reverse().toString();
	}
	
	public static String normalise(String num) {
		int j = 0;
		for(int i = 0; i < num.length(); i++) {
			if(num.substring(i, i+1).equals("0")) {
				j++;
			} else {
				break;
			}
		}
		return num.substring(j);
	}
}
