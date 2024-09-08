package bg.tu.varna.SIT.s22621616.a2.api.database;

import bg.tu.varna.SIT.s22621616.a2.api.library.BookStructure;
import bg.tu.varna.SIT.s22621616.a2.api.library.Genre;
import bg.tu.varna.SIT.s22621616.a2.api.library.Keywords;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Translator;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The XMLLibParser class handles parsing and writing XML data for books and users.
 * This class provides methods for reading book and user data from XML files,
 * adding new entries to these files, and converting objects into their XML representation.
 *
 * <p>Key functionalities include:</p>
 * <ul>
 *     <li>Parsing XML files to extract lists of BookStructure and User objects.</li>
 *     <li>Adding new BookStructure and User objects to existing XML files.</li>
 *     <li>Removing users from the XML files.</li>
 *     <li>Converting BookStructure and User objects into XML format for storage.</li>
 * </ul>
 */
public class XMLLibParser {

    /**
     * Parses an XML file containing book data and returns a list of BookStructure objects.
     *
     * @param xmlFile The XML file containing book data.
     * @return A list of BookStructure objects parsed from the XML file.
     */
    public static List<BookStructure> parseBooksXML(File xmlFile) {
        List<BookStructure> bookList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(xmlFile);
             Scanner scanner = new Scanner(fis)) {
            StringBuilder xmlContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                xmlContent.append(scanner.nextLine().trim());
            }

            String xml = xmlContent.toString();
            int startIndex = 0;
            while ((startIndex = xml.indexOf("<Book>", startIndex)) != -1) {
                int endIndex = xml.indexOf("</Book>", startIndex) + "</Book>".length();
                String bookXml = xml.substring(startIndex, endIndex);
                BookStructure book = parseBook(bookXml);
                bookList.add(book);
                startIndex = endIndex;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return bookList;
    }

    private static BookStructure parseBook(String bookXml) {
        BookStructure book = new BookStructure();
        book.setId(getTagValue("ID", bookXml));
        book.setTitle(getTagValue("Title", bookXml));
        book.setAuthor(getTagValue("Author", bookXml));
        book.setRating(Double.parseDouble(getTagValue("Rating", bookXml)));
        book.setDescription(getTagValue("Description", bookXml));
        book.setYearOfRelease(Integer.parseInt(getTagValue("YearOfRelease", bookXml)));
        book.setGenre(Genre.valueOf(getTagValue("Genre", bookXml)));

        String keywordsStr = getTagValue("Keywords", bookXml);
        List<Keywords> keywords = new ArrayList<>();
        for (String keyword : keywordsStr.split(",")) {
            keyword = keyword.trim();
            if (!keyword.isEmpty()) {
                keywords.add(Translator.translateUserStringToEnum(Keywords.class, keyword));
            }
        }
        book.setKeywords(keywords);

        return book;
    }

    /**
     * Adds a new BookStructure object to an existing XML file containing book data.
     *
     * @param xmlFile The XML file to add the new book to.
     * @param newBook The new BookStructure object to add.
     */
    public static void addBookToXML(File xmlFile, BookStructure newBook) {
        List<BookStructure> bookList = parseBooksXML(xmlFile);
        bookList.add(newBook);
        writeBooksToXML(xmlFile, bookList);
    }

