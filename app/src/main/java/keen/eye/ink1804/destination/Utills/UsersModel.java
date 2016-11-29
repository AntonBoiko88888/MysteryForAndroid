package keen.eye.ink1804.destination.Utills;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anton on 15.11.16.
 */

@IgnoreExtraProperties
public class UsersModel {
    private int Day;
    private String Email;
    private int Month;
    private String Name;
    private String Password;
    private String Sex;
    private String Socionics;
    private String Status;
    private int Year;

    public UsersModel(String name, int day, int month, int year, String sex, String socionics, String email, String password, String status) {
        Name = name;
        Day = day;
        Month = month;
        Year = year;
        Sex = sex;
        Socionics = socionics;
        Email = email;
        Password = password;
        Status = status;
    }

    public UsersModel() {

    }

}

