package duke.clients;

import duke.tasks.Task;

import java.util.ArrayList;

public class Client {
    private String name;
    private String email;
    private String phone;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return " Client: " + name + " (email: " + email + ", phone: " + phone + ")";
    }
}
