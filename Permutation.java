import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Permutation { 
	static List<String> ar =new ArrayList<String>();
	static Map<String, Integer> hashq = new HashMap<String, Integer>();
	public static void main(String[] args) 
	{ 	
		String str = ""; 
		int n = str.length(); 
		Permutation permutation = new Permutation(); 
		permutation.permute(str, 0, n-1);
		//		System.out.println(Arrays.toString(ar.toArray()));
		//		for (Map.Entry<String, Integer> entry: hashq.entrySet())
		//			System.out.println(entry.getKey() + " = " + entry.getValue());
		System.out.println(ar.size()+"   "+hashq.size());
		System.out.println("Please enter a five letter word"); 
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		for (int i = 0; i < input.length(); i++) {             // pos. of 1st letter
			for (int j = 0; j < input.length(); j++) {         // pos. of 2nd letter
				for (int k = 0; k < input.length(); k++) {     // pos. of 3rd letter
					for(int o=0;o<input.length();o++){
					hashq.put(input.charAt(i)+""+input.charAt(j)+""+input.charAt(k)+input.charAt(o), i+j+o+k);
					}
				}
			}
		}
		int i=0;
		for (Map.Entry<String, Integer> entry: hashq.entrySet()){
			System.out.print(++i+"."+entry.getKey()+"-"+entry.getValue()+" ");

		}
		System.out.println();
		i=0;
		Map<String, Integer> treeMap = new TreeMap<String, Integer>(hashq);
		for (Map.Entry<String, Integer> entry: treeMap.entrySet()){
			System.out.print(++i+"."+entry.getKey()+"-"+entry.getValue()+" ");

		}
	} 
	private void permute(String str, int l, int r) 
	{ 
		if (l == r){
			ar.add(str);
			if(hashq.containsKey(str))
				hashq.put(str,hashq.get(str)+1);
			else
				hashq.put(str, 1);
		}
		else
		{ 
			for (int i = l; i <= r; i++) 
			{ 
				str = swap(str,l,i); 
				permute(str, l+1, r); 
				str = swap(str,l,i); 
			} 
		} 
	} 
	public String swap(String a, int i, int j) 
	{ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	} 

} 

