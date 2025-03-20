import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Futil {
    public static String loadFileContent(String filePath) {
        // String filePath = System.getProperty("user.dir") + "\\rsc\\simpleFile.txt";

        StringBuilder stringBuilder = new StringBuilder();
        File srcFile = new File(filePath);
        try (FileReader fileReader = new FileReader(srcFile)) {
            int charCode;
            while ((charCode = fileReader.read()) != -1) {
                stringBuilder.append((char) charCode);
            }
        } catch (IOException e) {
            System.out.println("Failed to load from file: " + e.getMessage());
        }
        return stringBuilder.toString();
    }

    public static void writeStringToFile(String resFilePath, String fileContent) {
        File resFile = new File(resFilePath);

        try (FileWriter fileWriter = new FileWriter(resFile)) {
            fileWriter.write(fileContent);
        } catch (IOException e) {
            System.out.println("Failed to write to file: " + e.getMessage());
        }
    }

    public static void writeFileToFile(String srcFilePath, String resFilePath){
        writeStringToFile(resFilePath, loadFileContent(srcFilePath));
    }
}
