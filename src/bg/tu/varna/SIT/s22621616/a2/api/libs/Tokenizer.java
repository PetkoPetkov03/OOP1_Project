package bg.tu.varna.SIT.s22621616.a2.api.libs;

import bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Tokenizer class is responsible for parsing user input into commands and arguments.
 * It identifies primary commands, subcommands, and input parameters, enabling
 * the execution of actions based on user input.
 */
public class Tokenizer {

    private List<Command> commands;
    private List<String> inputs;
    private boolean emCleared;

    /**
     * Initializes a new Tokenizer instance with empty command and input lists.
     */
    public Tokenizer() {
        commands = new ArrayList<>();
        inputs = new ArrayList<>();
        emCleared = false;
    }

    /**
     * Finds the primary menu option from the given input arguments.
     *
     * @param inputArgs The array of input arguments provided by the user.
     * @return A Pair containing the identified MenuOption and remaining input arguments.
     */
    private Pair<MenuOptions, String[]> findOption(String[] inputArgs) {
        MenuOptions option = null;
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < inputArgs.length; i++) {
            if (i > 0) {
                buffer.append(" ");
            }
            buffer.append(inputArgs[i]);

            option = Translator.translateUserStringToEnum(MenuOptions.class, buffer.toString());

            if (option != null) {
                inputArgs = Arrays.copyOfRange(inputArgs, i + 1, inputArgs.length);
                break;
            }
        }

        return new Pair<>(option, inputArgs);
    }

    /**
     * Finds subcommands from the provided input arguments.
     *
     * @param inputArgs The array of input arguments provided by the user.
     * @return A Pair containing a list of identified SubCommands and remaining input arguments.
     */
    private Pair<List<SubCommands>, String[]> findSubCommands(String[] inputArgs) {
        List<SubCommands> subCommands = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        String[] newInput = null;

        for (int i = 0; i < inputArgs.length; i++) {
            if (i > 0) {
                buffer.append(" ");
            }
            SubCommands subCommand = Translator.translateUserStringToEnum(SubCommands.class, inputArgs[i]);

            if (subCommand == null) {
                buffer.append(inputArgs[i]);
            } else {
                subCommands.add(subCommand);
            }

            newInput = buffer.toString().split(" ");
        }

        return new Pair<>(subCommands, newInput);
    }

    /**
     * Parses the provided input string into commands and arguments.
     *
     * @param input The input string provided by the user.
     */
    public void parse(String input) {
        String[] args = input.split(" ");

        Pair<List<SubCommands>, String[]> subCommandsPair = findSubCommands(args);
        commands.addAll(subCommandsPair.mainArg());
        args = subCommandsPair.optArg();

        Pair<MenuOptions, String[]> menuOptionsPair = findOption(args);
        commands.add(menuOptionsPair.mainArg());
        args = menuOptionsPair.optArg();

        // Remove empty strings from inputs
        while (inputs.contains("")) {
            inputs.remove("");
        }

        inputs.addAll(List.of(args));
        inputs.removeIf(String::isEmpty);
    }

    /**
     * Retrieves the primary command from the list of commands.
     *
     * @return The identified MenuOptions command or null if none found.
     */
    public MenuOptions getCommand() {
        Command command = null;

        for (Command command1 : commands) {
            if (command1 != null && command1.getImportance().equals(CommandImportance.PRIMARY)) {
                command = command1;
            }
        }

        return (MenuOptions) command;
    }

    /**
     * Retrieves the first secondary command from the list of commands.
     *
     * @return The identified SubCommands command or null if none found.
     */
    public SubCommands getSubCommand() {
        SubCommands subCommand = null;

        for (Command command : commands) {
            if (command.getImportance().equals(CommandImportance.SECONDARY)) {
                subCommand = (SubCommands) command;
                break;
            }
        }

        return subCommand;
    }

    /**
     * Retrieves the first instructional command from the list of commands.
     *
     * @return The identified SubCommands command or null if none found.
     */
    public SubCommands getInstrCommand() {
        SubCommands subCommand = null;

        for (Command command : commands) {
            if (command.getImportance().equals(CommandImportance.INSTRUCTIONAL)) {
                subCommand = (SubCommands) command;
                break;
            }
        }

        return subCommand;
    }

    /**
     * Retrieves the list of input arguments.
     *
     * @return A list of input strings provided by the user.
     */
    public List<String> getInputs() {
        return inputs;
    }

    /**
     * Checks if the EM cleared flag has been set and resets it.
     *
     * @return true if the EM cleared flag was set, false otherwise.
     */
    public boolean isEmCleared() {
        boolean flag = emCleared;
        emCleared = false;
        return flag;
    }

    /**
     * Clears the commands and inputs. If emCleared is true, sets the EM cleared flag.
     *
     * @param emCleared Indicates whether to set the EM cleared flag.
     */
    public void clear(boolean emCleared) {
        if (emCleared) {
            this.emCleared = true;
        }
        commands.clear();
        inputs.clear();
    }
}
