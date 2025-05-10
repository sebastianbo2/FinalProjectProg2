package users;

import org.example.LibrarySystem;
import publications.Publication;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class User {
    protected String email;
    protected String name;
    protected int hashedPassword;

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.hashedPassword = password.hashCode();
    }

    public User(String email, String name, int hashedPassword) {
        this.email = email;
        this.name = name;
        this.hashedPassword = hashedPassword;
    }

    /**
     * view all publications of a certain type (leave empty to see all)
     * @param type the type of publications to see
     * @return a list of all publications of that type
     */
    public List<Publication> viewPublications(String type) {
        List<Publication> finalList = new ArrayList<>();

        switch (type.toLowerCase()) {
            case "novel":
                LibrarySystem.novels.forEach(finalList::add);
                break;
            case "referencebook":
                LibrarySystem.referenceBooks.forEach(finalList::add);
                break;
            case "magazine":
                LibrarySystem.magazines.forEach(finalList::add);
                break;
            default:
                LibrarySystem.novels.forEach(finalList::add);
                LibrarySystem.referenceBooks.forEach(finalList::add);
                LibrarySystem.magazines.forEach(finalList::add);
        }

        return finalList;
    }

    /**
     * search for a publication by title
     * @param title the title to search for
     * @return a list of publications with that title
     */
    public List<Publication> search(String title) {
        List<Publication> validPublications = new ArrayList<>();

        LibrarySystem.novels.forEach((novel) -> {
            if (novel.getTitle().equalsIgnoreCase(title)) {
                validPublications.add(novel);
            };
        });

        LibrarySystem.referenceBooks.forEach((referenceBook) -> {
            if (referenceBook.getTitle().equalsIgnoreCase(title)) {
                validPublications.add(referenceBook);
            };
        });

        return validPublications;
    }

    /**
     * search for a publication by title and author
     * @param title the title for search for
     * @param author the author to search for
     * @return a list of publications that have that title and author
     */
    public List<Publication> search(String title, String author) {
        List<Publication> validPublications = new ArrayList<>();

        LibrarySystem.novels.forEach((novel) -> {
            if (novel.getTitle().equalsIgnoreCase(title)) {
                validPublications.add(novel);
            };
        });

        LibrarySystem.referenceBooks.forEach((novel) -> {
            if (novel.getTitle().equalsIgnoreCase(title)) {
                validPublications.add(novel);
            };
        });

        return validPublications.stream().filter(publication -> publication.getAuthor().equals(author)).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return hashedPassword == user.hashedPassword && Objects.equals(email, user.email) && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, hashedPassword);
    }

    @Override
    public String toString() {
        return "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", hashedPassword=" + hashedPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(int hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
