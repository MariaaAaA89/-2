import GUI.OrcArmyApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OrcArmyApp app = new OrcArmyApp();
            app.setVisible(true);
        });
    }
}