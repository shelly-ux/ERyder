public class UserRegistration {
    private boolean isRegistered;
    private String email;

    public UserRegistration() {
    }

    public boolean isRegistered() {
        return isRegistered;
    }

    public void setRegistered(boolean registered) {
        isRegistered = registered;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void registration() {
        System.out.println("User registration processed for: " + email);
        this.isRegistered = true;
    }
}