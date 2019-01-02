//import java.util.List;
//import java.util.ArrayList;
//
//public class ObservedPin {
//
//	static List<String> pin=new ArrayList<String>();
//	public static void del(int[][] ar,int q,String s){
//		for(int i=0;i<ar[q].length;i++){
//			if(q!=ar.length-1)
//				del(ar,q+1,s+ar[q][i]);
//			else
//				pin.add(s+ar[q][i]);
//		}
//	}
//	public static List<String> getPINs(String observed) {
//		int[][] adjacent = {{0,8},{1,2,4},{1,2,3,5},{2,3,6},{1,4,5,7},{2,4,5,6,8},{3,5,6,9},{4,7,8},{5,7,8,9,0},{6,8,9}};
//		final int [][] ar=new int[observed.length()][];
//		for(int i=0;i<observed.length();i++)
//			ar[i]=adjacent[observed.charAt(i)-48];
//		del(ar,0,"");
//		List<String> pins=new ArrayList<String>(pin);
//		pin.clear();
//		return pins;
//	}
//	public static void main(String[] args){
//		getPINs("369");
//	}
//} // ObservedPin
import java.util.*;

public class ObservedPin {

    private static final Map<Character,String> ADJACENTS = new HashMap<Character,String>() {{
        put('1', "124");
        put('2', "2135");
        put('3', "326");
        put('4', "4157");
        put('5', "54268");
        put('6', "6953");
        put('7', "748");
        put('8', "87590");
        put('9', "986");
        put('0', "08");
    }};

    public static List<String> getPINs(String observed) {
        
        List<String> ans = Arrays.asList("");
        
        for (char c: observed.toCharArray()) {
            
            List<String> tmp = new ArrayList<String>();
            for (char cc: ADJACENTS.get(c).toCharArray()) {
                for (String s: ans) tmp.add(s+cc);
            }
            ans = tmp;
        }
        return ans;
    }

}