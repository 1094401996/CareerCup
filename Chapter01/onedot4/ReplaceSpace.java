package onedot4;

public class ReplaceSpace {
	public static void main(String[] args){
		StringBuffer s = new StringBuffer("Hello Chen Geng");
		int originlen = s.length();
		int spacenum = 0;
		for(int i = 0; i < originlen;i++){
		    if(s.charAt(i) == ' ')
		        spacenum++;;
		}
		for (int j = 0; j < spacenum; j++){
		    s.append(' ');
		    s.append(' ');
		}
		int newlen = s.length();
		char[]str = s.toString().toCharArray();
		start(str,originlen,newlen);
	    System.out.println(new String(str));
	}
	public static void start(char[]str,int originlen,int newlen){
		
		int k = newlen - 1;
		for(int j = originlen - 1; j >=0; j--){
			if (str[j] == ' '){
				str[k] = '%';
				str[--k] = '0';
				str[--k] = '2';
				k--;
				
			}else{
				str[k--] = str[j];
				
			}
		}
		
	}
}
