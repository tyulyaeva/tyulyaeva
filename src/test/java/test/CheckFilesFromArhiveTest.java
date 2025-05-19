package test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CheckFilesFromArhiveTest {

    private ClassLoader classLoaderArhiveFile = CheckFilesFromArhiveTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка наличия файлов в zip архиве")
    void checkArhiveFileTest() throws Exception {

        try (ZipInputStream arhive = new ZipInputStream(classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip"))) {
            ZipEntry entry;
            while ((entry = arhive.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
        }
    }

    @Test
    @DisplayName("Проверка значений в .csv файле из архива")
    void csvCheckArhiveTest() throws Exception {
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".csv")) {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zipInputStream));
                    List<String[]> content = csvReader.readAll();
                    org.assertj.core.api.Assertions.assertThat(content).contains(
                            new String[]{"Inna Tyulyaeva", "33", "Female", "AQA", "Russian Federation", "Saint-Peterburg"}
                    );
                }
            }
        }
    }

    @Test
    @DisplayName("Проверка значений в .xslx файле из архива")
    void xlsxCheckArhiveTest() throws Exception {
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zipInputStream);
                    String actualResult1 = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    String actualResult2 = xls.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
                    Assertions.assertEquals("Name student", actualResult1);
                    Assertions.assertEquals("Inna Tyulyaeva", actualResult2);
                }
            }
        }
    }


    @Test
    @DisplayName("Проверка значений в .pdf файле из архива")
    void pdfCheckArhiveTest() throws Exception {
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zipInputStream);
                    Assertions.assertTrue(pdf.text.contains("We confirm that on March 19, 2024 at 15:06 Moscow time"));
                }
            }

        }
    }
}




