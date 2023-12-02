import DTO.Request;
import controller.DiaryController;
import data.model.Entry;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.InputMismatchException;

import static java.lang.System.exit;

public class MainDiary {
    private String userName;
    private String password ;
    private String title;
    private String body;
    private String ownerName;
    private int diaryUser;
//    private String bodyEdited;
//    private String titleEdited;
    private LocalDateTime currentDateTime = LocalDateTime.now();
    DiaryController diary = new DiaryController();
    Request request = new Request();
    public static void main(String[] args) {
        MainDiary mainDiary = new MainDiary();
        mainDiary.welcomeMenu();
        mainDiary.diaryMenu();
        mainDiary.lockDiary();
    }

    public void welcomeMenu() {
        diaryUser = Integer.parseInt(prompt("""
                HELLO! WELCOME BUDDY DIARY
                          
                This is a Diary, not a Journal!
                                    
                1. Create new diary account
                                    
                2. Log in
                                    
                3. Exit"""));
        if(diaryUser == 1) createAccount();
        if (diaryUser == 2) login();
        if (diaryUser == 3) exitDiary();
        if (diaryUser == 0) exit(0);
        else {
            welcomeMenu();
        }
    }

    private void exitDiary() {
        int exit = JOptionPane.showConfirmDialog(null, "Click yes to log out or no to return to Diary menu");
        if (exit == 0) {
            display(":( Buddy Diary is closing>>>>\n Goodbye!");
            exit(0);
        }
        if (exit == 1) {
            welcomeMenu();
        }
    }

    public void login() throws NullPointerException {
        try {
            String userLogin = prompt("Enter username");
            String userPassword = prompt("Enter password");

            if (!userName.equals(userLogin)) {
                display("Username does not exist");
                if (!password.equals(userPassword)) {
                    display("Invalid password");
                }
            }
        } catch (NullPointerException error) {
            display(error.getMessage());
            welcomeMenu();
        }
        diaryMenu();
    }

    public void diaryMenu() {
        diaryUser = Integer.parseInt(prompt("""
                To continue, press:
                                    
                1. Lock diary
                2. Unlock diary
                3. Confirm diary is locked
                4. Create entry
                5. Delete entry
                6. Find entry by ID
                7. Logout"""));


        if (diaryUser == 1) lockDiary();
        if (diaryUser == 2) unlockDiary();
        if (diaryUser == 3) isLockDiary();
        if (diaryUser == 4) createEntry();
        if (diaryUser == 5) deleteEntry();
        if (diaryUser == 6) findEntryByUserName();
        if (diaryUser == 7) logout();
        if (diaryUser == 0) exit(0);
        else {
            diaryMenu();
        }

    }

    public void logout() {
        int logoutOption = JOptionPane.showConfirmDialog(null, "Click yes to log out or no to return to Diary menu");
        if (logoutOption == 0) {
            welcomeMenu();
        }
        if (logoutOption == 1) {
            diaryMenu();
        }
        if (logoutOption == 2) {
            exit(0);
        }


    }

    public void findEntryByUserName() {
        try {

            String username = prompt("Enter entry Username");
            String titled = prompt("Enter entry title");
            if (!userName.equals(username) && !title.equals(titled)) {
                display("Invalid ID");

            }
            Entry info = diary.findEntryById(username, titled);
//            Entry info = diary.findEntryForEntry(username, titled);
            diary.getDiary();
            display("Entry found");
            display(String.valueOf(info));


            diaryMenu();
        } catch (NullPointerException error) {
            display(error.getMessage());
            findEntryByUserName();
        }
        diaryMenu();
    }

    public void deleteEntry() {
        try {
            String username = prompt("Enter entry Username");
            String titled = prompt("Enter entry title");
            if (!userName.equals(username) && !title.equals(titled)) {
                display("Invalid ID");
                deleteEntry();
            }
            String info = diary.findByUserName(username);
            diary.findEntryById(username, titled);
            String confirm = prompt("You are about to delete this entry: \n" + info + "\nEnter yes to continue");

            if (confirm.equalsIgnoreCase("Yes")) {
                display(title);
                display(body);
                display("Deleting>>>>\nEntry deleted successfully");
            diary.deleteEntry(userName, title);
            }
            if (confirm.equalsIgnoreCase("No")) {
                diaryMenu();
            }
            diaryMenu();
        } catch (NullPointerException error) {
            display("Invalid details detected");
            deleteEntry();
        }
    }

    public void createEntry() {
        try {

            title = prompt("Create title");
            body = prompt("Write body");

            if (title.isEmpty() || body.isEmpty()) {
                throw new InputMismatchException("Title or body must be entered");
            }

            diary.addEntry(userName, title, body);
            diary.findByUserName(userName);

            display("Entry successfully created with title as: " +
                    "\"" + title + "\"" + "and body as: " + "\"" + body + "\"" + "on " + currentDateTime);
            diaryMenu();
        } catch (NullPointerException error) {
            display("Invalid details detected");
            createEntry();
        }
    }

    public void isLockDiary() {
        diary.unlock(userName, password);
        display("Diary is unlocked");
    }

    public void unlockDiary() {
        try {
            String security = prompt("Enter password");
            if (!this.password.equals(security)) {
                throw new NullPointerException("Invalid password");
            }
            diary.unlock(userName, security);
            display("Diary is unlocked successfully.");
            diaryMenu();
        } catch (NullPointerException error) {
            display("Invalid details detected");
            unlockDiary();
        }
    }

    public void lockDiary() {
        String username = prompt("Enter username to unlock diary");
        if (!this.userName.equals(username)) {
            throw new NullPointerException("Invalid password");
        }
            diary.lock(username);

            display("Diary is locked successfully");
            diaryMenu();
    }
    public void createAccount() {
        try {

            String user = String.valueOf(prompt("Enter username"));
            if (user.matches("\\D*")) {
                this.userName = user;
            }

            String security = prompt("Enter password");
            if (user.matches("\\D*")) {
                this.password = security;
            }
            if (user.isEmpty()) {
                display("Username cannot be blank.");
                createAccount();

            }
            if (security.isEmpty()) {
                display("Password cannot be blank.");
                createAccount();
            }

            diary.createDiary(userName, password);
            String name = "Hello " + userName + ", your account has been created successfully. You are welcome to use your diary.";

            display(name);
            diaryMenu();
        } catch (IllegalArgumentException error) {
            error.getMessage();
            createAccount();
        }
    }
    public String prompt(String message){
        return JOptionPane.showInputDialog(message);
    }
    public void display(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}
