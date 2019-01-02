import java.util.*;
public class RailFenceCipher {

	static String encode(String s, int n) {
		String[] rails= new String[n];
		Arrays.fill(rails, "");
		int i=0,tmp=1;
		for(Character c: s.toCharArray()){
			rails[i]+=c;
			if(i==0)
				tmp=1;
			else if(i==n-1)
				tmp=-1;
			i+=tmp;
		}
		return String.join("",rails);
	}

	static String decode(String s, int n) {
		Queue<Character>[] ryad = new Queue[n];
		int[] rails=new int[n];
		int row=(n-1)*2,q=0,tmp=0;
		String re="";

		for(int i=0;i<n;i++){
			ryad[i] = new LinkedList<>();
			if(i==0 | i==n-1)
				rails[i]=s.length()/row;
			else{
				System.out.println("wtf");
				rails[i]=s.length()/((n-1)*2)*2;
				if(s.length()%row>n && s.length()%row%n>=n-i-1)
					rails[i]++;
			}
			if(s.length()%row>i)
				rails[i]++;
		}
		System.out.println(Arrays.toString(rails));
		for(int i=0;i<n;i++){
			for(Character c:s.substring(tmp,tmp+rails[i]).toCharArray())
				ryad[i].add(c);
			tmp+=rails[i];
		}

		for(int i=0;i<s.length();i++){
			re+=ryad[q].poll();
			if(q==0)
				tmp=1;
			else if(q==n-1)
				tmp=-1;
			q+=tmp;
		}
		return re;
	}
	public static void main(String [] args){
		encode("Helloworld!waxaWAXABBIST",6);
		System.out.println(decode("holaelwrdwxlo!a",3));
//hlerdlowlwaaox
	}
}