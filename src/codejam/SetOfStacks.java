package codejam;

import java.util.ArrayList;

public class SetOfStacks {
	ArrayList<Stack> stacks;
	final int MAXLEN=3;
	int numElems=0;
	
	public void push(int val){
		int stackInd=numElems/this.MAXLEN;
		System.out.println("ind#"+stackInd+" numelems"+numElems);
		if(stackInd>stacks.size()-1){
			stacks.add(new Stack());
		}
		stacks.get(stackInd).push(val);
		numElems++;
	}
	public int pop(){
		if(!this.stacks.isEmpty()){
			Stack currStack=this.stacks.get(this.stacks.size()-1);
			System.out.println("stack#"+(this.stacks.size()-1));
			if(currStack.isEmpty()){
				System.out.println("stack is empty");
				this.stacks.remove(this.stacks.size()-1);
				return this.pop();
			}
			else{
				numElems--;
				return currStack.pop();
			}
		}
		else{
			throw new RuntimeException("Stack Underflow");
		}
	}
	public SetOfStacks(){
		stacks=new ArrayList<Stack>();
	}
	
	public static void main(String[] args){
		Stack s=new Stack();
		s.push(2);
		s.push(5);
		s.push(8);
		System.out.println(s.pop());
		
		SetOfStacks ss=new SetOfStacks();
		ss.push(2);
		ss.push(5);
		ss.push(8);
		System.out.println(ss.pop());
		ss.push(9);
		ss.push(10);
		ss.push(11);
		System.out.println(ss.pop());
	}
}
