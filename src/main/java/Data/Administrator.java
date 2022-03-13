package Data;


import Business.MenuItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Administrator extends User implements Serializable {

    private int adminID;
    private static int id = 1;
    private List<MenuItem> composeList;

    public Administrator(String username, String password){
        super(username, password, "ADMINISTRATOR");
        this.adminID = id ++;
        composeList = new ArrayList<MenuItem>();
    }

    public int getAdminID() {
        return adminID;
    }

    public void addToComposeList(MenuItem menuItem){
        composeList.add(menuItem);
    }

    public List<MenuItem> getComposeList(){
        return this.composeList;
    }

    public void deleteComposeList(){
        this.composeList = new ArrayList<MenuItem>();
    }

}
