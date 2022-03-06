import java.util.ArrayList;
import java.util.Date;
public class Camera{
    public FilesList seventyD;
    public FilesList oldCamera;
    String driveName;
    public Camera(){
        seventyD = new FilesList("Z:/Canon/SD/DCIM/100Canon/", "70D");
        oldCamera = new FilesList("Y:/", "old");
    }
    public static void main(String[] args) {
        Camera cameras = new Camera();
        ArrayList<String> destinations = new ArrayList<>();
       // destinations.add("L:/Pics/70D");
        destinations.add("C:/Users/Luke/Desktop/70D/");
        String thisDateAndUp = "03/06/2022";
       ArrayList<String> paths = cameras.seventyD.getFilePaths();
       ArrayList<String> pathsToCopy = cameras.seventyD.sortThisDateAndUp(thisDateAndUp, paths);
    //   System.out.println(pathsToCopy.get(4).substring(26));
       System.out.println(pathsToCopy.size());
        cameras.seventyD.CopyFilesToFolders(pathsToCopy, destinations);
    }
}