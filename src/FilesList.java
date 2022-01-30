import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class FilesList{
    public String drive;
    public String name;
    public FilesList(String cameraDrive, String cameraName){
        drive = cameraDrive;
        name = cameraName;

    }
    public ArrayList<String> getFilePaths(){
            String[] pathnames;
            File f = new File(drive);
            pathnames = f.list();
            ArrayList<String> filePaths = new ArrayList<String>();
            for (String pathname : pathnames) {
            filePaths.add(drive + pathname);
        }
        return filePaths;
    }
    public ArrayList<String> getFileNames(){
        String[] pathnames;
        File f = new File(drive);
        pathnames = f.list();
        ArrayList<String> fileNames = new ArrayList<String>();
        for (String pathname : pathnames) {
        fileNames.add(pathname);
    }
    return fileNames;
}
    public void CopyFilesToFolders(ArrayList<String> filePaths, ArrayList<String> fileNames, ArrayList<String> destinations){
       for(String destination : destinations){
        int i = 0;
        for(String file:filePaths){
            File from = new File(file);
            File to = new File(file);
            to = new File(destination + fileNames.get(i));
            i++;
           try {
            Files.copy(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully.");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }   
        }
    }
}
}