package bg.tu.varna.SIT.s22621616.a2.gui.interfacePackage.menu.commands;

public enum SubCommands implements Command {
    ASC {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.INSTRUCTIONAL;
        }
    },
    DESC {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.INSTRUCTIONAL;
        }
    },
    TITLE {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.SECONDARY;
        }
    },
    AUTHOR {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.SECONDARY;
        }
    },
    TAG {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.SECONDARY;
        }
    }
}
