import java.util.ArrayList;
public class Camera{
    public FilesList seventyD;
    public FilesList oldCamera;
    String driveName;
    public Camera(){
        seventyD = new FilesList("F:/DCIM/100CANON/", "70D");
        oldCamera = new FilesList("F:/DCIM/104_PANA/", "old");
    }
    public static void main(String[] args) {
        Camera cameras = new Camera();
        ArrayList<String> destinations = new ArrayList<>();
       // destinations.add("L:/Pics/70D");
      //  destinations.add("C:/Users/Luke/Desktop/70D/");
      destinations.add("C:/Users/Luke/Desktop/Grandpa Camera/");
        String thisDateAndUp = "03/06/2022";
       ArrayList<String> paths = cameras.seventyD.getFilePaths();
      // ArrayList<String> pathsOld = cameras.oldCamera.getFilePaths();
       ArrayList<String> pathsToCopy = cameras.seventyD.sortThisDateAndUp(thisDateAndUp, paths);
     //  ArrayList<String> pathsToCopyOld = cameras.oldCamera.sortThisDateAndUp(thisDateAndUp, pathsOld);

        cameras.seventyD.CopyFilesToFolders(pathsToCopy, destinations);
     // cameras.oldCamera.CopyFilesToFolders(pathsToCopyOld, destinations);

     //not sure if sync works
     // cameras.seventyD.sync("70D", "C:/Users/Luke/Desktop/70D/");
     // cameras.oldCamera.sync("Linc pics", "C:/Users/Luke/Desktop/Grandpa Camera/");
    }
}