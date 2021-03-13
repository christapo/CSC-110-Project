import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataStructure {
	public static void main(String[] args) throws IOException {
		
		var fileName = "C:\\school\\CSC110\\CSC -110 Project\\data.txt";
		var filePath = Paths.get(fileName);
		

		if(!Files.exists(filePath)){		
			System.out.println("**** Error: Could not find the file in the path "+ fileName);
			return;
		}	
		System.out.println("Success:  file was found in the path "+ fileName);
		
		var bufferReader = Files.newBufferedReader(filePath); 
		var dataLine = bufferReader.readLine(); 
		if(dataLine == null){ 
			System.out.println("Success:  There is no data in the file"+ fileName);
			bufferReader.close();
			return;
		}
		System.out.println("Data : "+ dataLine);

		dataLine = bufferReader.readLine(); 
		var userListGood = new PriorityQueue<String>();
		var userListBad = new PriorityQueue<String>();
		while(dataLine != null){

			var lineNumber = 2;

			for(lineNumber = 2; lineNumber<=21; lineNumber = lineNumber + 1){
				System.out.println("Data : "+ dataLine + " ["+ lineNumber + "]");

				var foundX =  dataLine.startsWith("X");
				var foundZ =  dataLine.startsWith("Z");
				if(!foundX && !foundZ ){
					userListGood.add(dataLine + " ["+ lineNumber + "]");
			}		

				if(foundX || foundZ){
					userListBad.add(dataLine + " ["+ lineNumber + "]");
				}
				dataLine = bufferReader.readLine();
		}
		bufferReader.close();

		
		var goodQueue  = new PriorityQueue<String>();
		for (var userData : userListGood) {  
			goodQueue.add(userData) ;
		}          
		
		var badQueue = new PriorityQueue<String>();
		for (var userData : userListBad) {
			badQueue.add(userData) ;
		}
		
		     
       
		 var outFleNameGood = "C:\\school\\CSC110\\CSC -110 Project\\GoodData.txt";        
		 var outFilePathGood = Paths.get(outFleNameGood);        
		 var writeStreamGood = Files.newBufferedWriter(outFilePathGood);        
		 writeStreamGood.write("Key,Name,Address,Phone");  
		 writeStreamGood.newLine();
		 for (var item : goodQueue) {  
			writeStreamGood.write(item);  
			writeStreamGood.newLine();        
		 }          
		 writeStreamGood.close();

		 var outFleNameBad = "C:\\school\\CSC110\\CSC -110 Project\\BadData.txt";
		 var outFilePathBad = Paths.get(outFleNameBad);
		 var writeStreamBad = Files.newBufferedWriter(outFilePathBad);
		 writeStreamBad.write("Key,Name,Address,Phone");
		 writeStreamBad.newLine();
		 for (var item : badQueue) {
			writeStreamBad.write(item);
			writeStreamBad.newLine();
		 }
		 writeStreamBad.close(); 
	}
}
}