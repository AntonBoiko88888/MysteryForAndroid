package keen.eye.ink1804.destination.Utills;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anton on 15.11.16.
 */

@IgnoreExtraProperties
public class UsersModel {
    public String Email;
    public String Id;

    public UsersModel() {

    }

    public UsersModel(String Email, String Id) {
        this.Email = Email;
        this.Id = Id;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Email", Email);
        result.put("Id", Id);

        return result;
    }
}

