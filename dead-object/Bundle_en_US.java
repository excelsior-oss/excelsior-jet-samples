import java.util.*;

public class Bundle_en_US extends ListResourceBundle {

    public Object[][] getContents() {
        return contents;
    }

    private Object[][] contents = {
            {"resource1", new String("resource1 from Bundle_en_US class")},
            {"resource2", new String("resource2 from Bundle_en_US class")},
            {"resource3", new String("resource3 from Bundle_en_US class")}
    };
}
