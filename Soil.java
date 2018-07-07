//Student: Marius Popescu
//Instructor: Dr. Fatma Serce
//CS 401: Algorithms
//06.02.2018
import java.io.FileNotFoundException;

import edu.princeton.cs.algs4.UF;

public class Soil {
	//create the ReadFile object
	ReadFile f;
	//creating an array in order to copy the file inside it
	int[][] soil;
	//creating tag arrays in order to send the tags to UF
	static int[][] tag; 
	//create Union Find
	UF uf;
	//the constructor
	public Soil(String file) throws FileNotFoundException {
		f = new ReadFile(file);
		soil = f.getArryFromFile();
		tag = new int [soil.length][soil.length];
		int nr = 0;
		for(int i = 0; i < soil.length; i++) {
			for(int j = 0; j < soil[i].length; j++) {
				tag[i][j] = nr;
				nr ++;
			}
			}
		uf = new UF(soil.length * soil.length);
		//connect if there are two neighbors with the value of 1
		connect();
	}
	//this method will connect if there are two neighbors (vertical or horizontal) with the value of 1
	private void connect() {
		for(int i = 0; i < soil.length - 1; i++) {
			for(int j = 0; j < soil[i].length - 1; j++) {
				if ((soil[j][i] == 1) && (soil[j+1][i] == 1)) {
					int p = tag[j][i];
					int q = tag[j+1][i];
					uf.union(q, p);
				}
				if ((soil[j][i] == 1) && (soil[j][i+1] == 1)) {
					int p = tag[j][i];
					int q = tag[j][i+1];
					uf.union(q, p);
				}
			}
			for(int k = soil.length - 1; k > 0; k--) {
				for(int l = soil[k].length - 1; l > 0; l--) {				
					if ((soil[l][k] == 1) && (soil[l-1][k] == 1)) {
						int p = tag[l][k];
						int q = tag[l-1][k];
						uf.union(q, p);
					}
					if ((soil[l][k] == 1) && (soil[l][k-1] == 1)) {
						int p = tag[l][k];
						int q = tag[l][k-1];
						uf.union(q, p);
					}
				}
			}
		}
	}
	//this method will check if first row and last row from the soil array are connected and will return true or false
	public boolean doesDrain() {
		boolean x = false;
		for(int y = 0; y < tag.length; y++) {
			for(int z = 0; z < tag.length; z++) {
				if(uf.connected(tag[0][y], tag[tag.length-1][z])) 
					x = true;
				}
			}		
		return x;		
	}	
	//this method will return the soil array
	public int[][] getSoil(){
		return soil;	
	}
}