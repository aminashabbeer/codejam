package codejam;

public class Stack {
	Node top;
	
	public Stack(){
		this.top=null;
	}
	public Stack(int[] eles){
		this.top=null;
		for(int e:eles){
			this.push(e);
		}
	}
	public boolean isEmpty(){
		if(this.top==null){
			return true;
		}
		else{
			return false;
		}
	}
	public void push(int val){
		Node newnode=new Node(val);
		newnode.next=this.top;
		this.top=newnode;
	}
	public int pop(){
		if(this.isEmpty()){
			throw new RuntimeException("Stack Underflow");
		}else{
			int val=top.data;
			this.top=this.top.next;
			return val;
		}
	}
	public int peek(){
		if(this.isEmpty()){
			throw new RuntimeException("Stack underflow");
		}
		else{
			return this.top.data;	
		}
	}
	
	private class Node{
		int data;
		Node next;
		public Node(int val){
			this.data=val;
			this.next=null;
		}
		public Node(){
			this.next=null;
		}
	}

}
