package cotroller.studentmanager;

import model.stduents.Sophomore;

import java.util.ArrayList;

public class SophomoreManager {
    ArrayList<Sophomore> sophomoreArrayList = new ArrayList<>();

    public SophomoreManager(ArrayList<Sophomore> sophomoreArrayList) {
        this.sophomoreArrayList = sophomoreArrayList;
    }

    public SophomoreManager() {

    }

    public ArrayList<Sophomore> getSophomoreArrayList() {
        return sophomoreArrayList;
    }

    public void addNewStudent(Sophomore sophomore) {
        sophomoreArrayList.add(sophomore);
    }

    public void removeStudent(int index) {
        sophomoreArrayList.remove(index);
    }

    public void setSophomoreArrayList(int index, Sophomore sophomore) {
        sophomoreArrayList.set(index, sophomore);
    }

    public Sophomore searchStudent(String codeStudent) {
        Sophomore sophomore = null;
        for (int i = 0; i < sophomoreArrayList.size(); i++) {
            if (sophomoreArrayList.get(i).getCodeStudent().equals(codeStudent)) {
                sophomore = getSophomoreArrayList().get(i);
                break;
            }
        }
        return sophomore;
    }
}
