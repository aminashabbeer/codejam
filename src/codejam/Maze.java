package codejam;

import java.util.ArrayList;


class Node
{
	int val;
	private int maxLen=-1;
	ArrayList<Node> neighbours;
	public Node(int val)
	{
		this.val=val;
		this.neighbours=new ArrayList<Node>(Maze.MAXS);
	}
	
	public void setMaxLen()
	{
		int maxLen=0;
		int len=0;
		for(Node nbr: neighbours)
		{
			System.out.print("Room "+this.val);
			len=nbr.getMaxLen()+1;
			System.out.println(" Len"+len);
			if(len>maxLen)
			{
				maxLen=len;
			}
		}
		this.maxLen=maxLen;
	}
	public void setMaxLen(int len)
	{
		this.maxLen=len;
	}
	public int getMaxLen()
	{
		//If not set, set it first
		if(this.maxLen==-1)
		{
			this.setMaxLen();
		}
		return this.maxLen;
	}
}

public class Maze {

	int S;
	static final int MAXS=10;
	Node[][] rooms;
	public Maze(String[] problem)
	{
		System.out.println(problem[0]);
		this.S=Integer.parseInt(problem[0].trim());
		this.rooms=new Node[S][];
		for(int i=0;i<S;++i)
		{
			rooms[i]=new Node[S];
			System.out.println(problem[i+1]);
			String[] vals=problem[i+1].split("\\s");
			for(int j=0;j<S;++j)
			{
				System.out.println(vals[j]);
				rooms[i][j]=new Node(Integer.parseInt(vals[j].trim()));
			}
		}
		
		this.set_neighbours();
	}
	
	public void set_neighbours()
	{
		for(int i=0;i<S;i++)
		{
			for(int j=0;j<S;++j)
			{
				int currval=rooms[i][j].val;
				System.out.println(i);
				System.out.println(j);
				//9 cannot have any neighbours
				if(currval!=9)
				{
					if(i<S-1)
					{
						if((rooms[i+1][j].val-currval)==1)
						{
							this.rooms[i][j].neighbours.add(rooms[i+1][j]);	
						}					
					}
					if(j<S-1)
					{
						if((rooms[i][j+1].val-currval)==1)
						{
							this.rooms[i][j].neighbours.add(rooms[i][j+1]);	
						}
					}
					if(i>0)
					{
						if((rooms[i-1][j].val-currval)==1)
						{
							this.rooms[i][j].neighbours.add(rooms[i-1][j]);	
						}
					}
					if(j>0)
					{
						if((rooms[i][j-1].val-currval)==1)
						{
							this.rooms[i][j].neighbours.add(rooms[i][j-1]);
						}
					}	
				}
			}
		}
	}
	
	public void solve()
	{
		int maxLen=0;
		int maxRoom=1;
		int len=0;
		for(int i=0;i<this.S;++i)
		{
			for(int j=0;j<this.S;++j)
			{
				len=this.rooms[i][j].getMaxLen();
				if(len>=maxLen)
				{
					maxLen=len;
					if(maxRoom>this.rooms[i][j].val)
						maxRoom=this.rooms[i][j].val;
				}
			}
		}
		System.out.println("Solution is Room: "+maxRoom+" of length "+maxLen);
	}
	
	public static void main(String [] args)
	{
		//String[] problem={"3\n","1 2 9 \n","5 3 8\n","4 6 7"};
		String[] problem={"2","3 4","1 2"};
		Maze m=new Maze(problem);
		m.solve();
	}
}
