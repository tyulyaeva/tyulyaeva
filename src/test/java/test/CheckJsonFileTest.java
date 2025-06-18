package test;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.StudentPersonData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckJsonFileTest {
    private ClassLoader classLoaderJsonFile= CheckJsonFileTest.class.getClassLoader();
    private ObjectMapper objectMapperclassLoaderJsonFile = new ObjectMapper();

    @DisplayName("Тест на проверку значений данных студентов из JSON-файла")
    @Test
    void checkJsonFileTest() throws Exception {
        try (InputStream inputStream = classLoaderJsonFile.getResourceAsStream("studentPersonData.json")) {
            assertNotNull(inputStream, "Файл не найден!");
        StudentPersonData studentPersonData = objectMapperclassLoaderJsonFile.readValue(inputStream, StudentPersonData.class);
        Assertions.assertEquals("Inna", studentPersonData.getName());
        Assertions.assertEquals(33, studentPersonData.getAge());
        Assertions.assertEquals(List.of("Java", "AQA"), studentPersonData.getCourses());
        Assertions.assertEquals("Russian Federation", studentPersonData.getAddress().getCountry());
        Assertions.assertEquals("Saint-Peterburg", studentPersonData.getAddress().getCity());
        Assertions.assertEquals(200791, studentPersonData.getAddress().getIdRec());
    }
        }
}




