package cotroller.management;

import model.user.User;
import storage.userText.UserFile;

import java.io.IOException;
import java.util.ArrayList;

public class ManagerUser {
    ArrayList<User> userArrayList = new ArrayList<>();
    UserFile userFile = UserFile.getInstance();
    private static final ManagerUser managerUser = new ManagerUser();
    private ManagerUser() {
    }

    public static ManagerUser getInstance() {
        return managerUser;
    }

    public ManagerUser(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public ArrayList<User> getUserArrayList() {
        return userArrayList;
    }

    public void setUserArrayList(ArrayList<User> userArrayList) {
        this.userArrayList = userArrayList;
    }

    public void addNewUser(User user) {
        userArrayList.add(user);
        try {
            userFile.writeFile(userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(int index) {
        userArrayList.remove(index);
    }

    public void editUser(int index, User user) {
        userArrayList.set(index, user);
    }

    public User findUser(String username) {
        User user = null;
        for (User value : userArrayList) {
            if (value.getAccount().equalsIgnoreCase(username)) {
                user = value;
                break;
            }
        }
        return user;
    }


    public boolean isLogin(User userLogin) {
        for (User user : userArrayList) {
            if (user.getAccount().equals(userLogin.getAccount())
                    && user.getPassWord().equals(userLogin.getPassWord())) {
                return true;
            }
        }
        return false;
    }
}