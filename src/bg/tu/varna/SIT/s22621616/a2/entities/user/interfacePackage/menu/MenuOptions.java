package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

import bg.tu.varna.SIT.s22621616.a2.entities.user.authorization.Authorization;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions.MenuAddBookState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions.MenuBookInfo;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.bookActions.MenuDisplayBooksState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuDisplayHelpState;
import bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu.commands.interfaceActions.MenuExitState;

public enum MenuOptions implements State {
    OPEN {
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
    }
}
