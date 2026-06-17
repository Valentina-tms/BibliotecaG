
package vista;

import java.time.LocalDate;
import controlador.PrestamoDAO;
import controlador.LibroDAO;
import javax.swing.JOptionPane;
import modelo.Prestamo;
/**
 *
 * @author User
 */
public class DevolverLibro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DevolverLibro.class.getName());

    /**
     * Creates new form DevolverLibro
     */
    public DevolverLibro() {
    initComponents();

    txtFechaDevolucion.setText(LocalDate.now().toString());
    txtFechaDevolucion.setEditable(false);

    // Estilo botón ayuda
    btnAyuda.setBackground(new java.awt.Color(70, 130, 180));
    btnAyuda.setForeground(java.awt.Color.WHITE);
    btnAyuda.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 13));
    btnAyuda.setFocusPainted(false);
    btnAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAyuda.addActionListener(e -> mostrarAyuda());

    javax.swing.KeyStroke ctrlH = javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_H,
        java.awt.event.InputEvent.CTRL_DOWN_MASK
    );
    getRootPane().getInputMap(
        javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW
    ).put(ctrlH, "abrirAyuda");
    getRootPane().getActionMap().put("abrirAyuda",
        new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                mostrarAyuda();
            }
        }
    );
    
    // Estilo y acción btnAtras
    btnAtras.setBackground(new java.awt.Color(100, 100, 100));
    btnAtras.setForeground(java.awt.Color.WHITE);
    btnAtras.setFont(new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14));
    btnAtras.setFocusPainted(false);
    btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    btnAtras.setText("←");
    btnAtras.addActionListener(e -> dispose());
    
    EstiloUI.aplicarFondoVentana(this);
    EstiloUI.estilizarTitulo(lblDevolucionLibros);
    EstiloUI.estilizarLabel(lblIDPrestamo);
    EstiloUI.estilizarLabel(lblFechaDevolucion);
    EstiloUI.estilizarCampo(txtIDPrestamoDevolucion);
    EstiloUI.estilizarCampo(txtFechaDevolucion);
    EstiloUI.estilizarBotonPrimario(btnRegistrarDevolucion);
    EstiloUI.estilizarBotonAyuda(btnAyuda);
    EstiloUI.estilizarBotonSecundario(btnAtras);

    EstiloUI.soloNumeros(txtIDPrestamoDevolucion);
    EstiloUI.configurarBtnVolver(btnAtras, this);

    setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDevolucionLibros = new javax.swing.JLabel();
        lblIDPrestamo = new javax.swing.JLabel();
        lblFechaDevolucion = new javax.swing.JLabel();
        txtIDPrestamoDevolucion = new javax.swing.JTextField();
        txtFechaDevolucion = new javax.swing.JTextField();
        btnRegistrarDevolucion = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDevolucionLibros.setText("DEVOLUCIÓN DE LIBROS ");

        lblIDPrestamo.setText("ID Préstamo:");

        lblFechaDevolucion.setText("Fecha Devolución:");

        txtFechaDevolucion.setEnabled(false);

        btnRegistrarDevolucion.setText("Registrar Devolución");
        btnRegistrarDevolucion.addActionListener(this::btnRegistrarDevolucionActionPerformed);

        btnAyuda.setText("?");
        btnAyuda.setToolTipText("Ayuda\nCtrl + H");

        btnAtras.setText("<-");
        btnAtras.setToolTipText("Atrás\nCtrl + R");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(btnRegistrarDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblIDPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFechaDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDPrestamoDevolucion, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtFechaDevolucion)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblDevolucionLibros, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDevolucionLibros)
                    .addComponent(btnAyuda)
                    .addComponent(btnAtras))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDPrestamo)
                    .addComponent(txtIDPrestamoDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaDevolucion)
                    .addComponent(txtFechaDevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnRegistrarDevolucion)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarDevolucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDevolucionActionPerformed
        // TODO add your handling code here:
        int idPrestamo =
        Integer.parseInt(
                txtIDPrestamoDevolucion.getText()
        );

        PrestamoDAO prestamoDAO = new PrestamoDAO();

        Prestamo prestamo =
        prestamoDAO.buscarPrestamoPorId(
                idPrestamo
        );

        if (prestamo == null) {

        JOptionPane.showMessageDialog(
            this,
            "Préstamo no encontrado"
        );

        return;
        }

        LocalDate fechaLimite =
        LocalDate.parse(
                prestamo.getFechaLimite()
        );

        LocalDate fechaDevolucion =
        LocalDate.parse(
                txtFechaDevolucion.getText()
        );

        String estado;

        if (fechaDevolucion.isAfter(fechaLimite)) {

        estado = "EN_MORA";

        } else {

        estado = "DEVUELTO";
        }

        boolean actualizado =
        prestamoDAO.registrarDevolucion(
                idPrestamo,
                fechaDevolucion.toString(),
                estado
        );

        if (actualizado) {

        LibroDAO libroDAO = new LibroDAO();

        libroDAO.actualizarEstadoLibro(
            prestamo.getLibro().getId(),
            "DISPONIBLE"
        );

        JOptionPane.showMessageDialog(
            this,
            "Devolución registrada correctamente"
        );

        } else {

        JOptionPane.showMessageDialog(
            this,
            "Error al registrar devolución"
        );
        }
    }//GEN-LAST:event_btnRegistrarDevolucionActionPerformed

    private void mostrarAyuda() {

    String contenido =
        "<html><body style='font-family:SansSerif; padding:8px'>"
        + "<h3 style='color:#2c6fad'> DEVOLUCIÓN DE LIBROS</h3>"
        + "<hr>"
        + "<p><b>ID Préstamo</b> — Ingresa el número de ID del préstamo "
        + "que deseas devolver.</p>"
        + "<p><b>Fecha Devolución</b> — Se asigna automáticamente "
        + "con la fecha actual. No es editable.</p>"
        + "<br>"
        + "<p>▶ Pasos para devolver un libro:</p>"
        + "<ol>"
        + "<li>Ingresa el <b>ID del préstamo</b> en el campo correspondiente.</li>"
        + "<li>Presiona <b>Registrar Devolución</b>.</li>"
        + "<li>El sistema determinará el estado automáticamente:<br>"
        + "&nbsp;&nbsp;&nbsp;✅ <b>DEVUELTO</b> — si se devuelve a tiempo.<br>"
        + "&nbsp;&nbsp;&nbsp;⚠ <b>EN_MORA</b> — si se devuelve después de la fecha límite.</li>"
        + "</ol>"
        + "</body></html>";

    javax.swing.JLabel lbl = new javax.swing.JLabel(contenido);
    lbl.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));

    javax.swing.JOptionPane.showMessageDialog(
        this,
        lbl,
        "Ayuda — Devolución de Libros",
        javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(() -> new DevolverLibro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnRegistrarDevolucion;
    private javax.swing.JLabel lblDevolucionLibros;
    private javax.swing.JLabel lblFechaDevolucion;
    private javax.swing.JLabel lblIDPrestamo;
    private javax.swing.JTextField txtFechaDevolucion;
    private javax.swing.JTextField txtIDPrestamoDevolucion;
    // End of variables declaration//GEN-END:variables
}
