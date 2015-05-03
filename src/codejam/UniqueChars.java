package codejam;

import java.util.HashSet;

public class UniqueChars {
	String s;

public UniqueChars(String s){
	this.s=s;
}

	public boolean containsUnique(){
		/*Find if string contains unique chars*/
		HashSet<Character> charsfound=new HashSet<Character>(26);
		for(int i=0;i<this.s.length();++i){
			Character currChar=new Character(this.s.charAt(i));
			if(!charsfound.contains(currChar)){
				charsfound.add(currChar);
			}
			else{
				return false;
			}
		}
		return true;
	}
	
	public boolean containsUniqueNoDS(){
		/*Find if string contains unique chars with no extra data structures*/
		for(int i=0;i<this.s.length();++i){
			char currChar=this.s.charAt(i);
			for(int j=i+1;j<this.s.length();++j){
				if(currChar==this.s.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String [] args){
		UniqueChars u=new UniqueChars("hHelllo");
		System.out.println(u.containsUnique());
		System.out.println(u.containsUniqueNoDS());
	}
}
