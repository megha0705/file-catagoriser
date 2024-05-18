import java.io.File;
import java.io.*;
import java.nio.file.Files;

class FileCategoriser{

public static void categorisingFiles(File[] files){
   	for(File filename : files){
         if(!filename.isDirectory()){
String fileType = "undetermined";
		String fileName = filename.getName();
		String extension = "";
		int i = fileName.lastIndexOf('.');

        if(i > 0){
			extension = fileName.substring(i+1);
		}
		try{
			fileType = Files.probeContentType(filename.toPath());
		}catch(IOException ioException) { 
                System.out.println( 
                    "Cannot determine file type of "
                    + filename
                    + " due to following exception: "
                    + ioException); 
            } 
               System.out.println("the extension of the " + fileName + "is -> " + extension + "filetype is ->" + fileType);
         }else{
             System.out.println("File does not exist!"); 
         }

      }
}



    public static void main(String[] args){
       
File[] files = new File("c:/Users/Saptarshi/Downloads").listFiles();
categorisingFiles(files);
    }
}