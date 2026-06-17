
package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class EstiloUI {

    // ── Colores principales ──────────────────────────────────────
    public static final Color COLOR_PRIMARIO    = new Color(30, 80, 140);
    public static final Color COLOR_SECUNDARIO  = new Color(52, 120, 200);
    public static final Color COLOR_FONDO       = new Color(240, 245, 255);
    public static final Color COLOR_BLANCO      = Color.WHITE;
    public static final Color COLOR_GRIS_BTN    = new Color(100, 100, 110);
    public static final Color COLOR_PELIGRO     = new Color(180, 40, 40);
    public static final Color COLOR_EXITO       = new Color(34, 139, 34);
    public static final Color COLOR_TEXTO       = new Color(30, 30, 50);

    // ── Fuentes ──────────────────────────────────────────────────
    public static final Font FUENTE_TITULO  =
        new Font("Times New Roman", Font.BOLD, 20);
    public static final Font FUENTE_LABEL   =
        new Font("Times New Roman", Font.PLAIN, 13);
    public static final Font FUENTE_BOTON   =
        new Font("Times New Roman", Font.BOLD, 13);
    public static final Font FUENTE_CAMPO   =
        new Font("Times New Roman", Font.PLAIN, 13);
    public static final Font FUENTE_AYUDA   =
        new Font("SansSerif", Font.BOLD, 13);

    // ── Aplicar fondo a ventana ───────────────────────────────────
    public static void aplicarFondoVentana(JFrame frame) {
        frame.getContentPane().setBackground(COLOR_FONDO);
    }

    // ── Estilizar título (JLabel grande) ─────────────────────────
    public static void estilizarTitulo(JLabel lbl) {
        lbl.setFont(FUENTE_TITULO);
        lbl.setForeground(COLOR_PRIMARIO);
    }

    // ── Estilizar label normal ────────────────────────────────────
    public static void estilizarLabel(JLabel lbl) {
        lbl.setFont(FUENTE_LABEL);
        lbl.setForeground(COLOR_TEXTO);
    }

    // ── Estilizar campo de texto ──────────────────────────────────
    public static void estilizarCampo(JTextField campo) {
        campo.setFont(FUENTE_CAMPO);
        campo.setForeground(COLOR_TEXTO);
        campo.setBackground(COLOR_BLANCO);
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_SECUNDARIO, 1, true),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
    }

    // ── Estilizar campo contraseña ────────────────────────────────
    public static void estilizarCampo(JPasswordField campo) {
        campo.setFont(FUENTE_CAMPO);
        campo.setForeground(COLOR_TEXTO);
        campo.setBackground(COLOR_BLANCO);
        campo.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(COLOR_SECUNDARIO, 1, true),
            BorderFactory.createEmptyBorder(4, 8, 4, 8)
        ));
    }

    // ── Estilizar ComboBox ────────────────────────────────────────
    public static void estilizarCombo(JComboBox<?> combo) {
        combo.setFont(FUENTE_CAMPO);
        combo.setBackground(COLOR_BLANCO);
    }

    // ── Botón primario (azul) ─────────────────────────────────────
    public static void estilizarBotonPrimario(JButton btn) {
        btn.setBackground(COLOR_PRIMARIO);
        btn.setForeground(COLOR_BLANCO);
        btn.setFont(FUENTE_BOTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
    }

    // ── Botón secundario (gris) ───────────────────────────────────
    public static void estilizarBotonSecundario(JButton btn) {
        btn.setBackground(COLOR_GRIS_BTN);
        btn.setForeground(COLOR_BLANCO);
        btn.setFont(FUENTE_BOTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
    }

    // ── Botón peligro (rojo, para eliminar) ──────────────────────
    public static void estilizarBotonPeligro(JButton btn) {
        btn.setBackground(COLOR_PELIGRO);
        btn.setForeground(COLOR_BLANCO);
        btn.setFont(FUENTE_BOTON);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
    }

    // ── Botón ayuda (azul acero pequeño) ─────────────────────────
    public static void estilizarBotonAyuda(JButton btn) {
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(COLOR_BLANCO);
        btn.setFont(FUENTE_AYUDA);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setOpaque(true);
        btn.setText("?");
    }

    // ── Panel con borde con título ────────────────────────────────
    public static JPanel crearPanelConTitulo(String titulo) {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_FONDO);
        panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(COLOR_SECUNDARIO, 1),
            titulo,
            javax.swing.border.TitledBorder.LEFT,
            javax.swing.border.TitledBorder.TOP,
            new Font("Times New Roman", Font.BOLD, 12),
            COLOR_PRIMARIO
        ));
        return panel;
    }
    // Solo números (cédula, teléfono, ID préstamo, año)
    public static void soloNumeros(javax.swing.JTextField campo) {
        ((AbstractDocument) campo.getDocument()).setDocumentFilter(
            new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset,
                        String text, AttributeSet attr) throws BadLocationException {
                    if (text.matches("[0-9]+")) super.insertString(fb, offset, text, attr);
                }
                @Override
                public void replace(FilterBypass fb, int offset, int length,
                        String text, AttributeSet attr) throws BadLocationException {
                    if (text.matches("[0-9]*")) super.replace(fb, offset, length, text, attr);
                }
            }
        );
    }

    // Solo letras y espacios (nombre, apellido, autor)
    // Solo letras y espacios (nombre, apellido, autor)
    public static void soloLetras(javax.swing.JTextField campo) {
        ((AbstractDocument) campo.getDocument()).setDocumentFilter(
            new DocumentFilter() {
                @Override
                public void insertString(FilterBypass fb, int offset,
                        String text, AttributeSet attr) throws BadLocationException {
                    if (text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) super.insertString(fb, offset, text, attr);
                }
                @Override
                public void replace(FilterBypass fb, int offset, int length,
                        String text, AttributeSet attr) throws BadLocationException {
                    if (text.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]*")) super.replace(fb, offset, length, text, attr);
                }
            }
        );
    }

    // Validar email al perder el foco (no restringe mientras escribe)
    public static void validarEmail(javax.swing.JTextField campo) {
        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                String texto = campo.getText().trim();
            if (!texto.isEmpty() && !texto.contains("@")) {
                javax.swing.JOptionPane.showMessageDialog(
                    campo.getParent(),
                    "El email debe contener @",
                    "Email inválido",
                    javax.swing.JOptionPane.WARNING_MESSAGE
                );
                campo.requestFocus();
            }
        }
    });
}
    public static void configurarBtnVolver(javax.swing.JButton btnVolver, javax.swing.JFrame ventana) {
    javax.swing.KeyStroke ctrlR = javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_R,
        java.awt.event.InputEvent.CTRL_DOWN_MASK
    );
    ventana.getRootPane().getInputMap(
        javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW
    ).put(ctrlR, "volverAtras");
    ventana.getRootPane().getActionMap().put("volverAtras",
        new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ventana.dispose();
            }
        }
    );
}
   
   
    public static JPanel crearPanelPassword(JPasswordField campo) {
        estilizarCampo(campo);
        JButton btnVer = new JButton("👁");
        btnVer.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btnVer.setPreferredSize(new Dimension(38, 28));
        btnVer.setFocusPainted(false);
        btnVer.setBorderPainted(false);
        btnVer.setBackground(COLOR_SECUNDARIO);
        btnVer.setForeground(COLOR_BLANCO);
        btnVer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnVer.setToolTipText("Mostrar/Ocultar contraseña");

        // Acción mostrar/ocultar
        final boolean[] visible = {false};
        btnVer.addActionListener(e -> {
            visible[0] = !visible[0];
            if (visible[0]) {
                campo.setEchoChar((char) 0); // muestra texto
                btnVer.setText("🙈");
            } else {
                campo.setEchoChar('•');       // oculta texto
                btnVer.setText("👁");
            }
        });

        JPanel panel = new JPanel(new BorderLayout(2, 0));
        panel.setOpaque(false);
        panel.add(campo, BorderLayout.CENTER);
        panel.add(btnVer, BorderLayout.EAST);
        return panel;
    }
}