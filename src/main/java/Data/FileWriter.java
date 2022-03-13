package Data;

import java.io.IOException;


public class FileWriter {

    public static void writeFile(String fileName, String content){
        try {
            java.io.FileWriter myWriter = new java.io.FileWriter(fileName);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
