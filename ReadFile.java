//Student: Marius Popescu
//Instructor: Dr. Fatma Serce
//CS 401: Algorithms
//06.02.2018
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//This object will read from a file to a 2d array
public class ReadFile {
	int intLength;
	int[][] soil;
	String filename = " ";
	File theFile;
	Scanner sc1;
	Scanner sc2;
	//the constructor
	public ReadFile(String filename) throws FileNotFoundException {
		this.filename = filename;
		theFile = new File(filename);
		sc1 = new Scanner(theFile);
		sc2 = new Scanner(theFile);
		intLength = getLength();
		soil = new int [intLength][intLength];
		fillArry();			
	}
	//this method will compute the length of array
	public int getLength() throws FileNotFoundException {				
		String[] length = sc1.nextLine().trim().split("\\s+");
		for (int i = 0; i < length.length; i++) {
				intLength++;
			}
		return intLength;
	}
	//this method will fill the array
	private void fillArry(){
		for(int i = 0; i < soil.length; i++) {
			for(int j = 0; j < soil[i].length; j++) {
				soil[i][j] = sc2.nextInt();
			}		
		}
	}
	//this method will return the array
	public int[][] getArryFromFile(){
		return soil;
	}
}	