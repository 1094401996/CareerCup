package onedot4;

public class ReplaceSpace {
	public static void main(String[] args){
		String s = "Hello Chen Geng                 ";
		
		char[]str = s.toCharArray();
		int length = 15;
		start(str,length);
	    System.out.println(new String(str));
	}
	public static void start(char[]str,int length){
		int spacenumber = 0;
		for(int i = 0; i < length; i++){
			if(str[i] == ' ')
				spacenumber++;
		}
		
		int newlength = length + 2 * spacenumber;
		int k = newlength - 1;
		str[newlength] = '\0';
		for(int j = length - 1; j >=0; j--){
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
