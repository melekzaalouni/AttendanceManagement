


package AttendancManagement;

class MultiLineTableCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
    @Override
    public java.awt.Component getTableCellRendererComponent(
            javax.swing.JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        
        String text = (value == null) ? "" : value.toString();
        
      
        javax.swing.JTextArea textArea = new javax.swing.JTextArea(text);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);      
        textArea.setOpaque(true);
        
    
        if (isSelected) {
            textArea.setForeground(table.getSelectionForeground());
            textArea.setBackground(table.getSelectionBackground());
        } else {
            textArea.setForeground(table.getForeground());
            textArea.setBackground(table.getBackground());
        }
        
        textArea.setFont(table.getFont());
        textArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        return textArea;
    }
}
          