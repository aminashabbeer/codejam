package codejam;

public class BalancedTree {
	Node root;
	private class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data=data;
		}
		public void addLeftChild(int val){
			Node leftChild=new Node(val);
			this.left=leftChild;
		}
		public void addRightChild(int val){
			Node rightChild=new Node(val);
			this.right=rightChild;
		}
		public int height(){
			if(this.left==null&& this.right==null){
				return 1;
			}else if(this.left==null){
				return this.right.height();
			}
			else if(this.right==null){
				return this.left.height();
			}
			else{
				return 1+Integer.max(this.left.height(),this.right.height());
			}
		}
	}
	
	public boolean isBalanced(){
		int lh=this.root.left.height();
		int rh=this.root.right.height();
		if(Math.abs(lh-rh)<=1){
			return true;
		}
		else{
			return false;
		}
	}
	public BalancedTree(int[] eles){
			for(int e:eles){
				
			}
	}
	public static void main(String[] args){
		int[] eles={5,6,7,8,9,3,2,1,5};	
	}
}
