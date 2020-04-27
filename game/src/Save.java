import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Save {

	public int[][] loadTerrain(String fileName,int worldWidth,int worldHeight){
		
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int array[][] = new int[worldHeight][worldWidth];
		    String line = br.readLine();
		    int i = 0, j = 0;
	        while (line != null) {
	            String strArray[] = line.split(" ");

	            if (!line.trim().isEmpty()) {
	                for (String s : strArray) {
	                    if (!s.trim().isEmpty()) {
	                        array[i][j++] = Integer.parseInt(s);
	                   
	                    }
	                }
	                line = br.readLine();
	                i++;
	                j = 0;
	            }
	        }
	        br.close();
	        
	       
	        return array;
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 return null;
		
	}
	
	public void saveWorld(int[][] terrain, String filename) throws IOException {
		
		FileWriter fileWriter = new FileWriter(filename);
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 32; j++) {
				fileWriter.write((char)terrain[i][j] + '0');
				fileWriter.write(" ");
				
			}
			fileWriter.write("\n");
		}
		fileWriter.close();
	}
	
public void saveTime(int[][] terrain, String filename) throws IOException {
		
		FileWriter fileWriter = new FileWriter(filename);
		for(int i = 0; i < 18; i++) {
			for(int j = 0; j < 32; j++) {
				fileWriter.write(String.valueOf(terrain[i][j]));
				fileWriter.write(" ");
				
			}
			fileWriter.write("\n");
		}
		fileWriter.close();
	}
}

