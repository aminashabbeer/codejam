package codejam;
import java.util.ArrayList;

public class parenthesis {
	public ArrayList<Integer> findClosePos(int start,String str){
		int numOpen=0;
		ArrayList<Integer> ends=new ArrayList<Integer>();
		while(start<str.length()){
			start++;
			if(str.charAt(start)=='('){
				numOpen++;
			}
			else{
				numOpen
			}
		}
		return ends;
	}
	public int findOpenPos(int pos,String str){
		int start=pos;
		while(str.charAt(start)!='('){
			start++;
		}
		return start;
	}
	
	public String insertPars(String str, int start, int end){
		
	}
	public ArrayList<String> getAllPerms(int n){
		ArrayList<String> perms=new ArrayList<String>();
		if(n<0){
			throw new RuntimeException("n is negative");
		}
		else if(n==0){
			
			return perms;
		}
		else{
			ArrayList<String> prevperms=getAllPerms(n-1);
			for(String perm:prevperms){
				int currPos=0;
				while(currPos<perm.length()){
					int start=findOpenPos(currPos,perm);
					ArrayList<Integer> ends=findClosePos(start);
					for(int e:ends){
						String s=insertPars(perm,start,e);
					}
				}
			}
			return perms;
		}
	}

}
