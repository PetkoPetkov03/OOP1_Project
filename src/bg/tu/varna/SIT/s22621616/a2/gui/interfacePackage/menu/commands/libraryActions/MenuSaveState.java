package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.libraryActions;

import bg.tu.varna.SIT.s22621616.a2.api.library.BookStructure;
import bg.tu.varna.SIT.s22621616.a2.api.library.LibraryInstance;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Pair;
import bg.tu.varna.SIT.s22621616.a2.api.libs.State;
import bg.tu.varna.SIT.s22621616.a2.api.libs.Tokenizer;
import bg.tu.varna.SIT.s22621616.a2.api.authorization.User;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.api.database.FileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MenuSaveState implements MenuState {
    /**
     * execute command depending on the menu state.
     *
     * @param tokenizer
     * @param user
     */
    @Override
    public void execute(Tokenizer tokenizer, User user) {
        List<BookStructure> books = LibraryInstance.getInstance().getLibrary().getBooks();

        FileManager fileManager = InterfaceInstance.getInstance().getFileManager();

        Pair<File, File> files = fileManager.getDatabases();

        File booksDatabase = files.optArg();

        try (FileWriter writer = new FileWriter(booksDatabase, false)) {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<List>\n");

            writer.write("  <Books>\n");
            for(BookStructure book : books) {
                writer.write("  <Book>");
                writer.write("   <ID>"+book.getId()+"</ID>\n");
                writer.write("   <Title>"+book.getTitle()+"</Title>\n");
                writer.write("   <Author>"+book.getAuthor()+"</Author>\n");
                writer.write("   <Rating>"+book.getRating()+"</Rating>\n");
                writer.write("   <Description>"+book.getDescription()+"</Description>\n");
                writer.write("   <YearOfRelease>"+book.getYearOfRelease()+"</YearOfRelease>\n");
                writer.write("   <Genre>"+book.getGenre()+"</Genre>\n");

                writer.write("   <Keywords>");
                for(int i = 0; i < book.getKeywords().size(); i++) {
                    if(i > 0 && i < book.getKeywords().size()-1) {
                        writer.write(",");
                    }
                    writer.write(book.getKeywords().get(i).name());
                }
                writer.write("   </Keywords>\n");
                writer.write("  </Book>\n");
            }
            writer.write("  </Books>\n");
            writer.write("</List>\n");

    }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * @return MenuState instance
     */
    @Override
    public State getState() {
        return null;
    }

    @Override
    public Enum<?> getImportance() {
        return null;
    }
}
