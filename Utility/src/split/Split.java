package split;

import java.util.ArrayList;


public class Split {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  StringBuffer str= new StringBuffer("you are really stupid");
		  char s = ' ';
		  reverse(str, 0, str.length() - 1);
		  System.out.println(str.toString());
		  split(str,s);
		  System.out.println(str.toString());
	}
	
	public static void split(StringBuffer str, char s){
		boolean flag = true;
		int start = 0;
		for(int i = 0 ; i < str.length(); i ++){
			if(str.charAt(i) == s){
				if(flag ==false){	
					reverse(str,start,i - 1);
				}
				flag = true;
			}else{
				if(flag == true){
					start = i;
				}
				flag = false;
			}
		}
		if(flag == false){
			reverse(str,start,str.length() - 1);
		}
	}
	private static void reverse(StringBuffer str, int low, int high){
		for (int i = low; i < (high + low + 1)/2 ; i++){
			char temp = str.charAt(i);
			str.setCharAt(i, str.charAt(high - (i - low)));
			str.setCharAt(high - (i - low), temp);
		}
	}

}