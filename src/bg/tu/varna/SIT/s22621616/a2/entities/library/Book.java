package bg.tu.varna.SIT.s22621616.a2.entities.library;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.User;

public interface Book {
    /**
     * Create a book with user input
     * @param user User object 
     * @return new Book(...)
     */

    BookStructure build(User user);

    void bookInfo(String id, User user);
}
