package bg.tu.varna.SIT.s22621616.a2.api.library;

import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;

/**
 * The Book interface defines the operations related to creating and managing book information.
 */
public interface Book {

    /**
     * Builds a new book structure based on user input.
     *
     * @param user The {@link User} object providing input for the book creation.
     * @return A newly created {@link BookStructure} based on the provided user input.
     */
    BookStructure build(User user);

    /**
     * Displays information about a book specified by its ID.
     *
     * @param id   The unique identifier of the book.
     * @param user The {@link User} object requesting the book information.
     */
    void bookInfo(String id, User user);
}

