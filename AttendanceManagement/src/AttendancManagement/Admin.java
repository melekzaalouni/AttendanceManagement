
package AttendancManagement;
import java.sql.*; 
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Admin extends javax.swing.JFrame {
    

    Connection con = DBConnection.getConnection() ;
    PreparedStatement pst= null ;
    ResultSet rs=null ;
    private String cin ;
public Admin(String cin) {
    initComponents();
    loadStudents();
    setTableColumnWidths();  
    this.cin = cin;
    label();
}

public Admin() {
    initComponents();
    loadStudents();
    setTableColumnWidths();  
    label();
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cin", "Nom", "Prenom", "Classe+niveau", "mot de passe ", "Age"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setBackground(new java.awt.Color(255, 255, 255));
        jTable2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jTable2.setForeground(new java.awt.Color(0, 0, 0));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cin", "Nom", "Prenom", "Classe+niveau", "matiere", "Password"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisir  1 ", "Prof", "Etudiant " }));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choisir", "Ajouter", "Mise a Jour ", "Supprimer" }));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Au revoire !");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(594, 594, 594)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   private void setTableColumnWidths() {
   setMultiLineRenderer(jTable1);
   setMultiLineRenderer(jTable2);
   jTable1.setRowHeight(50); 
    jTable2.setRowHeight(50); 
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(180); 
    jTable1.getColumnModel().getColumn(1).setPreferredWidth(180); 
    jTable1.getColumnModel().getColumn(2).setPreferredWidth(180); 
    jTable1.getColumnModel().getColumn(3).setPreferredWidth(300); 
    jTable1.getColumnModel().getColumn(4).setPreferredWidth(180); 
    jTable1.getColumnModel().getColumn(5).setPreferredWidth(100); 
    
    jTable2.getColumnModel().getColumn(0).setPreferredWidth(180); 
    jTable2.getColumnModel().getColumn(1).setPreferredWidth(180); 
    jTable2.getColumnModel().getColumn(2).setPreferredWidth(180); 
    jTable2.getColumnModel().getColumn(3).setPreferredWidth(300); 
    jTable2.getColumnModel().getColumn(4).setPreferredWidth(180); 
    jTable2.getColumnModel().getColumn(5).setPreferredWidth(180); 
}
   private void setMultiLineRenderer(javax.swing.JTable table) {
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineTableCellRenderer());
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int i = jComboBox1.getSelectedIndex();
        int j = jComboBox2.getSelectedIndex();
        Admin2 a2;
        switch (i){
            case 2:
                switch (j){
                    case 1 : 
                         a2= new Admin2(0,"CIN" ,"nom","prenom","niveau","specialite","classe","password","age", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    case 2 : 
                         a2= new Admin2(1,"CIN" ,"nom","prenom","niveau","specialite","classe","password","age", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    case 3: 
                        a2= new Admin2(2,"CIN", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    default: 
                        JOptionPane.showMessageDialog(this, "invalide choix ");
                        break ;
                }
                 break; 
            case 1:
                switch (j){
                    case 1 : 
                        a2= new Admin2(3,"CIN" ,"nom","prenom","matiere","niveau","specialite","classe","password1", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    case 2 : 
                         a2= new Admin2(4,"CIN" ,"nom","prenom","matiere","niveau","specialite","classe","password1", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    case 3: 
                         a2= new Admin2(5,"CIN", cin);
                        a2.setVisible(true);
                        this.dispose();
                        break ;
                    default: 
                        JOptionPane.showMessageDialog(this, "invalide choix ");
                        break ;
                }
                 break; 
            default : 
                 JOptionPane.showMessageDialog(this, "invalide choix ");
                  break ;
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           Login l = new Login();
           l.setVisible(true);
           this.dispose();

        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void label() {
    String p = "SELECT nom, prenom   FROM admin  WHERE cin = ?";
    try {
        pst = con.prepareStatement(p);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");

            jLabel1.setText("Bonjour "+nom.trim() + " \n " + prenom.trim());}
       

        rs.close();
        pst.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage());
        
    }
}
     private void loadStudents() {
    try {

        String query1 = "SELECT Cin, prenom, nom, password, " +
                        "CONCAT(niveau, ' - ', specialite, ' - ', classe) AS groupe, age " +
                        "FROM etudiant ORDER BY niveau, specialite, classe";
        pst = con.prepareStatement(query1);
        rs = pst.executeQuery();

        DefaultTableModel model1 = (DefaultTableModel) jTable1.getModel();
        model1.setRowCount(0);

        while (rs.next()) {
            model1.addRow(new Object[]{
                rs.getString("cin"),
                rs.getString("prenom"),
                rs.getString("nom"),
                rs.getString("groupe"),
                rs.getString("password"),
                rs.getInt("age")
            });
        }

        String query2 = "SELECT CIN, prenom, nom, password1, " +
                        "CONCAT(niveau, ' - ', specialite,) AS groupe, matiere " +
                        "FROM prof ORDER BY niveau, specialite, classe";
        pst = con.prepareStatement(query2);
        rs = pst.executeQuery();

        DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
        model2.setRowCount(0);

        while (rs.next()) {
            model2.addRow(new Object[]{
                rs.getString("cin"),
                rs.getString("prenom"),
                rs.getString("nom"),
                rs.getString("groupe"),
                rs.getString("matiere"),
                rs.getString("password1")
            });
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
