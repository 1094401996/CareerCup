package onedot5;

public class Compression {
	public static void main(String[]args){
		Compression com = new Compression();
		String str = "fgfdgfdsgfhjhjjjjjjjjjjjjjjjjjj";
		str = com.compression(str);
		System.out.println(str);
	}
	public String compression(String str){
		int len = str.length();
		int len1 = this.countcheck(str);
		if(len1 >= len){
			System.out.println("no need to compression");
			return str;
		}
		StringBuffer str1 = new StringBuffer(str);
		int count = 1;
		StringBuffer str2 = new StringBuffer();
		char flag = str1.charAt(0);
		int start = 0;
		for(int i = 1; i< len; i++){
		        	if(str1.charAt(i) == flag)
		        		count ++;
		        	else{
		        		str2.append(str1.charAt(start));
		        		str2.append(count);
		        		flag = str1.charAt(i);
		        		count = 1;
		        		start = i;	
		        	}
		}
		str2.append(flag);
		str2.append(count);
	
		return str2.toString();
	}
	
	
	private int countcheck(String str){
		char flag = str.charAt(0);
		int count = 1;
		int size = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == flag){
				count++;
			}else{
				size+=1+String.valueOf(count).length();
				flag = str.charAt(i);
				count = 1;
			}
		}
		return size += 1 + String.valueOf(count).length();
	}

}
