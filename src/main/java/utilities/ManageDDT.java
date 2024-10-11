package utilities;

import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps{

    @DataProvider(name = "data-provider-textForSearch")
    public Object[][] getDataObjectText() {
        return getDataFromCSVColumn3(getData("DDTFile_TextSearch"));
    }

    @DataProvider(name = "data-provider-namesOfStudents")
    public Object[][] getDataObjectStudentsNames() {
        return getDataFromCSVColumn2(getData("DDTFile_NamesOfStudents"));
    }

    @DataProvider(name = "data-provider-resolutions")
    public Object[][] getDataObjectResolution() {
        return getDataFromCSV(getData("DDTFile_Resolutions"));
    }

    @DataProvider(name = "data-provider-buttonsNumbersAndNames")
    public Object[][] getDataObjectButtonsNames() {
        return getDataFromCSVMobile(getData("DDTFile_NumTextOfButtons"));
    }

    @DataProvider(name = "data-provider-indexOfTask")
    public Object[][] getDataObjectIndexOfTask() {
        return getDataFromCSVColumn3(getData("DDTFile_IndexesOfTasks"));
    }

    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static Object[][] getDataFromCSVMobile(String filePath) {
        Object[][] data = new Object[4][2];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

    public static Object[][] getDataFromCSVColumn3(String filePath) {
        Object[][] data = new Object[3][1];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i);
        }
        return data;
    }

    public static Object[][] getDataFromCSVColumn2(String filePath) {
        Object[][] data = new Object[2][1];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i);
        }
        return data;
    }

    public static Object[][] getDataFromCSV(String filePath) {
        Object[][] data = new Object[2][2];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i< csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

}