package onedot1;
import java.util.HashMap;

import java.util.Map;
/**
* Implement an algorithm to determine if a string has all unique characters
*/
public class UniqueChar {
/**
* @param args
*/
    public static void main(String[] args) {
        String[] strArray ={"abcdef","dfdsafdsf"};
        for (String str : strArray)
            System.out.println(isUniqueChar1(str));
        for (String str : strArray)
            System.out.println(isUniqueChar2(str));
        for (String str : strArray)
            System.out.println(isUniqueChar3(str));
    }
//bitmap method
    public static boolean isUniqueChar1(String str){
        boolean [] set= new boolean[256];
        for (int i=0; i < 256; i++)
            set[i] = false;
        int len=str.length();
        for (int j =0; j < len; j++){
            int val =str.charAt(j);
            if (set[val] == true)
                return false;
            else
                set[val] = true ;
        }
        return true;
    }
//hash table
    public static boolean isUniqueChar2(String str){
        Map<Integer,Character> charMap =new HashMap<Integer,Character>();
        for (int i=0; i < str.length(); i++){
            char val = str.charAt(i);
            int key = val;
            if ((charMap.containsKey(key)) == true){
                return false;
            }
            else
            charMap.put(key,val);
            }
            return true;
        }
        //quicksort
    public static boolean isUniqueChar3(String str){
        char [] data = str.toCharArray();
        quicksort(data,0,data.length-1);
        for (int i = 1; i < data.length;i++){
            if (data[i] == data[i - 1])
                return false;
        }
        return true;
    }
    public static void quicksort(char [] data, int left, int right){
        if (left < right){
        int pivotindex = partition(data, left, right);
        quicksort(data,left,pivotindex-1);
        quicksort(data,pivotindex+1,right);
        }
    }
    public static int partition(char[] data, int left, int right){
        char pivot = data[right];
        int i = left -1 ;
        char temp;
        for(int j= left; j < right ; j++){
            if (data[j] <= pivot){
            i++;
            temp = data [j];
            data[j]=data[ i];
            data[i]=temp;
            }
        }
        temp=data[right];
        data[right] = data[i+1];
        data[i+1] = temp;
        return i+1;
     }
  }
