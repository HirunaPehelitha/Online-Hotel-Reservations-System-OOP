package hotel;

public class Feedbacks {
    private String name;
    private String email;
    private String comments;

    // Constructor
    public Feedbacks(String name, String email, String comments) {
        this.name = name;
        this.email = email;
        this.comments = comments;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getComments() {
        return comments;
    }
}
