import java.util.Scanner;

public class LinearSearch {
	
	public static int linearSearch(int arr[], int num) 
	{ 
	    int n = arr.length; 
	    for(int i = 0; i < n; i++) 
	    { 
	        if(arr[i] == num) 
	            return i+1; 
	    } 
	    return -1; 
	} 

	public static void main(String[] args) {
		System.out.println("Enter the required size of the array :: ");
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[] = new int [size];
        
        System.out.println("Enter the elements of the array one by one ");
        for(int i = 0; i<size; i++) {
           arr[i] = s.nextInt();
           }
        System.out.println("Enter the element you want to search :: ");
        int num = s.nextInt();
        
        int pos= linearSearch(arr,num);
        System.out.println("Position of the element you want to search is ::" + pos);
	}
}
