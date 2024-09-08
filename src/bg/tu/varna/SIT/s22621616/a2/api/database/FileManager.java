package bg.tu.varna.SIT.s22621616.a2.api.database;

import bg.tu.varna.SIT.s22621616.a2.api.libs.Pair;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The FileManager class handles operations related to user and library database files.
 * It provides functionality for opening, creating, and managing the XML-based databases
 * that store user information and library data. The class ensures that necessary default
 * data is initialized in the user database when it is created for the first time.
 *
 * <p>Key functionalities include:</p>
 * <ul>
 *     <li>Opening and initializing the user database file.</li>
 *     <li>Creating or opening the library database file.</li>
 *     <li>Retrieving a pair of user and library database files.</li>
 *     <li>Closing the FileManager and releasing resources.</li>
 * </ul>
 */
public class FileManager {
    private File userDatabase;
    private File libraryDatabase;

    /**
     * Creates or opens a user database file and initializes it with default data if it does not exist.
     *
     * @param path The path of the user database file.
     */
    public void openUserDatabaseFile(String path) {
        userDatabase = new File(path);

        if (!userDatabase.exists()) {
            try {
                userDatabase.createNewFile();

                try (FileWriter writer = new FileWriter(userDatabase, false)) {
                    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
                    writer.write("<List>\n");
                    writer.write(" <Users>\n");
                    writer.write("      <User>\n");
                    writer.write("          <Username>admin</Username>\n");
                    writer.write("          <Password>i3c++</Password>\n");
                    writer.write("           <Auth>ADMIN</Auth>\n");
                    writer.write("      </User>\n");
                    writer.write("  </Users>\n");
                    writer.write("</List>");
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Creates or opens a library database file if it does not exist.
     *
     * @param path The path of the library database file.
     */
    public void openLibraryDatabase(String path) {
        libraryDatabase = new File(path);

        if (!libraryDatabase.exists()) {
            try {
                libraryDatabase.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Library database couldn't initialize!", e);
            }
        }
    }

    /**
     * Retrieves the user database file and library database file pair.
     *
     * @return A Pair containing the user database file and library database file.
     */
    public Pair<File, File> getDatabases() {
        return new Pair<>(userDatabase, libraryDatabase);
    }

    /**
     * Closes the FileManager by clearing references to the user database and library database files.
     */
    public void close() {
        this.userDatabase = null;
        this.libraryDatabase = null;
    }
}
