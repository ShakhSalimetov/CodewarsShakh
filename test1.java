import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Pattern;

public class test1 {
	public static String lcs(String x, String y) {
		String [][] sub=new String[x.length()+1][y.length()+1];
		for(int i=0;i<x.length()+1;i++){
			for(int j=0;j<y.length()+1;j++){
				if(i==0 || j==0) sub[i][j]="";
				else if(x.charAt(i-1)==y.charAt(j-1)) sub[i][j]=sub[i-1][j-1]+x.charAt(i-1);
				else if(sub[i-1][j].length()>=sub[i][j-1].length()) sub[i][j]=sub[i-1][j]; 
				else sub[i][j]=sub[i][j-1];
				//    			else sub[i][j]=Math.max(sub[i-1][j], sub[i][j-1]);
			}
		}
		return sub[x.length()][y.length()];
	}

	public static long nextBiggerNumber(long n)
	{ 

		String ar = Long.toString(n);
		char[] c=ar.toCharArray();
		int i;
		for(i=c.length-1;i>0;i--) if(c[i]>c[i-1]) break;
		if(i==0) return -1;
		else{
			int min=i;
			for(int j=i+1;j<c.length;j++)
				if(c[j]>c[i-1] && c[j]<c[min]) min=j;
			char tmp=c[i-1];
			c[i-1]=c[min];
			c[min]=tmp;
			Arrays.sort(c,i,c.length);
			ar="";
			for (Character chars : c)
				ar+=chars;

			return Long.parseLong(ar);
		}

		//      int [] num=new int [10];
		//      long tmp=n;
		//      String k="";
		//      while(n>0){
		//    	  num[(int) (n%10)]+=1;
		//    	  n/=10;
		//      }
		//      for(int i=9;i>=0;i--){
		//    	  for(int j=0;j<num[i];j++){
		//    		  k+=Integer.toString(i);
		//    	  }
		//      }
		//      return Long.parseLong(k);
	}


	public static String decode(String morseCode) {

		String letter="",word="";
		morseCode=morseCode.trim();
		for(int i=0;i<morseCode.length();i++){
			char cur=morseCode.charAt(i);
			if(cur=='.'|| cur=='-')
				letter+=cur;
			else {
				//				word+=MorseCode.get(letter);
				if(morseCode.charAt(i+1)==' '){
					word+=" ";
					i+=2;
				}
				letter="";
			}
		}
		return word;
	}

	public static String decodeBits(String bits) {
		bits=bits.replaceAll("(^0+)|(0+$)", "");
		String[] ar = bits.split("(?<=([0-9]))(?!\\1)");
		int rate=999;
		for(int i=0;i<ar.length;i++)
			if(ar[i].length()!=0 && ar[i].length()<rate)
				rate=ar[i].length();
		String dot = new String(new char[rate]).replace("\0", "1");
		String dash = new String(new char[rate*3]).replace("\0", "1");
		String ch_gap = new String(new char[rate*3]).replace("\0", "0");
		String w_gap = new String(new char[rate*7]).replace("\0", "0");
		String word="",perevod="";
		  return bits
			        .replaceAll("1{"+ (3 * rate) +"}", "-")
			        .replaceAll("1{"+ (1 * rate) +"}", ".")
			        .replaceAll("0{"+ (7 * rate) +"}", "   ")
			        .replaceAll("0{"+ (3 * rate) +"}", " ")
			        .replaceAll("0{"+ (1 * rate) +"}", "");
			  }

//		for(int i=0;i<ar.length;i++){
//			if(ar[i].equals(ch_gap)){
//				word+=MorseCode.get(perevod);
//				perevod="";
//			}
//			else if(ar[i].equals(w_gap)){
//				word+=Morse.get(perevod)+" ";
//				perevod ="";
//			}
//			else if(ar[i].equals(dot))
//				perevod+=".";
//			else if(ar[i].equals(dash))
//				perevod+="-";
//		}
	

