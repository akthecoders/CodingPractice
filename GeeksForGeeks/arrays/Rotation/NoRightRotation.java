package Rotation;

public class NoRightRotation { 
	static boolean rightRotationDivisor(int N) 
	{ 
		int lastDigit = N % 10; 
		int rightRotation = (int)(lastDigit * Math.pow(10 ,(int)(Math.log10(N))) 
						+ Math.floor(N / 10)); 
		return (rightRotation % N == 0); 
	} 
		
	static void generateNumbers(int m) 
	{ 
		for (int i= (int)Math.pow(10,(m - 1)); i < Math.pow(10 , m);i++) 
			if (rightRotationDivisor(i)) 
				System.out.println(i); 
	} 


	public static void main(String args[]) 
	{ 
		int m = 3; 
		generateNumbers(m); 
	
	} 
} 

