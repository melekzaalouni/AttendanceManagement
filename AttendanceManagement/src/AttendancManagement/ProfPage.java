
package AttendancManagement;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
public class ProfPage extends javax.swing.JFrame {
    private static String cin ; 
    Connection con=DBConnection.getConnection();
    PreparedStatement  pst  = null ;
    ResultSet rs = null ;
    public ProfPage(String cin ) {
        initComponents();
         this.cin = cin ; 
         loadStudents();
         label();
         setTableColumnWidths() ;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nom", "Prenom ", "Cin"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Serif", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Enter votre code pour aujoud'hui ");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI Symbol", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("retourner a la page précédente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 242, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void setTableColumnWidths() {
        setMultiLineRenderer(jTable1);
        jTable1.setRowHeight(50); 
        jTable1.setRowHeight(50); 
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(180); 
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(180); 
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(180); 

}
    private void setMultiLineRenderer(javax.swing.JTable table) {
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineTableCellRenderer());
    }
}
    private void label() {
    String p = "SELECT nom, prenom FROM prof WHERE cin = ?";
    try {
        pst = con.prepareStatement(p);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            jLabel1.setText("Bonjour mr/mdm " + nom + " " + prenom);
        } else {
            jLabel1.setText("Professeur non trouvé");
        }

        rs.close();
        pst.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage());
        
    }
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                           
    String code = jTextField1.getText(); 
    String matiere = null; 
    
    
    String p = "SELECT matiere FROM prof WHERE cin = ?";
    try {
        pst = con.prepareStatement(p);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        
        if (rs.next()) { 
            matiere = rs.getString("matiere");
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Aucun professeur trouvé avec ce CIN");
            return; 
        }
        
        rs.close();
        pst.close();
    } catch (Exception e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erreur lors de la récupération de la matière: " + e.getMessage());
        return; 
    }
    

    if (matiere == null) {
        javax.swing.JOptionPane.showMessageDialog(this, "Matière non trouvée");
        return;
    }
    String p1 = "INSERT INTO code VALUES (?, ?, ?, ?)";
    try { 
        pst = con.prepareStatement(p1);
        pst.setString(1, cin);       
        pst.setString(2, code);           
        pst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        pst.setString(4, matiere);
        pst.executeUpdate();
        
        javax.swing.JOptionPane.showMessageDialog(this, "informations enregistré avec succès !");
        jTextField1.setText("");
        
        pst.close();
    } catch (SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement: " + e.getMessage());
    }

   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login p =new Login (); 
        p.setVisible(true);
        this.dispose();
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
    private  void loadStudents() {
    try {
        String queryProf = "SELECT niveau, specialite FROM prof WHERE cin = ?";
        pst = con.prepareStatement(queryProf);
        pst.setString(1, cin);
        rs = pst.executeQuery();

        if (rs.next()) {
            String niveau = rs.getString("niveau");
            String specialite = rs.getString("specialite");
            

            String queryEtudiants = "SELECT nom, prenom, cin FROM etudiant WHERE niveau = ? AND specialite = ?";
            pst = con.prepareStatement(queryEtudiants);
            pst.setString(1, niveau);
            pst.setString(2, specialite);
            
            rs = pst.executeQuery();

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            while (rs.next()) {
                model.addRow(new Object[]{ rs.getString("nom"), rs.getString("prenom"), rs.getString("cin") });
            }
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
