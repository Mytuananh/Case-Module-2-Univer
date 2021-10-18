package cotroller.studentmanager;

import model.stduents.Freshman;

import java.util.ArrayList;

public class FreshmanManager {
    ArrayList<Freshman> freshmanArrayList = new ArrayList<>();

    public FreshmanManager(ArrayList<Freshman> freshmanArrayList) {
        this.freshmanArrayList = freshmanArrayList;
    }

    public FreshmanManager() {

    }

    public ArrayList<Freshman> getFreshmanArrayList() {
        return freshmanArrayList;
    }

    public void addNewStudent(Freshman freshman) {
        freshmanArrayList.add(freshman);
    }

    public void removeStudent(int index) {
        freshmanArrayList.remove(index);
    }

    public void setFreshmanArrayList(int index, Freshman freshman) {
        freshmanArrayList.set(index, freshman);
    }

    public Freshman searchStudent(String codeStudent) {
        Freshman freshman = null;
        for (int i = 0; i < freshmanArrayList.size(); i++) {
            if (freshmanArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                freshman = getFreshmanArrayList().get(i);
                break;
            }
        }
        return freshman;
    }


}
