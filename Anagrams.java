import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Anagrams {
	public static BigInteger listPosition(String word) {
		String[] fact={"1","2","6","24","120","720","5040","40320","362880","3628800",//10
				"39916800","479001600","6227020800","87178291200","1307674368000","20922789888000","355687428096000","6402373705728000",//18
				"121645100408832000","2432902008176640000","51090942171709440000","1124000727777607680000","25852016738884976640000",//23
				"620448401733239439360000","15511210043330985984000000","403291461126605635584000000","10888869450418352160768000000",//27
				"304888344611713860501504000000","8841761993739701954543616000000","265252859812191058636308480000000"};
		List<Character> wor = new ArrayList();
		for(Character c : word.toCharArray())
			wor.add(c);
		Collections.sort(wor);
		BigInteger myperm=new BigInteger("0");
		for(int i=0;i<word.length();i++){
			char q=word.charAt(i);
			int povt=0,indexq=wor.indexOf(q);
			for(int k=indexq;k<wor.size();k++){
				if(q==wor.get(k))
					povt++;
				else
					break;
			}
			if(indexq!=0)
				myperm=myperm.add(new BigInteger(fact[wor.size()-2]).multiply(new BigInteger(Integer.toString(indexq))));
			if(povt!=0)
				myperm=myperm.divide(new BigInteger(Integer.toString(povt)));
			wor.remove(indexq);
		}
		return myperm.add(new BigInteger("1"));
	}

	public static void main(String[]args){

		System.out.println(listPosition("ABAAA").toString());
	}
}