import java.util.Arrays;

public class wtf {
	public static String repl(String s){
		return (s.length()>30)? s.replaceAll("\\b(?:the|of|in|from|by|with|and|or|for|to|at|a|\\?.*|\\#.*)\\b", "").replaceAll(".(?<!\\b[a-zA-Z])", ""):s.replaceAll("-", " ");
	}
	public static String generate_bc(String url, String separator) {
		url=url.replaceAll("([\\#,\\?].*\\b)", "/").replaceAll("http(s|)://", "");
		String res="<a href=\"/\">HOME</a>";
		String[] ar=url.split("/+");
		if(ar[ar.length-1].matches("^index[,.].*"))
			ar=Arrays.copyOfRange(ar, 0, ar.length-1);
		if(ar.length==1)
			return "<span class=\"active\">HOME</span>";
		for(int i=ar[0].matches("^http.*")? 2:1;i<ar.length-1;i++){
			res+=separator+"<a href=\"/";
			for(int j=1;j<i;j++){
				res+=ar[j];
			}
			res+=ar[i]+"/\">"+repl(ar[i]).toUpperCase()+"</a>";
		}
		return res+separator+"<span class=\"active\">"+repl(ar[ar.length-1].replaceAll("\\b(.html$|.htm$|.php$|.asp$)","")).toUpperCase()+"</span>";
	}

	public static void main(String[] args) {
		System.out.println(generate_bc("www.linkedin.it/games/uber-bladder-from-uber/#bottom/", " : "));

		String s="https://www.linkedin.com/in/giacomosorbi";
		System.out.println(s.replaceAll("([\\#,\\?].*[$/,])", "/"));
		//		 (ar[ar.length-1].matches("^index[,.].*")? ar.length-2:ar.length-1
		System.out.println(s.replaceAll("(\\?.*|\\#.*)",""));
	}
}
