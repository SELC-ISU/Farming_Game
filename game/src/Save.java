import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Save {

	public int[][] loadTerrain(String fileName,int worldWidth,int worldHeight){
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int array[][] = new int[worldWidth][worldHeight];
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
	
	public void saveTerrain(int[][] terrain) {
		
	}
	
}

