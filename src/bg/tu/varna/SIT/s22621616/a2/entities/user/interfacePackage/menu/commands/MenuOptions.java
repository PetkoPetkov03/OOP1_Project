package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.MenuState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.State;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions.*;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuDisplayHelpState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuExitState;

public enum MenuOptions implements State {
    OPEN {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = null;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return null;
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    CLOSE {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private State getInstance() {
            return null;
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    SAVE {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = null;

        public Authorization getAuthorization() {
            return authorization;
        }
        private State getInstance() {
            return null;
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    SAVE_AS {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = null;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return null;
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    HELP {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = null;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return new MenuDisplayHelpState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    EXIT {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = null;

        public Authorization getAuthorization() {
            return authorization;
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

        private final Authorization authorization = Authorization.ADMIN;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return new MenuAddBookState();
        }

        /**
         * @return State instance
         */
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },
    BOOKS_ALL {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = Authorization.BASIC;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return new MenuDisplayBooksState();
        }

        /**
         * @return State instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },

    BOOKS_INFO {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = Authorization.BASIC;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return new MenuBookInfo();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },

    BOOKS_SORT {
        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        private final Authorization authorization = Authorization.BASIC;

        public Authorization getAuthorization() {
            return authorization;
        }

        private State getInstance() {
            return new MenuSortBooksState();
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            return (MenuState) getInstance();
        }
    },

    BOOKS_FIND {

        private final Authorization authorization = Authorization.BASIC;

        public Authorization getAuthorization() {
            return authorization;
        }

        @Override
        public CommandImportance getImportance() {
            return CommandImportance.PRIMARY;
        }

        /**
         * @return MenuState instance
         */
        @Override
        public MenuState getState() {
            return new MenuFindBookByPerimeter();
        }
    }
}
