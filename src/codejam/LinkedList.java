package codejam;

import org.w3c.dom.Node;

class LNode{
	int data;
	LNode next;
	public LNode(){
		this.next=null;
	}
	public LNode(int d){
		this.data=d;
		this.next=null;
	}
	
	public String toString(){
		return "Val: "+this.data;
	}
}
class LinkedListException extends Exception{
	public LinkedListException(){
		super();
	}
	public LinkedListException(String msg){
		super(msg);
	}
}
public class LinkedList {
	LNode header;
	public LinkedList(){
		this.header=new LNode();
	}
	
	public LinkedList(int[] eles){
		this.header=new LNode();
		LNode curr=new LNode();
		curr=this.header;
		for(int num:eles){
			curr.next=new LNode(num);
			curr=curr.next;
		}
	}
	
	public String toString(){
		StringBuffer s=new StringBuffer("");
		LNode ptr=this.header;
		while(ptr.next!=null){
			s.append(ptr.next.data+" ");
			ptr=ptr.next;
		}		
		return s.toString();
	}
	public void removeDuplicates(){
		LNode ptr1=this.header;
		LNode ptr2=this.header;
		while(ptr1.next!=null){
			int currVal=ptr1.next.data;
			ptr2=ptr1.next;
			while(ptr2.next!=null){
				if(ptr2.next.data==currVal){
					ptr2.next=ptr2.next.next;
				}
				ptr2=ptr2.next;
			}
			ptr1=ptr1.next;
		}
	}
	
	public int getFromLast(int k) throws LinkedListException{
		LNode ptr1=this.header;
		LNode ptr2=this.header;
		int counter=0;
		while(ptr1.next!=null){
			if(counter>=k){
				//2nd ptr is always k behind first ptr
				ptr2=ptr2.next;
			}
			counter++;
			ptr1=ptr1.next;
		}
		if(counter<k){
			throw new LinkedListException("LinkedList length shorter than index provided"+k);
		}
		else{
			return ptr2.data;
		}
	}
	public LNode find(int val){
		LNode ptr=this.header;
		while(ptr!=null){
			if(ptr.next.data==val)
			{
				return ptr.next;
			}
			ptr=ptr.next;
		}
		return null;
	}
	
	public void insertAtNode(LNode n, int val){
		LNode newnode=new LNode(val);
		n.next=newnode;
	}
	
	public static LinkedList addLists(LinkedList l1, LinkedList l2){
		LinkedList sum=new LinkedList();
		LNode ptr1=l1.header.next;
		LNode ptr2=l2.header.next;
		LNode ptrSum=sum.header;
		int carry=0;
		int tmpSum=0;
		int val;

		while(ptr1!=null & ptr2!=null){
			tmpSum=ptr1.data+ptr2.data+carry;
			if(tmpSum>9){
				val=tmpSum-10;
				carry=1;
			}
			else{
				carry=0;
				val=tmpSum;
			}
				
			sum.insertAtNode(ptrSum, val);
			ptrSum=ptrSum.next;
			ptr1=ptr1.next;
			ptr2=ptr2.next;
			
		}
		while(ptr1!=null){
			sum.insertAtNode(ptrSum, ptr1.data+carry);
			ptrSum=ptrSum.next;
			ptr1=ptr1.next;
			carry=0;
		}
		while(ptr2!=null){
			sum.insertAtNode(ptrSum, ptr2.data+carry);
			ptrSum=ptrSum.next;
			ptr2=ptr2.next;
			carry=0;
		}
		if(carry!=0){
			sum.insertAtNode(ptrSum, carry);
		}
		return sum;
	}
	
	public void partition(int val){
		LNode pivot=this.find(val);
		LNode ptr=this.header.next;
		LNode prev=this.header;
		LNode tmp;
		//place all elements >pivot after pivot in LL
		while(ptr!=pivot){
			if(ptr.data>val){
				tmp=ptr;
				prev.next=tmp.next;
				ptr=ptr.next;
				
				tmp.next=pivot.next;
				pivot.next=tmp;				
			}
			else{
				prev=prev.next;
				ptr=ptr.next;
			}
		}
		ptr=pivot.next;
		LNode bPivot=prev;
		prev=pivot;
		while(ptr!=null){
			if(ptr.data<=val){
				tmp=ptr;
				prev.next=ptr.next;
				ptr=ptr.next;
				//move tmp to right after bPivot
				tmp.next=bPivot.next;
				bPivot.next=tmp;
			}
			else{
				ptr=ptr.next;
				prev=prev.next;
			}
		}
	}
	
	
	public static void main(String [] args){

		int[] eles={5,8,3,1,5,7,2,1,9};
		LinkedList l=new LinkedList(eles);

		System.out.println(l);
		l.removeDuplicates();
		System.out.println(l);
		try{
			System.out.println(l.getFromLast(8));	
		}catch(LinkedListException e){
			System.out.println(e.getMessage());
		}
		
		l.partition(8);
		System.out.println(l);
		
		
		int[] eles2={5,5};
		LinkedList l2=new LinkedList(eles2);	
		
		LinkedList sum=addLists(l,l2);
		System.out.println(sum);
	}
}
