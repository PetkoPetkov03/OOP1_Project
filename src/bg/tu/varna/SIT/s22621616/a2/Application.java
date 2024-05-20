package bg.tu.varna.SIT.s22621616.a2;

import bg.tu.varna.SIT.s22621616.a2.entities.singletons.InterfaceInstance;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {

        InterfaceInstance interfaceInstance = InterfaceInstance.getInstance();


        interfaceInstance.run(true);
    }
}