	public static String mix(String s1, String s2) {
		
	      return "";
	    }

	public static void main(String[] args) {
		//		String str = "Hello  World !";
		//        System.out.println(str.replaceAll("(\\w)(\\w*)", "$2$1ay"));
		//		str+=" ";
		////		if(str!=null && !str.isEmpty()){
		//			char c[]=str.toCharArray();
		//			char q=c[0];
		//			str="";
		//			for(int i=1;i<c.length;i++){
		//				if (!Character.isLetter(c[i-1]) && Character.isLetter(c[i])){
		//					q=c[i];
		//				}
		//				else if (Character.isLetter(c[i-1]) && !Character.isLetter(c[i])){
		//					str+=q+"ay"+c[i];
		//				}
		//				else 
		//					str+=c[i];
		//			}
		////		}
		//		System.out.println(str.substring(0, str.length()-1));

		//		int x=100;
		//		System.out.println(Integer.bitCount(x));

		//		double[] s = {11.0,4.0,5.0};
		//		int n = 0;
		//		double[] tri=new double[n];
		//		if(s!=null && s.length!=0){
		//			if(n>1) tri[0]=s[0];
		//			if(n>1) tri[1]=s[1];
		//			if(n>2) tri[2]=s[2];
		//			for(int i=3;i<n;i++)
		//				tri[i]=tri[i-3]+tri[i-2]+tri[i-1];
		//			
		//		}
		//		for(int i=0;i<n;i++){
		//			System.out.println(tri[i]);
		//		}

		//		int a=1,b=0,c=1;
		//		System.out.println(((a+b)>c && (a+c)>b && (b+c)>a)?true:false);

		//		int n=91199;
		//		int tmp=0;
		//		String k="";
		//		while(n>0){
		//			tmp=n%10;
		//			tmp=tmp*tmp;
		//			k=Integer.toString(tmp)+k;
		//			n/=10;
		//		}
		//		int result=Integer.parseInt(k);
		//		System.out.println(result);

		//		int n=1;
		//		String[] k = {"S","Leo","Pen","Raj","How"};
		//		int max=0,i;
		//			for(i=0;max<n;i++) 
		//				max+=Math.pow(2, i)*5;
		//			
		//		for(int q=4;q>=0;q--){
		//			max-=Math.pow(2,i-1);
		//			if(max<n)
		//				System.out.println(k[q] + " " + max);
		//		}

		//		function listSquared(start, end) {
		//			var output = [];
		//			for (var i = start; i <= end; i++) {
		//				var sum = 0;
		//				for (var j = 1; j <= i; j++) {
		//					if (i % j === 0) {
		//						sum += j * j;
		//					}
		//				} if (Math.sqrt(sum) % 1 === 0) {
		//					output.push([i, sum]);
		//				}
		//			} return output;
		//		}
		//		listSquared(1, 250)
		//		listSquared(42,250)

		//		int[] integers={-45,-1,3};
		//		int proc=(Math.abs(integers[0])%2+Math.abs(integers[1])%2+Math.abs(integers[2])%2)<2 ? 1:0;
		////		for(int i=0;i<integers.length;i++)
		////			if((integers[i]&1)==proc)
		////				return;
		//		System.out.println(Math.abs(integers[0])%2+Math.abs(integers[1])%2+Math.abs(integers[2])%2);

		//		String[] dirs = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH" };
		//		ArrayList<String> places = new ArrayList<String>();
		////		function dirReduc(dirs){
		//		for(int i=0;i<dirs.length;){
		//			if(places.isEmpty()){
		//			places.add(dirs[i]);
		//			}
		//			else{
		//				if(places.get(places.size()-1) == "NORTH" && dirs[i]	){
		//					
		//				}
		//			}
		//		}
		//			  for(int i=0;i<dirs.length;i++){
		//			    if( dirs[i] == "NORTH" && dirs[i+1] == "SOUTH"){
		//			      dirs=dirs.clone();
		//			      i-=2;
		//			      continue;
		//			    }
		//			    if( dirs[i] === "EAST" && dirs[i+1] === "WEST"){
		//			      dirs.splice(i, 2);
		//			      i-=2;
		//			      continue;
		//			    }
		//			    if( dirs[i] === "SOUTH" && dirs[i+1] === "NORTH"){
		//			      dirs.splice(i, 2);
		//			      i-=2;
		//			      continue;
		//			    }
		//			    if( dirs[i] === "WEST" && dirs[i+1] === "EAST"){
		//			      dirs.splice(i, 2);
		//			      i-=2;
		//			      continue;
		//			    }
		//			  }

		//			  return dirs;
		//		System.out.println(lcs("132535365", "123456789"));
		//		System.out.println(nextBiggerNumber(12));
//		System.out.println(decodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011"));
//		String s="1001100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
//		String b="011011001";
//		System.out.println(b.replaceAll("(^0+)|(0+$)", ""));
//		System.out.println(b.replaceAll("^0+", ""));
//		System.out.println(b.replaceAll("0+$", ""));
//		System.out.println(b.replaceFirst("^0+(?!$)", ""));
//		//		System.out.println(Arrays.toString(s.split("(?<=\\G....)")));
//		String[] ar=s.split("(00000000000000)");
//		String[] array = b.split("(?<=([0-9]))(?!\\1)");
//		System.out.println(Arrays.toString(array));
//		System.out.println(Arrays.toString(ar));
//		int min=999;
//		for(int i=0;i<ar.length;i++){
//			if(ar[i].length()!=0 && ar[i].length()<min){
//				min=ar[i].length();
//			}
//		}
//		System.out.println(min);
//		ar=b.split("00");
//		System.out.println(Arrays.toString(ar));
//		for(String word : ar) {
//			 if (ar.) {
//			        iterator.next();
//			    }
//System.out.println(ar[1].substring(beginIndex, endIndex));	      
//}

//		final String word_gap = String.join("kek", "ss", "s","1");
		//		decodeBits(s);
		String input="500";
		        if (input.matches("[^0-9]*[12]?[0-9]{1,2}[^0-9]*")) {
		           System.out.println("true");
		        }
		        
		        System.out.println(EXAMPLE_TEST.matches("\\w.*"));
		        String[] splitString = (EXAMPLE_TEST.split("\\s+"));
		        System.out.println(splitString.length);// should be 14
		        for (String string : splitString) {
		            System.out.println(string);
		        }
		        // replace all whitespace with tabs
		        System.out.println(EXAMPLE_TEST.replaceAll("\\s+", "\t"));
		        String s = "humbapumpa jim";
		        if(s.matches(".*(jim|joe).*")){
		        	System.out.println("true1");
		        }
		        s = "humbapumpa jom";
		        if(s.matches(".*(jim|joe).*")){
		        	System.out.println("true2");
		        }
		        s = "humbaPumpa joe";
		        if(s.matches(".*(jim|joe).*")){
		        	System.out.println("true3");
		        }
		        s = "1[233211";
		        if(s.matches("\\d([,\\(])?\\d\\d([,\\s])?\\d\\d\\d\\d")){
		        	System.out.println("true4");
		        }
		    
	}
	private static final Pattern[] inputRegexes = new Pattern[4];
	public static final String EXAMPLE_TEST = "This is my small example "
	            + "string which I'm going to " + "use for pattern matching.";
	String regex = "^(?=.*?\\p{Lu})(?=.*?\\p{Ll})(?=.*?\\d)" +
		    "(?=.*?[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?]).*$";
	static {
	    inputRegexes[0] = Pattern.compile(".*[A-Z].*");
	    inputRegexes[1] = Pattern.compile(".*[a-z].*");
	    inputRegexes[2] = Pattern.compile(".*\\d.*");
	    inputRegexes[3] = Pattern.compile(".*[`~!@#$%^&*()\\-_=+\\\\|\\[{\\]};:'\",<.>/?].*");
	}
	
}


