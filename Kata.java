import java.util.HashMap;
import java.util.Map;

public class Kata {
	static Map<String, Character> hashmap = new HashMap<String, Character>();
	public static char gop(String a){
		while(a.length()>1){
			String s="";
			for(int i=0;i<a.length()-1;i++)
				s+=color(a.charAt(i),a.charAt(i+1));
			a=s;
		}
		return a.charAt(0);
	}
	public static char color(char a,char b){
		int q=a+b;
		if(q==164 || q==137)
			return 'R';
		else if(q==142 || q==148)
			return 'G';
		else
			return 'B';
	}
	public static void check(String a){
		if(a.length()!=5){
			check(a+"R");
			check(a+"G");
			check(a+"B");
		}
		else
			hashmap.put(a, gop(a));
	}

	public static char triangle(final String row) {
		if(hashmap.isEmpty())
		check("");
		char[] s=row.toCharArray();
	
		while(s.length>5){
			char[] b=new char[s.length-4];
			for(int i=0;i<s.length-4;i++){
				String q="";
				for(int j=0;j<5;j++)
					q+=s[i+j];
				b[i]=hashmap.get(q); 
			}
			s=b;
		}
		return gop(new String(s));
	}
	public static void main(String[] args) {
		System.out.println(triangle("RBRGBRBGGRRRBGBBBGG"));
		//		hashmap.put("BR", 'G');
		//		hashmap.put("GG", 'G');
	}

}