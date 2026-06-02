
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Users {
    private String name;
    private String surname;
    private String UUID;
    private TreeMap<String, String> users = new TreeMap<>();
    private TreeSet<Workspace> workspaces = new TreeSet<>();

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Users(String name, String surname, String UUID) {
        this.name = name;
        this.surname = surname;
        this.UUID = UUID;
    }

    @Override
    public String toString() {
        return "Users{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    boolean isUserInSystem(String surname) {
        return users.containsKey(surname);
    }


    void bookWorkspace(Workspace workspace) {
        workspaces.add(workspace);
        System.out.println("Место " + workspace.getType() + " " + workspace.getNumber() + " забронировано пользователем " + getSurname() + " " + getName());
    }

    void cancelBooking(Workspace workspace) {
        if (workspaces.contains(workspace)) {
            workspaces.remove(workspace);
            System.out.println("Пользователь " + getSurname() + " " + getName() + " отменил бронь места " + workspace.getType() + " " + workspace.getNumber());
        } else {
            System.out.println("У пользователя нет брони на это место");
        }
    }
    void sortUsers() {
        Comparator<Users> usersComparator = Comparator.comparing(Users::getName).thenComparing(Users::getSurname);
    }
}