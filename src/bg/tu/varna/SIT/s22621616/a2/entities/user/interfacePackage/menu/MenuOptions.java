package bg.tu.varna.SIT.s22621616.a2.entities.user.interfacePackage.menu;

public enum MenuOptions implements State {
    OPEN {
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
    ADD_A_BOOK {
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
    SHOW {
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
}
