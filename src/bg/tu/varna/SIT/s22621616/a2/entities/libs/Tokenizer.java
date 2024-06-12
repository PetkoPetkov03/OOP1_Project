package bg.tu.varna.SIT.s22621616.a2.entities.libs;

import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuOptions;

import java.util.*;

public class Tokenizer {
    MenuOptions option;
    List<String> tokens;

    public Tokenizer() {
         tokens = new ArrayList<>();
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

    public void parse(String input) {

        String[] args = input.split(" ");

        Pair<MenuOptions, String[]> menuOptionsPair = findOption(args);
        this.option = menuOptionsPair.mainArg();

        args = menuOptionsPair.optArg();

        if(this.option == null) {
            throw new InputMismatchException("Option not found");
        }

        this.tokens = List.of(args);
    }

    public MenuOptions getOption() {
        return option;
    }

    public List<String> getTokens() {
        return tokens;
    }
}
