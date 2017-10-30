import java.net.*;
import java.util.*;

public class Test {

    static final int MAX_ITERATIONS = 10000;

    static String urlString = "file:///" + System.getProperty("user.dir");

    static String bundleName = "Bundle";
    static Locale locale = new Locale("en", "US");
    static String resourceName = "resource1";
    static String expectedResource = "resource1 from Bundle_en_US class";

    public static boolean checkResourceFromBundle(String expected) {
        try {
            URLClassLoader ucl =
                    new URLClassLoader(new URL[]{new URL(urlString)});
            ResourceBundle bundle =
                    ResourceBundle.getBundle(bundleName, locale, ucl);

            String resource = bundle.getString(resourceName);
            return expected.equals(resource);
        } catch (Exception e) {
            System.out.println("FAILED: unexpected exception:");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < MAX_ITERATIONS; i++) {
            if (!checkResourceFromBundle(expectedResource)) {
                System.out.println("FAILED at iteration number " + i);
                return;
            }
        }
        System.out.println("PASSED");
    }
}