package users;

public class Librarian extends User {
    public Librarian(String email, String name, String password) {
        super(email, name, password);
    }

    @Override
    public String toString() {
        return "Librarian{" + super.toString() + "}";
    }
}
