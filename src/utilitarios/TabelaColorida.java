package utilitarios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TabelaColorida extends DefaultTableCellRenderer {

    // Definindo as cores cinza claro e escuro
    private static final Color CINZA_CLARO = new Color(211, 211, 211); // light gray
    private static final Color CINZA_ESCURO = new Color(169, 169, 169); // dark gray

    public TabelaColorida() {
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Color background = Color.WHITE;
        Object object = table.getValueAt(row, 2);

        try {
            double nota = Double.parseDouble(object.toString());
            if (nota < 7) {
                background = CINZA_ESCURO;
            } else if (nota >= 7) {
                background = CINZA_CLARO;
            }
        } catch (NumberFormatException e) {
            System.err.println("Em caso de erro na conversão, mantemos o fundo branco");          
        }

        label.setBackground(background);
        return label;
    }
}
