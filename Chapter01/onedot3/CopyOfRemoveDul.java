//吐下糟，由于string，stringbuffer，char[]的基本java操作不熟，在这题上浪费了太多的时间。第一次感到C是真方便。。。。
/*
* Design an algorithm and write code to remove the duplicate characters in a string without
* using any additional buffer. NOTE: One or two additional variables are fine.
* An extra copy of the array is not.
*/
public class CopyOfRemoveDul{
    public static void main(String[] args){
        CopyOfRemoveDul q = new CopyOfRemoveDul();
        StringBuffer[] strings ={
            new StringBuffer("abcdddg"),
            new StringBuffer("aabbccddeeffgghhiijjkkllmmnn"),
            new StringBuffer("abcdefgabcdefg"),
            new StringBuffer("aaaaaaa"),
            new StringBuffer("t"),
            new StringBuffer("ababababababa"),
            new StringBuffer("12 32 9 ' e.g e' f"),
            new StringBuffer(),
    };
        for (StringBuffer str : strings){
            q.DeleteDuplicate1(str);
            System.out.println(str);
        }
    }
    public void DeleteDuplicate1(StringBuffer str){
        if (str == null)
        return ;
        int len = str.length();
        if ((len == 0) || (len ==1))
            return ;
        int tail = 0;
        for ( int j = 1; j < len; j++){
            int i = tail;
            boolean dul = false;
            while (i >= 0){
                if (str.charAt(i) == str.charAt(j)){
                    dul = true;
                    break;
                }
                i--;
            }   
            if (dul == false)
            str.setCharAt(++tail,str.charAt(j));
        }
        if(tail == len -1)
        return ;
        str.delete(tail+1, len);
    }
}
