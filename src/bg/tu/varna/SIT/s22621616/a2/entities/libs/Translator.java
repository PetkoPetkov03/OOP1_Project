package bg.tu.varna.SIT.s22621616.a2.entities.libs;

/**
 * A utility class for translating between enum values and user-friendly strings.
 */
public abstract class Translator {

    /**
     * Converts an enum value to a user-friendly string by replacing underscores with spaces.
     *
     * @param enumeration The enum value to translate.
     * @param <T>        The type of the enum.
     * @return A string representation of the enum value.
     */
    public static <T extends Enum<T>> String translateEnumToUserString(T enumeration) {
        return enumeration.name().replace("_", " ");
    }

    /**
     * Translates a user-provided string to an enum value, handling underscores and case.
     *
     * @param enumClass The class of the enum to translate to.
     * @param userString The user-provided string.
     * @param <T>       The type of the enum.
     * @return The corresponding enum value, or null if not found.
     */
    public static <T extends Enum<T>> T translateUserStringToEnum(Class<T> enumClass, String userString) {
        try {
            return Enum.valueOf(enumClass, userString.replace(" ", "_").toUpperCase());
        } catch (IllegalArgumentException | NullPointerException e) {
            return null;
        }
    }

    /**
     * Translates a user-provided string to an enum value without error handling.
     *
     * @param enumClass The class of the enum to translate to.
     * @param userString The user-provided string.
     * @param <T>       The type of the enum.
     * @return The corresponding enum value.
     */
    public static <T extends Enum<T>> T translateUserStringToEnumNullable(Class<T> enumClass, String userString) {
        return Enum.valueOf(enumClass, userString);
    }
}
