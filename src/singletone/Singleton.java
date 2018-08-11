package singletone;


public class Singleton {

    private static Singleton singleton;

    private int value;

    private Singleton() {
    }

    public static Singleton getInstance() {

        if (singleton == null) {
            singleton = new Singleton();
            singleton.value = 10;
            return singleton;
        }
        return singleton;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return 31 * value;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "value=" + value +
                '}';
    }
}
