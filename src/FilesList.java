import java.util.ArrayList;
import java.util.Locale;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class FilesList{
    public String drive;
    public String name;
    public FilesList(String cameraDrive, String cameraName){
        drive = cameraDrive;
        name = cameraName;

    }
    public void sync(String serverFolder, String desktopFolder){
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("L:/Pics/" + serverFolder + "/");
        String[] pathnames;
            File f = new File(desktopFolder);
            pathnames = f.list();
            ArrayList<String> filePaths = new ArrayList<String>();
            for (String pathname : pathnames) {
            filePaths.add(drive + pathname);
        }
        CopyFilesToFolders(filePaths, destinations);
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

    public void CopyFilesToFolders(ArrayList<String> filePaths, ArrayList<String> destinations){
       for(String destination : destinations){
        int i = 0;
        for(String file:filePaths){
            File from = new File(file);
            File to = new File(file);

            //substring may need to be adjusted
            to = new File(destination + filePaths.get(i).substring(17));
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

public static String getDate(String path){
    File file =  new File(path);
    //need to change to date taken, not modified or created
       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
       String date = sdf.format(file.lastModified());
      // System.out.println(date);
    return date;
}

public ArrayList<String> sortThisDateAndUp(String thisDateUp, ArrayList<String> paths){
    ArrayList<String> pathsToCopyFromCamera = new ArrayList<>();
    for (int i = 0; i < paths.size(); i++) {
        String date = FilesList.getDate(paths.get(i));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        LocalDate dateDesired = LocalDate.parse(thisDateUp, formatter);
        LocalDate dateAcatual = LocalDate.parse(date, formatter);
        if(dateAcatual.isAfter(dateDesired) || dateAcatual.equals(dateDesired)){
         pathsToCopyFromCamera.add(paths.get(i));
      } 
    }
    return pathsToCopyFromCamera;
}

}