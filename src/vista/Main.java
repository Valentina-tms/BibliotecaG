package vista;

public class Main {
    public static void main(String[] args) {
        // 1. Aplicar Look & Feel PRIMERO
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info :
                 javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 2. Crear la ventana UNA SOLA VEZ en el Event Dispatch Thread
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}