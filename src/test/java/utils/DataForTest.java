package utils;
import com.github.javafaker.Faker;
import java.util.Locale;

public class DataForTest {
    Faker fakerEn = new Faker(new Locale("en"));

    public String firstNameInput = fakerEn.name().firstName();
    public String lastNameInput = fakerEn.name().lastName();
    public String userEmailInput = fakerEn.internet().emailAddress();
    public String genterWrapperInput = fakerEn.options().option("Male", "Female", "Other");
    public String userNumberInput = fakerEn.phoneNumber().subscriberNumber(10);
    public String dayOfBirthInput = String.format("%s", fakerEn.number().numberBetween(1, 28));
    public String monthOfBirthInput = fakerEn.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December");
    public String yearOfBirthInput = String.format("%s", fakerEn.number().numberBetween(1990, 2020));
    public String subjectsInput = fakerEn.options().option("Hindi", "English", "History", "Maths", "Physics", "Chemistry", "Biology");
    public String hobbiesWrapperInput = fakerEn.options().option("Sports", "Reading", "Music");
    public String uploadPictureInput = fakerEn.options().option("retouch.jpg");
    public String currentAddressInput = fakerEn.address().fullAddress();
    public String stateInput = fakerEn.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String cityInput = selectCity(stateInput);


    public String selectCity(String state) {
        switch (state) {
            case "Rajasthan":
                return fakerEn.options().option("Jaipur", "Jaiselmer");
            case "Haryana":
                return fakerEn.options().option("Karnal", "Panipat");
            case "Uttar Pradesh":
                return fakerEn.options().option("Agra", "Lucknow", "Merrut");
            case "NCR":
                return fakerEn.options().option("Delhi", "Gurgaon", "Noida");
            default:
                return null;
        }
    }
}
