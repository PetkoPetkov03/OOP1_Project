package bg.tu.varna.SIT.s22621616.a2.entities.libs;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.Command;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.MenuOptions;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.SubCommands;

import java.util.*;

public class Tokenizer {

    List<Command> commands;
    List<String> inputs;

    public Tokenizer() {
          commands = new ArrayList<>();
          inputs = new ArrayList<>();
    }

    private Pair<MenuOptions, String[]> findOption(String[] inputArgs) {
        MenuOptions option = null;

        StringBuilder buffer = new StringBuilder();

        for(int i = 0; i < inputArgs.length; i++) {
            if(i > 0) {
                buffer.append(" ");
            }
            buffer.append(inputArgs[i]);

            option = Translator.translateUserStringToEnum(MenuOptions.class, buffer.toString());

            if(option != null) {
                inputArgs = Arrays.copyOfRange(inputArgs, i+1, inputArgs.length);
                break;
            }
        }

        return new Pair<>(option, inputArgs);
    }

    private Pair<List<SubCommands>, String[]> findSubCommands(String[] inputArgs) {
        List<SubCommands> subCommands = new ArrayList<>();

        StringBuilder buffer = new StringBuilder();

        String[] newInput = null;
        for (int i = 0; i < inputArgs.length; i++) {
            if (i > 0) {
                buffer.append(" ");
            }
            SubCommands subCommand = Translator.translateUserStringToEnum(SubCommands.class, inputArgs[i]);

            if(subCommand == null) {
                buffer.append(inputArgs[i]);
            }else {
                subCommands.add(subCommand);
            }

            newInput = buffer.toString().split(" ");
        }

        return new Pair<>(subCommands, newInput);
    }

    public void parse(String input) {

        String[] args = input.split(" ");

        Pair<List<SubCommands>, String[]> subCommandsPair = findSubCommands(args);
        commands.addAll(subCommandsPair.mainArg());
        args = subCommandsPair.optArg();

        Pair<MenuOptions, String[]> menuOptionsPair = findOption(args);
        this.commands.add(menuOptionsPair.mainArg());

        args = menuOptionsPair.optArg();

        if(!optionParsed()) {
            throw new InputMismatchException("Option not found");
        }

        this.inputs.addAll(List.of(args));
    }

    private boolean optionParsed() {
        boolean flag = false;

        for(Command command : commands) {
            if(command.getImportance() == 0) {
                flag = true;
            }
        }

        return flag;
    }

    public MenuOptions getCommand() {
        Command command = null;
        for(Command command1 : commands) {
            if(command1.getImportance() == 0) {
                command = command1;
            }
        }

        return (MenuOptions) command;
    }

    public List<SubCommands> getSubCommands() {
        List<SubCommands> subCommands = new ArrayList<>();
        for(Command command : commands) {
            if(command.getImportance() == 1) {
                subCommands.add((SubCommands) command);
            }
        }

        return subCommands;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public void clear() {
        commands.clear();
        inputs.clear();
    }
}
