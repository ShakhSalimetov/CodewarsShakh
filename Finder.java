import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class Finder {
	public static void visit(){

	}
	//#1
	//	static boolean pathFinder(String maze) {
	//		String[] spl=maze.split("\n");
	//		char[][] c=new char[spl[0].length()][];
	//		Queue<Integer[]> q=new LinkedList<Integer[]>();
	//		
	//		for(int i=0;i<spl.length;i++)
	//			c[i]=spl[i].toCharArray();
	//		
	//		q.add(new Integer[]{0,0});
	//		c[0][0]='W';
	//		while(!q.isEmpty()){
	//			int i=q.peek()[0],k=q.peek()[1];
	//			if(i+1!=c.length && c[i+1][k]!='W'){
	//				q.add(new Integer[]{i+1,k});
	//				c[i+1][k]='W';
	//			}
	//			if(k+1!=c[i].length && c[i][k+1]!='W'){
	//				q.add(new Integer[]{i,k+1});
	//				c[i][k+1]='W';
	//			}
	//			if(i-1!=-1 && c[i-1][k]!='W'){
	//				q.add(new Integer[]{i-1,k});
	//				c[i-1][k]='W';
	//			}
	//			if(k-1!=-1 && c[i][k-1]!='W'){
	//				q.add(new Integer[]{i,k-1});
	//				c[i][k-1]='W';
	//			}
	//			q.remove();
	//		}
	//		if(c[spl[0].length()-1][spl[0].length()-1]=='W')
	//			return true;
	//		else 
	//			return false;
	//	}
	//#2
	//	public static int pathFinder(String maze) {
	//		String[] spl=maze.split("\n");
	//		char[][] c=new char[spl[0].length()][];
	//		int[][] shortest=new int[spl[0].length()][spl[0].length()];
	//		Queue<Integer[]> q=new LinkedList<Integer[]>();
	//		
	//		for(int i=0;i<spl.length;i++)
	//			c[i]=spl[i].toCharArray();
	//		
	//		q.add(new Integer[]{0,0});
	//		c[0][0]='W';
	//		while(!q.isEmpty()){
	//			int i=q.peek()[0],k=q.peek()[1];
	//			if(i+1!=c.length && c[i+1][k]!='W'){
	//				q.add(new Integer[]{i+1,k});
	//				c[i+1][k]='W';
	//				shortest[i+1][k]+=shortest[i][k]+1;
	//			}
	//			if(k+1!=c[i].length && c[i][k+1]!='W'){
	//				q.add(new Integer[]{i,k+1});
	//				c[i][k+1]='W';
	//				shortest[i][k+1]+=shortest[i][k]+1;
	//			}
	//			if(i-1!=-1 && c[i-1][k]!='W'){
	//				q.add(new Integer[]{i-1,k});
	//				c[i-1][k]='W';
	//				shortest[i-1][k]+=shortest[i][k]+1;
	//			}
	//			if(k-1!=-1 && c[i][k-1]!='W'){
	//				q.add(new Integer[]{i,k-1});
	//				c[i][k-1]='W';
	//				shortest[i][k-1]+=shortest[i][k]+1;
	//			}
	//			q.remove();
	//		}
	//		if(shortest[spl[0].length()-1][spl[0].length()-1]==0)
	//			return -1;
	//		else
	//			return shortest[spl[0].length()-1][spl[0].length()-1];
	//	}
	static int pathFinder(String maze) {
		String[] spl=maze.split("\n");
		int[][] shrt=new int[spl.length][spl.length];
		int[][] c=new int[spl.length][spl.length];
		Comparator<Integer[]> comparator = new arComp();
		PriorityQueue<Integer[]> pq=new PriorityQueue<Integer[]>(comparator);
		for(int i=0;i<spl.length;i++){
			for(int j=0;j<spl.length;j++)
				c[i][j]=spl[i].charAt(j)-48;
			Arrays.fill(shrt[i], 999);
		}
		shrt[0][0]=0;
		pq.add(new Integer[]{0,0});
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				System.out.print(c[i][j]+" ");
			}
			System.out.println();
		}
		while(!pq.isEmpty()){
			int i=pq.peek()[0],k=pq.peek()[1];
			pq.remove();
			if(i+1!=c.length && shrt[i+1][k]>shrt[i][k]+Math.abs(c[i][k]-c[i+1][k])){
				pq.add(new Integer[]{i+1,k});
				shrt[i+1][k]=shrt[i][k]+Math.abs(c[i][k]-c[i+1][k]);
			}
			if(k+1!=c[i].length && shrt[i][k+1]>shrt[i][k]+Math.abs(c[i][k]-c[i][k+1])){
				pq.add(new Integer[]{i,k+1});
				shrt[i][k+1]=shrt[i][k]+Math.abs(c[i][k]-c[i][k+1]);
			}
			if(i!=0 && shrt[i-1][k]>shrt[i][k]+Math.abs(c[i][k]-c[i-1][k])){
				pq.add(new Integer[]{i-1,k});
				shrt[i-1][k]=shrt[i][k]+Math.abs(c[i][k]-c[i-1][k]);
			}
			if(k!=0 && shrt[i][k-1]>shrt[i][k]+Math.abs(c[i][k]-c[i][k-1])){
				pq.add(new Integer[]{i,k-1});
				shrt[i][k-1]=shrt[i][k]+Math.abs(c[i][k]-c[i][k-1]);
			}
			if(i==0 && k==5)
				System.out.println(shrt[i][k]);
			
		}
		System.out.println();
		for(int i=0;i<c.length;i++){
			for(int j=0;j<c.length;j++){
				System.out.print(shrt[i][j]+" ");
			}
			System.out.println();
		}
				return shrt[shrt.length-1][shrt.length-1];
	}

	public static void main(String args[]){

		String a = "747062171\n"+
				"904866986\n"+
				"340268947\n"+
				"974542098\n"+
				"574036106\n"+
				"567149757\n"+
				"726658263\n"+
				"848862682\n"+
				"755104617\n",

				b = "010\n"+
						"010\n"+
						"010",

						c = "010\n"+
								"101\n"+
								"010",

								d = "0707\n"+
										"7070\n"+
										"0707\n"+
										"7070",

										e = "700000\n"+
												"077770\n"+
												"077770\n"+
												"077770\n"+
												"077770\n"+
												"000007",

												f = "777000\n"+
														"007000\n"+
														"007000\n"+
														"007000\n"+
														"007000\n"+
														"007777",

														g = "000000\n"+
																"000000\n"+
																"000000\n"+
																"000010\n"+
																"000109\n"+
																"001010";

		//		System.out.println(Arrays.toString(
		a.split("\n");
				System.out.println(pathFinder(a));



	}
}
class arComp implements Comparator<Integer[]>{
	public int compare(Integer[] x, Integer[] y){
		int a=x[0]*x[1],b=y[0]*y[1];
		if (a<b)
			return -1;
		if (a>b)
			return 1;
		return 0;
	}
}