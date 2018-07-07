//Student: Marius Popescu
//Instructor: Dr. Fatma Serce
//CS 401: Algorithms
//06.02.2018

public class ClientSoil {
	public static void main(final String args[]) throws Exception {
		Soil s1 = new Soil("file1.txt");
		display(s1);
		Soil s2 = new Soil("file2.txt");
		display(s2);
		Soil s3 = new Soil("file3.txt");
		display(s3);
		Soil s4 = new Soil("file4.txt");
		display(s4);
		Soil s5 = new Soil("file5.txt");
		display(s5);
		Soil s6 = new Soil("file6.txt");
		display(s6);
		Soil s7 = new Soil("file7.txt");
		display(s7);
	}
	//this method will display an array
		private static void printArray(int [][]arr) {
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.print("\n");
			}
		}	
	//this method will display if the soil allow water to drain 
		private static void printAnswer(boolean b) {
			if (b)
				System.out.println("Allows water to drain");
			else
				System.out.println("Don't allow water to drain");	
			System.out.print("\n");
		}
	//this method will display the array and the answer
		public static void display(Soil sl) {
			printArray(sl.getSoil());
			printAnswer(sl.doesDrain());
		}
}
