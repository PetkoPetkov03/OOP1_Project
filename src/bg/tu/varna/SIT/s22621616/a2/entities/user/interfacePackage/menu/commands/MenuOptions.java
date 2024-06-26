package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.InterfaceInstance;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.entities.libs.State;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions.*;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuCloseFilesState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuDisplayHelpState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuExitState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuOpenFilesState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.userActions.LoginState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.userActions.LogoutState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.userActions.RegisterState;

public enum MenuOptions implements State {
    OPEN {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new MenuOpenFilesState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return getInstance();
        }
    },
    CLOSE {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new MenuCloseFilesState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return getInstance();
        }
    },
    SAVE {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new MenuSaveState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return getInstance();
        }
    },
    SAVE_AS {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return null;
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return getInstance();
        }
    },
    HELP {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new MenuDisplayHelpState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return getInstance();
        }
    },
    EXIT {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }


        private State getInstance() {
            return new MenuExitState();
        }

        /**
         * @return State instance
         */
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    BOOKS_ADD {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }


        private MenuState getInstance() {
            return new MenuAddBookState();
        }

        /**
         * @return State instance
         */
        public MenuState getState() {
            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() != Authorization.ADMIN){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return getInstance();
        }
    },
    BOOKS_ALL {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new MenuDisplayBooksState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {

            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() == null){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return getInstance();
        }
    },

    BOOKS_INFO {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private State getInstance() {
            return new MenuBookInfo();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() == null){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return (MenuState) getInstance();
        }
    },

    BOOKS_SORT {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private State getInstance() {
            return new MenuSortBooksState();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() == null){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return (MenuState) getInstance();
        }
    },

    BOOKS_FIND {

        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() == null){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return new MenuFindBookByPerimeter();
        }
    },
    REGISTER {
        private final Authorization authorization = Authorization.ADMIN;
        @Override
        public Enum<?> getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new RegisterState();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();
            if(interfaceInstance.getUser().getAuthorization() != authorization){
                System.out.println("You aren't authorized to run this command!");
                return null;
            }
            return getInstance();
        }
    },

    LOGIN {
        @Override
        public Enum<?> getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new LoginState();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {

            return getInstance();
        }
    },

    LOGOUT {
        @Override
        public Enum<?> getImportance() {
            return CommandImportance.PRIMARY;
        }

        private MenuState getInstance() {
            return new LogoutState();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public State getState() {
            return getInstance();
        }
    }
}
