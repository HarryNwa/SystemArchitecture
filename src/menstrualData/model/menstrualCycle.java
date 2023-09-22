package menstrualData.model;

public class menstrualCycle {
    private String username;
    private int age;
    private String password;

    public menstrualCycle(int age, String username, String password){
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
