package codejam;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

class CreditCase
{
	double C;
	double[] P;
	int[] result=new int[NUM_ITEMS];
	public static final int NUM_ITEMS=2;
	public static final int MIN_C=5;
	public static final int MAX_C=1000;
	public static final int MIN_P=0;
	public static final int MAX_P=1000;

	public CreditCase(double C, double[] P)
	{
		this.C=C;
		this.P=P;
		this.set_result();
	}
	public String toString()
	{
		return result[0]+" "+result[1];
	}
	public void set_result()
	{

		double mindiff=1000*NUM_ITEMS-MIN_C;
		double diff0=0;
		double diff=0;
		for(int i=0;i<P.length;++i)
		{
			diff0=P[i]-C;
			for(int j=i+1;j<P.length;++j)
			{
				diff=P[j]+diff0;
				if(diff<mindiff && diff>=0)
				{
					mindiff=diff;
					this.result[0]=i+1;
					result[1]=j+1;
					if(diff==0)
					{
						return;
					}
				}
			}
		}
		return;
	}
}
public class CreditFit {

	public CreditFit(String testfile)
	{
		Path file=FileSystems.getDefault().getPath("data", testfile);
		Charset charset = Charset.forName("US-ASCII");
		try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
		    String line = null;
		    int N=0;
		    double C=0;
		    int I=0;
		    double []P={};
		    String[] str_P;
		    while ((line = reader.readLine()) != null) {
		    	N=Integer.parseInt(line);
		    	for(int test=0;test<N;++test)
		    	{
		    		for(int i=0;i<3;++i)
			        {
		    			if((line = reader.readLine()) != null)
		    			{
		    				switch(i)
		    				{
		    				case 0:C=Double.parseDouble(line);break;
		    				case 1:I=Integer.parseInt(line);break;
		    				case 2:	str_P=line.split("\\s+");
		    						P = new double[I];
		    						for(int item=0;item<P.length;++item)
		    						{
		    							P[item]=Double.parseDouble(str_P[item]);
		    						}
		    						break;
		    				default: break;
		    				}	
		    			}
			        }
		    		CreditCase cp=new CreditCase(C,P);
		    		System.out.println("Case #"+test+": "+cp);
		    	}
		        
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}	
	}
	public static void main(String[] args) throws IOException
	{
		String testfile="test1.txt";
		CreditFit cf= new CreditFit(testfile);	
	}
}
