
package vista;

/**
 *
 * @author User
 */
public class Main {
    
    public static void main(String[] args) {

        Login login = new Login();

        login.setVisible(true);
        
        // Aplicar look and feel Nimbus
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
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
