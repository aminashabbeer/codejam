package codejam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class StringReversal {
	String fname;
	ArrayList<String> problems;
	
	StringReversal(String fname)
	{
		this.fname=fname;
		set_problems();
	}

	public void set_problems()
	{
		try {
			this.problems=(ArrayList<String>) Files.readLines(new File(fname), Charsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void solve_problems()
	{
		int cnt=1;
		this.problems.remove(0);
		for(String problem: this.problems)
		{
			System.out.println("Case #"+cnt+": "+this.reverseWords(problem));
			cnt++;
		}
	}
	public String reverseWords(String orig)
	{
		StringBuilder sb=new StringBuilder("");
		String[] strList=orig.split("\\s");
		for(int n=strList.length-1;n>=0;n--)
		{
			sb.append(strList[n]);
			sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String [] args)
	{
		StringReversal sr=new StringReversal("data/test2.txt");
		sr.solve_problems();
		//System.out.print(sr.reverseWords("this is a test"));
	}

}
