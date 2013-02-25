package onedot8;

public class IsRotation {

	public static void main(String[] args) {
	
		IsRotation r = new IsRotation();
		System.out.println(r.rotation("abcdef","efabcl"));
		
	}
	
	public boolean rotation(String s1 , String s2){
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1 != len2)
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);
		
		
	}
	
	private boolean isSubstring(String s1, String s2){
		  int len = s2.length();
		for(int start = 0; start < len;start++){
			int j = start;
			for (int i = 0; i < len;i++){
				if(s2.charAt(i) == s1.charAt(j)){
					if( i == len -1)
						return true;
					j++;
				}
				else
					break;
			}		
		}
		return false;
	}

}
