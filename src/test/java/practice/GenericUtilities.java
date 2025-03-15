package practice;

import GenericUtility.JavaUtility;

public class GenericUtilities {

	public static void main(String[] args) 
	{
		JavaUtility ob = new JavaUtility();
		System.out.println(ob.getSystemDateInFormat());
		int sum = add(10,20);
		System.out.println(sum);
		int v = add(sum,70);
		System.out.println(v);
		System.out.println(add(100,200));
	

	}
	public static int add(int a,int b)
	{
		int c = a+b;
		return c;
	}
	    
	   
	    


}
