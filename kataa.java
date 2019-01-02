public class kataa {
	public static char color(char a,char b){
		int q=a+b;
		if(q==164 || q==137)
			return 'R';
		else if(q==142 || q==148)
			return 'G';
		else
			return 'B';
	}
	public static char nc(char a, char b,char c){
		if(a==b && a==c)
			return a;
		else if(a!=b && b!=c && c!=a)
			return b;
		else if(a==c)
			return color(a,b);
		else if(a==b)
			return c;
		else 
			return a;
	}
	public static char triangle(final String row) {
		char ar[] =row.toCharArray();
		while(ar.length>2){
			char[] result=new char[ar.length-2];
			for(int i=0;i<ar.length-2;i++)
				result[i]=nc(ar[i],ar[i+1],ar[i+2]);
			ar=result;
		}
		if(ar.length==2)
			return color(ar[0],ar[1]);
		else
			return ar[0];
	}

	
	public static void main(String[] args){
		System.out.println(triangle("RBRGBRBGGRRRBGBBBGG"));
	}

}