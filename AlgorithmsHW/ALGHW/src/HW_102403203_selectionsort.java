import java.util.Random;
import java.util.Arrays;

public class HW_102403203_selectionsort {
	private int[] data;
	private static final Random ArrayNum = new Random();
	

	public static void main (String[] args) {
		HW_102403203_selectionsort sortArray = new HW_102403203_selectionsort(10);
		
	    System.out.print("Unsorted array:");
	    System.out.print(sortArray + "\n");
	    
	    sortArray.sort();
	    
	    System.out.print("Sorted array:");
	    System.out.print(sortArray);
	}
	
	
	
	
    public HW_102403203_selectionsort (int size) {
		
		data = new int[size];
		
		for(int i=0; i<size ; i++) 
		    data[i]=10+ArrayNum.nextInt(90);
						
		
	 
		
	}
	



    public void sort() {
	
	int smallest ;
	
	    for(int i=0; i <data.length; i++) {
	    smallest = i;
	   
	      for(int index=i+1; index <data.length; index++) 
		      if(data[index] < data[smallest])
			      smallest = index ;
	  
	  swap(i,smallest);
	  printPass(i+1 , smallest);
	
	
	
	
	
	    }
    }
	
    public void swap(int first, int second) {
    	
	    int temportary=data[first];
	    data[first]=data[second];
	    data[second]=temportary;
	
    }	

    public void printPass(int pass , int index) {
	
	    System.out.print(String.format("after pass %2d: ", pass));
	
	    for(int i =0 ; i<index ; i++)
		    System.out.print( data[i]+" ");
	
	    System.out.print( data[index]+"* ");
	
	    for(int i =index+1 ; i<data.length ; i++)
		    System.out.print( data[i]+" ");
	
	    System.out.print("\n            ");
	
	    for(int j =0 ; j<pass ; j++)
		    System.out.print("--  ");
	    System.out.print("\n");
	
    }

    public String toString() {
	    return Arrays.toString(data);
    }
  

}
