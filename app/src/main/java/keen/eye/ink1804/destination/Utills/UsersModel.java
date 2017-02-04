package keen.eye.ink1804.destination.Utills;
import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anton on 15.11.16.
 */

@IgnoreExtraProperties
public class UsersModel {
    public int Day;
    public long Id;
    public int Month;
    public String Name;
    public boolean Sex;
    public String Socionics;
    public int Year;

    public UsersModel(long id, String name, int day, int month, int year, boolean sex, String socionics) {
        Id = id;
        Name = name;
        Day = day;
        Month = month;
        Year = year;
        Sex = sex;
        Socionics = socionics;
    }

    public UsersModel() {

    }

}

