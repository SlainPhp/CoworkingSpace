import java.util.HashMap;

public class Workspace implements Comparable<Workspace>, AccountingForArmor {
    public int number;
    public Type type;
    public HashMap<Integer, Type> freeWorkspaces = new HashMap<>();
    public HashMap<Integer, Type> bookedWorkspaces = new HashMap<>();

    public Workspace(int number, Type type) {
        this.number = number;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean isAvabled(int number) {
        return freeWorkspaces.containsKey(number);
    }


    @Override
    public void markAsBooked(Users user, int number) {
        if (!isAvabled(number)) {
            System.out.println("Это место занято");
        }
        System.out.println(user.getSurname() + " " + user.getName() + " бронирует рабочее место N" + number);
        bookedWorkspaces.put(number, freeWorkspaces.get(number));
        freeWorkspaces.remove(number);
    }

    @Override
    public void markAsAvailable(int number, Users users) {
        if (bookedWorkspaces.containsKey(number)) {
            freeWorkspaces.put(number, bookedWorkspaces.get(number));
            bookedWorkspaces.remove(number);
            System.out.println(users.getSurname() + " " + users.getName() + " отменяет бронирование рабочего места N" + number);
        } else {
            System.out.println("Это место не забронировано");
        }
    }

    @Override
    public String toString() {
        return "Workspace{" +
                "number=" + number +
                ", type=" + type +
                '}';
    }

    @Override
    public int compareTo(Workspace o) {
        return Integer.compare(this.number, o.number);
    }
}