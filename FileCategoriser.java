import java.io.File;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path; 
import java.nio.file.Paths; 
class FileCategoriser{
    public static void main(String[] args){
        File[] files = new File("c:/Users/Saptarshi/OneDrive/Desktop/file-categoriser").listFiles();

        // Loop through each file in the list of files

        for(File filename : files){
            if(!filename.isDirectory()){
                String fileType = "undetermined";
                String fileName = filename.getName();
                String extension = "";
                int i = fileName.lastIndexOf('.');

                //if there is a index of period extension is extracted

                if(i > 0){
                    extension = fileName.substring(i+1);
                }else {

                    //if no extension is present new folder is created "others". files are moved there
                
                    File otherFolder = new File("c:/Users/Saptarshi/OneDrive/Desktop/file-categoriser/others" ) ;
                    if(!otherFolder.exists()){
                        otherFolder.mkdir();
                        System.out.println("new folder is created" + otherFolder.getAbsolutePath());
                        }
                    File otherFile = new File(otherFolder , fileName);
                    try{
                        Files.move(filename.toPath() , otherFile.toPath());
                        System.out.println("files with no extensions are succesfully moved to new folder" +  otherFile.getAbsolutePath());
                    }catch(IOException ioException){
                        System.out.println("Cannot move file " + filename + " due to following exception: " + ioException);
                        }
               }

                // if file has extensions destination folder path is created and files are moved there

                File targetFolder = new File("c:/Users/Saptarshi/OneDrive/Desktop/file-categoriser/" + extension) ;
                if(!targetFolder.exists()){
                    targetFolder.mkdir();
                    System.out.println("new folder is created" + targetFolder.getAbsolutePath());
                    }
                 //destination file path is created
                 File targetFile = new File(targetFolder , fileName);
                 try{
                    Files.move(filename.toPath() , targetFile.toPath());
                    System.out.println("files are succesfully moved to new folder" +  targetFile.getAbsolutePath());
                }catch(IOException ioException){
                        System.out.println( "Cannot move file" + filename + " due to following exception: " + ioException); 
                    }
    
            }else{
    System.out.println("it is a folder");}
        }
    }
}


