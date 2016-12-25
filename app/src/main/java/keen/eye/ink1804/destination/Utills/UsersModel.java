package keen.eye.ink1804.destination.Utills;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anton on 15.11.16.
 */

@IgnoreExtraProperties
public class UsersModel {
    int Day;
    String Email;
    long Id;
    int Month;
    String Name;
    String Password;
    boolean Sex;
    String Socionics;
    String Status;
    int Year;

    public UsersModel(long id, String name, int day, int month, int year, boolean sex, String socionics, String email, String password, String status) {
        Id = id;
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

