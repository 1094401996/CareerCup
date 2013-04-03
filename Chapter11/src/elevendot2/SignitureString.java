package elevendot2;

import java.util.Collections;

import sortingAlgorithms.Quicksort;

public class SignitureString implements Comparable<SignitureString> {
	private StringBuffer str;
	private StringBuffer Signatue;
	
	
	public StringBuffer getStr() {
		return str;
	}

	public StringBuffer getSignatue() {
		return Signatue;
	}

	public SignitureString(StringBuffer str){
		this.str = str;
		this.Signatue = getSigniture(str);
	}
	
	private StringBuffer getSigniture(StringBuffer strOrigin){
		StringBuffer str = new  StringBuffer(strOrigin.toString().toLowerCase());
		Character[] arr = new Character[str.length()];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = new Character(str.charAt(i));
		}
		Quicksort<Character> qs = new Quicksort<Character>();
		qs.sort(arr);
		for(int i = 0; i < arr.length; i++){
			str.setCharAt(i, arr[i]);
		}
		
		return str;
	}
	


	@Override
	public int compareTo(SignitureString o) {
		// TODO Auto-generated method stub
          return this.Signatue.toString().compareTo(o.Signatue.toString());
 
	}
}
