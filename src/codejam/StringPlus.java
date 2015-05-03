package codejam;

import java.util.Arrays;

public class StringPlus {
	String s;
	public StringPlus(String s){
		this.s=s;
	}
	
	public boolean isPermutationSort(String s2)
	{
		if(s.length()!=s2.length()){
			return false;
		}
		char[] arr1=this.s.toCharArray();
		char [] arr2=s2.toCharArray();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		if(Arrays.equals(arr1, arr2)){
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean isPermutation(String s2){
		/*check if the 2 strings contain the same characters*/
		/*Sort both strings and do string compare --nlogn for sort + n for compare*/
		/*Maintain boolean array for each member of the original string, if all elements are true, then it is permutation - O(n^2): n in each iteration, n iterations*/
		if(s.length()!=s2.length()){
			return false;
		}
		boolean[] charsFoundS2=new boolean[s.length()];
		int ind;
		for(int i=0;i<this.s.length();++i){
			char currChar=this.s.charAt(i);
			ind=s2.indexOf(currChar);
			while(true){
				if(ind==-1){
					return false;
				}
				else{
					if(!charsFoundS2[ind]){
						charsFoundS2[ind]=true;
						break;
					}
					else{
						if(ind<s2.length()-1){
							ind=s2.indexOf(currChar, ind+1);	
						}
						else{
							return false;
						}
					}
				}		
			}
			//Ind val must be false (havent seen it before) --> mark true, continue.
			//If true --> then find next occurrence of this character --> if we get -1, return false
		}
		return true;
	}
	
	public static void main(String[] args){
		StringPlus sp=new StringPlus("MADD");
		System.out.println(sp.isPermutation("DDMCU"));
		System.out.println(sp.isPermutationSort("DDMA"));
	}
}
