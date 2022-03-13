package Data;

import java.io.Serializable;

public class User implements Serializable {

    private String username;
    private String password;
    private Role role;

    public User(String username, String password, String role){
        this.username = username;
        this.password = password;
        if(role.equals("EMPLOYEE")){
            this.role = Role.EMPLOYEE;
        }
        if(role.equals("ADMINISTRATOR")){
            this.role = Role.ADMINISTRATOR;
        }
        if(role.equals("CLIENT")){
            this.role = Role.CLIENT;
        }
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
