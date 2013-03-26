package onedot8;

/**
 * Career1.8
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one 
 * call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
 * 2013.02.25
 * @method S = AB  S1 = BA, so S1 is a substring of SS(ABAB)
 * @author gengchen
 *
 */

public class IsRotation {

	public static void main(String[] args) {
	
	   System.out.println(rotation(new StringBuffer("abcdefg"),new StringBuffer("cdefgab")));
	   System.out.println(rotation(new StringBuffer("abcdefg"),new StringBuffer("gfedcba")));
		
	}
	
	public static boolean rotation(StringBuffer s1 , StringBuffer s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2)
			return false;
		s1.append(s1);
		String a = "anc";
		String b = "a";
		a.contains(b);
		return isSubstring(s1,s2);
	}
	
	public static boolean isSubstring(StringBuffer s1, StringBuffer s2){
		int len = s2.length();
		for(int start = 0; start < len; start ++){
			int j = start;
			for(int i = 0 ;i < len; i++){
				if (s2.charAt(i) == s1.charAt(j)){
					if( i == len -1)
						return true;
					j++;
				}else{
					break;
				}
				
			}
		}
		return false;
	}
	


}
