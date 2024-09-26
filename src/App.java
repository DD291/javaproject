import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String dirname = System.getProperty("user.dir") + "/Folder";
        System.out.println("PATH: " + dirname);
        File folder = new File(dirname);
        System.out.println("folder: " + folder);
//         File folder = new File("/Users/you/folder/");
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        List<String> dirStack = new Stack<String>();


        String [] listOfFolderes = folder.list();

        for (String file : listOfFolderes) {
                System.out.println(file);
        
        }

    }

   
}