    /**
     * Writes a list of BookStructure objects to an XML file containing book data.
     *
     * @param xmlFile  The XML file to write to.
     * @param bookList The list of BookStructure objects to write to the XML file.
     */
    private static void writeBooksToXML(File xmlFile, List<BookStructure> bookList) {
        try (FileWriter writer = new FileWriter(xmlFile, false)) {
            writer.write("<Books>\n");
            for (BookStructure book : bookList) {
                writer.write(bookToXML(book));
            }
            writer.write("</Books>\n");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Converts a BookStructure object to XML format.
     *
     * @param book The BookStructure object to convert.
     * @return The XML string representation of the BookStructure object.
     */
    private static String bookToXML(BookStructure book) {
        StringBuilder xml = new StringBuilder();
        xml.append("<Book>\n");
        xml.append("<ID>").append(book.getId()).append("</ID>\n");
        xml.append("<Title>").append(book.getTitle()).append("</Title>\n");
        xml.append("<Author>").append(book.getAuthor()).append("</Author>\n");
        xml.append("<Rating>").append(book.getRating()).append("</Rating>\n");
        xml.append("<Description>").append(book.getDescription()).append("</Description>\n");
        xml.append("<YearOfRelease>").append(book.getYearOfRelease()).append("</YearOfRelease>\n");
        xml.append("<Genre>").append(book.getGenre()).append("</Genre>\n");
        xml.append("<Keywords>").append(String.join(",", book.getKeywords().stream().map(Keywords::toString).toArray(String[]::new))).append("</Keywords>\n");
        xml.append("</Book>\n");
        return xml.toString();
    }

    /**
     * Parses an XML file containing user data and returns a list of User objects.
     *
     * @param xmlFile The XML file containing user data.
     * @return A list of User objects parsed from the XML file.
     */
    public static List<User> parseUsersXML(File xmlFile) {
        List<User> userList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(xmlFile);
             Scanner scanner = new Scanner(fis)) {
            StringBuilder xmlContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                xmlContent.append(scanner.nextLine().trim());
            }

            String xml = xmlContent.toString();
            int startIndex = 0;
            while ((startIndex = xml.indexOf("<User>", startIndex)) != -1) {
                int endIndex = xml.indexOf("</User>", startIndex) + "</User>".length();
                String userXml = xml.substring(startIndex, endIndex);
                User user = parseUser(userXml);
                userList.add(user);
                startIndex = endIndex;
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }

        return userList;
    }

    /**
     * Removes a user by their username from the XML file.
     *
     * @param xmlFile The XML file containing user data.
     * @param username The username of the user to remove.
     * @return true if the user was successfully removed, false if the user was not found.
     */
    public static boolean removeUserFromXML(File xmlFile, String username) {
        List<User> userList = parseUsersXML(xmlFile);
        boolean userRemoved = userList.removeIf(user -> user.getUsername().equals(username));
        if (userRemoved) {
            writeUsersToXML(xmlFile, userList);
        }
        return userRemoved;
    }

    /**
     * Adds a new User object to an existing XML file containing user data.
     *
     * @param xmlFile The XML file to add the new user to.
     * @param newUser The new User object to add.
     */
    public static void addUserToXML(File xmlFile, User newUser) {
        List<User> userList = parseUsersXML(xmlFile);
        userList.add(newUser);
        writeUsersToXML(xmlFile, userList);
    }

    /**
     * Writes a list of User objects to an XML file containing user data.
     *
     * @param xmlFile  The XML file to write to.
     * @param userList The list of User objects to write to the XML file.
     */
    private static void writeUsersToXML(File xmlFile, List<User> userList) {
        try (FileWriter writer = new FileWriter(xmlFile, false)) {
            writer.write("<Users>\n");
            for (User user : userList) {
                writer.write(userToXML(user));
            }
            writer.write("</Users>\n");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Converts a User object to XML format.
     *
     * @param user The User object to convert.
     * @return The XML string representation of the User object.
     */
    private static String userToXML(User user) {
        StringBuilder xml = new StringBuilder();
        xml.append("<User>\n");
        xml.append("<Username>").append(user.getUsername()).append("</Username>\n");
        xml.append("<Password>").append(user.getPassword()).append("</Password>\n");
        xml.append("<Auth>").append(user.getAuthorization()).append("</Auth>\n");
        xml.append("</User>\n");
        return xml.toString();
    }

    private static User parseUser(String userXml) {
        return new User(getTagValue("Username", userXml), getTagValue("Password", userXml), Authorization.valueOf(getTagValue("Auth", userXml)));
    }

    /**
     * Parses a specific XML tag value from an XML string.
     *
     * @param tag The XML tag to parse.
     * @param xml The XML string containing the tag.
     * @return The value of the specified XML tag.
     */
    private static String getTagValue(String tag, String xml) {
        String startTag = "<" + tag + ">";
        String endTag = "</" + tag + ">";
        int startIndex = xml.indexOf(startTag) + startTag.length();
        int endIndex = xml.indexOf(endTag);
        return xml.substring(startIndex, endIndex).trim();
    }
}
