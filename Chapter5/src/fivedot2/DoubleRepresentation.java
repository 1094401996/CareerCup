package fivedot2;
/**CareerCup 5.2
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary 
 * representation. If the number cannot be represented accurately in binary with at most 32 characters, 
 * print "ERROR."
 * 
 * method: 
 * 我擦，大二时候学的数电知识竟然用到了。。。。给跪了。。。
 * 有时间把任意数的转换方法写出来。。。。
 * @author gengchen
 *
 */

public class DoubleRepresentation {
	public static void main(String[] args){
		double[] num = {0.4, 0.5, 0.75,0.25,0.11, 0.23};
		for (double val : num){
			System.out.println(val + "'s binary representation:  " + doublerepresentation(val));
		}
	}
	
	public static String doublerepresentation(double  num){
		if (num >= 1 || num <= 0){
			return "ERRFOR";
		}
		StringBuffer binary = new StringBuffer();
		binary.append("0");
		binary.append(".");
		
		while(num != 0){
			if(binary.length() > 32){
				return "ERROR";
			}
			double r = num * 2;
			if (r >= 1){
				binary.append(1);
				num = r - 1;
			}else{
				binary.append(0);
				num = r;
			}
		}
		return binary.toString();
	}

}
