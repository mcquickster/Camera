import java.util.ArrayList;
public class Camera{
    public FilesList seventyD;
    public FilesList oldCamera;
    String driveName;
    public Camera(){
        seventyD = new FilesList("XXXXXXXX", "70D");
        oldCamera = new FilesList("Y:/", "old");
    }
    public static void main(String[] args) {
        Camera cameras = new Camera();
        ArrayList<String> destinations = new ArrayList<>();
        destinations.add("L:/Pics/70D");
       // destinations.add("C:/Users/Luke/Desktop/70D");
        cameras.seventyD.CopyFilesToFolders(cameras.seventyD.getFilePaths(), cameras.seventyD.getFileNames(), destinations);
    }
}