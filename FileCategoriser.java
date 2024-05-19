import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths; 
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
          
            //destination folder path
         File targetFolder = new File("c:/Users/Saptarshi/OneDrive/Desktop/file-categoriser/" + extension) ;
            if(!targetFolder.exists()){
                targetFolder.mkdir();
                System.out.println("new folder is created" + targetFolder.getAbsolutePath());
            }else{
                System.out.println("failed to craete new folder is" + targetFolder.getAbsolutePath());

            }
            //destination file path
             File targetFile = new File(targetFolder , fileName);
            try{
                Files.move(filename.toPath() , targetFile.toPath());
                System.out.println("files are succesfully moved to new folder" +  targetFile.getAbsolutePath());
            }catch(IOException ioException){
    System.out.println(  "Cannot move file  "
                    + filename
                    + " due to following exception: "
                    + ioException); 
            }
              
             
         }else{
              
            System.out.println("file does not exist");
             
             
			
         }

      }
}



    public static void main(String[] args){
       


File[] files = new File("c:/Users/Saptarshi/OneDrive/Desktop/file-categoriser").listFiles();
categorisingFiles(files);
    }
}


