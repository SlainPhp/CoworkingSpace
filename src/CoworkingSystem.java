import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class CoworkingSystem {
    private TreeSet<Users> usersList = new TreeSet<>();
    private TreeSet<Workspace> listWorkingspaces = new TreeSet<>();
    private TreeMap<Users,TreeSet<Workspace>>accountingForArmor = new TreeMap<>();

    public void addWorkspace(Workspace workspace) {
    listWorkingspaces.add(workspace);
        System.out.println("Добавлено место " + workspace.getType() + " " + workspace.getNumber()) ;
    }
    public void removeWorkspace(Workspace workspace) {
    listWorkingspaces.remove(workspace);
        System.out.println("Место " + workspace.getType() + " " + workspace.getNumber() + " удалено");
    }
    public void registerUser(Users users) {
        usersList.add(users);
        System.out.println("Зарегестрирован пользователь " + users.getSurname() + " " + users.getName());

    }
    public void canselBooking(Users users, Workspace workspace){
    accountingForArmor.remove(users, workspace);
        System.out.println("Пользователь " + users.getSurname() + " " + users.getName() + " отменяет бронь " + workspace.getType() + " N " + workspace.getNumber());
    }
    public void listOfAvailablePlaces() {
        System.out.println("Список доступных мест:");
        for(Workspace freePlaces : listWorkingspaces ) {
            System.out.println(freePlaces.getNumber() + " " + freePlaces.getType());
        }
    }
}
