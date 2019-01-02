import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chocotest {
	static List<String> pal = new ArrayList<String>();
	public static String swap(String a, int i, int j) { 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 
	private static void permute(String str, int l, int r) { 
		if (l == r){
			if(checkPalindrome(str))
				if(!pal.contains(str))
					pal.add(str);
		}
		else{ 
			for (int i = l; i <= r; i++) { 
				str = swap(str,l,i); 
				permute(str, l+1, r); 
				str = swap(str,l,i); 
			} 
		} 
	}
	static boolean checkPalindrome(String inputString) {
		int i1 = 0;
		int i2 = inputString.length()-1;
		while (i2>i1) {
			if (inputString.charAt(i1) != inputString.charAt(i2)) {
				return false;
			}
			++i1;
			--i2;
		}
		return true;
	}

	static String[] generatePalindromesChocoInternship(String charactersSet) {
		permute(charactersSet,0,charactersSet.length()-1);
		String[] arr = new String[pal.size()]; 
		arr = pal.toArray(arr);
		pal.clear();
		return arr;
	}

	public static void main(String[] args) {
		String str = "ABCBA"; 
		System.out.println(Arrays.toString(generatePalindromesChocoInternship(str))); 
	}

}
