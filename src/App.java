import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String dirname = System.getProperty("user.dir") + "/Folder";
        System.out.println("PATH: " + dirname);
        File folder = new File(dirname);
        System.out.println("folder: " + folder);

        Path rootPath = Paths.get(System.getProperty("user.dir"), "Folder");
        List<Path> allFiles = new ArrayList<>();
        listAllFiles(rootPath, allFiles);
        System.out.println("Found files:");

        // first: find file with no require - if not exists, impossible case 
        //second : bubble sort : 
        // start from second element :every time if (this file(n) has "require file(n+1)" - swap) else go to next
        String[] filesDirsArray = new String[allFiles.size()];
        for(int i = 0; i < allFiles.size(); i++) filesDirsArray[i] = allFiles.get(i).toString();
        
        for (int i = 0; i < filesDirsArray.length; i++)
        {
            System.out.println("forliio" + filesDirsArray[i] + " ");
            // File file = new File("C:/Users/dda29/Documents/GitHub/javaproject/Folder/Folder 1/File 1-1.txt");
            File file = new File(filesDirsArray[i]);

            try {
                Scanner scanner = new Scanner(file);
                int lineNum = 0;
                boolean foundRequire = false;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    lineNum++;
                    if(line.contains("require")) { 
                        System.out.println("line num: " +lineNum );
                        System.out.println("naiyou:  " +line ); 
                        foundRequire = true;
                    }
                }
                if (foundRequire==false){
                    //swap with first
                    String temp = filesDirsArray[i];
                    filesDirsArray[i] = filesDirsArray[0];
                    filesDirsArray[0] = temp;
                }
                scanner.close();
            } catch(FileNotFoundException e) { 
            }
        }

        for(int i = 0; i < filesDirsArray.length; i++){ 
            System.out.println("allFiles:  "+ i + ": " + filesDirsArray[i] ); 
        };

            


    }

     private static void listAllFiles(Path currentPath, List<Path> allFiles)
      throws IOException 
    {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentPath)) 
        {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    listAllFiles(entry, allFiles);
                } else {
                    allFiles.add(entry);
                }
            }
        }
    }


    static void bubbleSort(int arr[], int n){

        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false)
                break;
        }
    }

   
}


