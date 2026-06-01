public interface AccountingForArmor {
    void markAsBooked(Users users, int numbers);
    void markAsAvailable(int numbers, Users users);
    boolean isAvabled(int numbers);
}
