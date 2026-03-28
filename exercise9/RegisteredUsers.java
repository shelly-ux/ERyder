import java.util.List;
import java.util.ArrayList;

public class RegisteredUsers {
    private List<String[]> users;

    public RegisteredUsers() {
        users = new ArrayList<>();
    }

    public boolean userExists(String userId) {
        for (String[] u : users) {
            if (u[0].equals(userId)) return true;
        }
        return false;
    }

    public void addUser(String userId, String password) {
        users.add(new String[]{userId, password});
    }

    public boolean removeUser(String userId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i)[0].equals(userId)) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateUser(String userId, String newPwd) {
        for (String[] u : users) {
            if (u[0].equals(userId)) {
                u[1] = newPwd;
                return true;
            }
        }
        return false;
    }

    public boolean validateUser(String userId, String password) {
        for (String[] u : users) {
            if (u[0].equals(userId) && u[1].equals(password)) return true;
        }
        return false;
    }
}