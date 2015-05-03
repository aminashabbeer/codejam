package codejam;

public class QuickSort {

	Comparable [] arr;
	
	public void swap(int i, int j)
	{
		Comparable tmp;
		tmp=this.arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
	
    public static boolean less(Comparable v, Comparable w) 
    {
        return (v.compareTo(w) < 0);
    }
    
    public void sort(int lo, int hi)
    {
    	if(hi<=lo)
    		return;
    	int p=partition(lo,hi);
    	sort(lo,p-1);
    	sort(p+1,hi);
    }
	

	public int partition(int lo, int hi)
	{
		Comparable v=arr[lo];
		int i=lo;
		int j=hi+1;
		while(true)
		{
			while(less(arr[++i],v))
				if(i==hi)
					break;
			
			while(less(v,arr[--j]))
				if(j==lo)
					break;
			
			if(i>=j)
				break;
			
			swap(i,j);					
		}
		swap(lo,j);
		return j;
	}
	public QuickSort(Comparable[] arr)
	{
		this.arr=arr;
	}
	
	public static void main(String args)
	{
		Comparable[] arr={5,6,7,3,2,1};
		QuickSort q=new QuickSort(arr);
		q.sort(0, arr.length-1);
		System.out.println("Sorted array");
		for(int i=0;i<q.arr.length;++i){
			System.out.println(q.arr[i]);
		}
	}
}
