import java.util.*;

public class test2 {

	//	public static String repl(String s){
	//		return s.replaceAll("[^a-z]", "");
	//	}
	//	public static String mix(String s1, String s2) {
	//		s1=repl(s1);
	//		s2=repl(s2);
	//		char ch;
	//		String result="";
	//		int len = Math.max(s1.length(),s2.length());
	//		Map<Character,List<Integer>> numChars = new HashMap<Character,List<Integer>>(Math.min(len,26));
	//		ValueComparator vc = new ValueComparator(numChars);
	//		TreeMap<Character,List<Integer>> treemap = new TreeMap<Character,List<Integer>>(vc);
	//		for (int i = 0; i < s1.length(); ++i){
	//			ch = s1.charAt(i);
	//			if (!numChars.containsKey(ch))
	//				numChars.put(ch,Arrays.asList(130-ch+'a',0)); //ch*s1.length());
	//			else
	//				numChars.get(ch).set(0, numChars.get(ch).get(0)+100); // numChars.put(ch, numChars.get(ch).set);
	//		}
	//		for (int i = 0; i < s2.length(); ++i){
	//			ch = s2.charAt(i);
	//			if (!numChars.containsKey(ch))
	//				numChars.put(ch,Arrays.asList(0, 130-ch+'a'));
	//			else
	//				numChars.get(ch).set(1, numChars.get(ch).get(1)==0? 130-ch+'a':numChars.get(ch).get(1)+100);
	//		}
	//		for(Iterator<Map.Entry<Character, List<Integer>>> it = numChars.entrySet().iterator(); it.hasNext(); ) {
	//		    Map.Entry<Character, List<Integer>> entry = it.next();
	//		    if(Math.max(entry.getValue().get(0),entry.getValue().get(1)) < 190)
	//				it.remove();
	//			else if(entry.getValue().get(0)<entry.getValue().get(1))
	//				entry.getValue().set(1,entry.getValue().get(1)+30);
	//			else if(entry.getValue().get(0)>entry.getValue().get(1))
	//				entry.getValue().set(0,entry.getValue().get(0)+60);
	//		}
	//		treemap.putAll(numChars);
	//
	//		for (Map.Entry<Character, List<Integer>> entry : treemap.entrySet()){
	//			if(!result.equals(""))
	//				result+='/';
	//			if(entry.getValue().get(0)>entry.getValue().get(1)){
	//				result+="1:"+new String(new char[entry.getValue().get(0)/100]).replace('\0',entry.getKey());
	//			}
	//			else if(entry.getValue().get(0)<entry.getValue().get(1)){
	//				result+="2:"+new String(new char[entry.getValue().get(1)/100]).replace('\0',entry.getKey());
	//			}
	//			else
	//				result+="=:"+new String(new char[entry.getValue().get(1)/100]).replace('\0',entry.getKey());
	//		}
	//
	//		return result;
	//	}
	public static void main(String[] args) {
		//		System.out.println(mix(kekek,ww));
		int year=10;
		System.out.println(year%10>0? year/100+1:year/100);
	}

}
class ValueComparator implements Comparator<Character> {
	Map<Character, List<Integer>> base;

	public ValueComparator(Map<Character, List<Integer>> base) {
		this.base = base;
	}
	public int compare(Character a, Character b) {
		if (Math.max(base.get(a).get(0),base.get(a).get(1)) >= Math.max(base.get(b).get(0),base.get(b).get(1))) 
			return -1;
		else 
			return 1;

	}
}
//
//import java.util.*;
//
//public class test2 {
//
//	public static String repl(String s){
//		return s.replaceAll("[^a-z]", "");
//	}
//	public static String mix(String s1, String s2) {
//		s1=repl(s1);
//		s2=repl(s2);
//		char ch;
//		String result="";
//		int len = Math.max(s1.length(),s2.length());
//		String[] let1 = new String[26];
//		String[] let2 = new String[26];
//		Arrays.fill(let1, "");
//		Arrays.fill(let2, "");
//		for(int i=0;i<s1.length();i++){
////			if(let[s1.charAt(i)][0]=="")
////				let[s1.charAt(i)][0]+="1:";
//			let[s1.charAt(i)-'a'][0]+=s1.charAt(i);
//		}
//		for(int i=0;i<s2.length();i++){
////			if(let[s2.charAt(i)][1]=="")
////				let[s2.charAt(i)][1]+="1:";
//			let[s2.charAt(i)-'a'][1]+=s2.charAt(i);
//		}
//		System.out.println(Arrays.deepToString(let));
//		
//		return result;
//	}
//	public static void main(String[] args) {
//		String kekek="",ww="sqwwrtaz";
//		System.out.println(mix(kekek,ww));
////		String [] ss={"1:aaa","1:hhh","1:aa","2:yy","=:ee"};
////		Arrays.sort(ss);
////		System.out.println(Arrays.toString(ss));
////		System.out.println("aab".compareTo("aaa"));
//	}
//
//}
//
