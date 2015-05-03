package codejam;

public class StackProb {
	Stack mainStack;
	Stack mins;
	
	public StackProb(){
		Stack mainStack=new Stack();
		Stack mins=new Stack();	
	}	
	public void push(int e){
		mainStack.push(e);
		if(e<=this.min()){
			mins.push(e);
		}
	}
	
	public int pop(){
		int val=this.mainStack.pop();
		if(val==this.min()){
			mins.pop();
		}
		return val;
	}
	
	public int min(){
		if(mins.isEmpty()){
			return Integer.MAX_VALUE;//error value
		}
		else{
			return this.mins.peek();
		}
	}
	public static void main(String[] args){
		int[] eles={5,4,6,8,9,1,3,7,2,4};
		StackProb ps=new StackProb();
		for(int e:eles){
			ps.push(e);
		}
	}
}
