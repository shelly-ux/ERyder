public class UserService {
    private RegisteredUsers registeredUsers;

    public UserService(RegisteredUsers users) {
        this.registeredUsers = users;
    }

    public boolean addUser(String userId, String password) {
        if (!registeredUsers.userExists(userId)) {
            registeredUsers.addUser(userId, password);
            return true;
        }
        return false;
    }

    public boolean removeUser(String userId) {
        return registeredUsers.removeUser(userId);
    }

    public boolean updateUser(String userId, String newPassword) {
        return registeredUsers.updateUser(userId, newPassword);
    }

    public boolean retrieveUser(String userId) {
        return registeredUsers.userExists(userId);
    }

    public boolean validateUser(String userId, String password) {
        return registeredUsers.validateUser(userId, password);
    }
}