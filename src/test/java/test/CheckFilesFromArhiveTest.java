package test;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static org.assertj.core.api.Assertions.*;

public class CheckFilesFromArhiveTest {

    private ClassLoader classLoaderArhiveFile = CheckFilesFromArhiveTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка наличия файлов в zip архиве")
    void checkArhiveFileTest() throws Exception {
        try (ZipInputStream arhive = new ZipInputStream(classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip"))) {
            List<String> fileNames = new ArrayList<>();
            ZipEntry entry;
            while ((entry = arhive.getNextEntry()) != null) {
                fileNames.add(entry.getName());
                System.out.println(entry.getName());
            }
            assertThat(fileNames)
                    .as("Проверка что архив содержит файлы")
                    .isNotEmpty()
                    .hasSizeGreaterThan(0);
        }
    }

    @Test
    @DisplayName("Проверка значений в .csv файле из архива")
    void csvCheckArhiveTest() throws Exception {
        boolean csvFound = false;
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
            ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".csv")) {
                    csvFound = true;
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zipInputStream));
                    List<String[]> content = csvReader.readAll();
                    org.assertj.core.api.Assertions.assertThat(content).contains(
                            new String[]{"Inna Tyulyaeva", "33", "Female", "AQA", "Russian Federation", "Saint-Peterburg"}
                    );
                }
            }
            assertThat(csvFound)
                    .as("Проверка наличия в архиве .csv файла")
                    .isTrue();
        }
    }

    @Test
    @DisplayName("Проверка значений в .xslx файле из архива")
    void xlsxCheckArhiveTest() throws Exception {
        boolean xlsFound = false;
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".xlsx")) {
                    xlsFound = true;
                    XLS xls = new XLS(zipInputStream);
                    String actualResult1 = xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue();
                    String actualResult2 = xls.excel.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
                    Assertions.assertEquals("Name student", actualResult1);
                    Assertions.assertEquals("Inna Tyulyaeva", actualResult2);
                }
            }
            assertThat(xlsFound)
                    .as("Проверка наличия в архиве .xls файла")
                    .isTrue();
        }
    }


    @Test
    @DisplayName("Проверка значений в .pdf файле из архива")
    void pdfCheckArhiveTest() throws Exception {
        boolean pdfFound = false;
        try (InputStream inputStream = classLoaderArhiveFile.getResourceAsStream("studentPersonData.zip");
             ZipInputStream zipInputStream = new ZipInputStream(inputStream)) {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().endsWith(".pdf")) {
                    pdfFound = true;
                    PDF pdf = new PDF(zipInputStream);
                    Assertions.assertTrue(pdf.text.contains("We confirm that on March 19, 2024 at 15:06 Moscow time"));
                }
            }
            assertThat(pdfFound)
                    .as("Проверка наличия в архиве найден .pdf файла")
                    .isTrue();
        }
    }
}




