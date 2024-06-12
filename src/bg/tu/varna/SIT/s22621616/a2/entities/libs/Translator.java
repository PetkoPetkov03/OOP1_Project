package bg.tu.varna.SIT.s22621616.a2.entities.libs;

public abstract class Translator {

    public static <T extends Enum<T>> String translateEnumToUserString(T enumeration) {
        return enumeration.name().replace("_", " ");
    }

    public static <T extends Enum<T>> T translateUserStringToEnum(Class<T> enumClass, String userString) {
        try{
            return Enum.valueOf(enumClass, userString.replace(" ", "_").toUpperCase());
        }catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }
}
