package pane;

import javafx.scene.layout.VBox;
import utils.Goto;

public class RootPane extends VBox {
    private static RootPane instance;

    private RootPane() {
        // TODO: FILL CODE HERE

        ///////////////////////
        Goto.setRootPane(this);
        Goto.mainPage();
    }

    public static RootPane getRootPane() {
        if (instance == null)
            instance = new RootPane();
        return instance;
    }
}
