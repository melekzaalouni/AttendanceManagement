
package AttendancManagement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
public class EtudiantPage extends javax.swing.JFrame {
    
    private String cin ;
    Connection con = DBConnection.getConnection() ;
    PreparedStatement pst= null ;
    ResultSet rs=null ;
    
    public EtudiantPage(String cin ) {
        initComponents();
        this.cin=cin; 
        loadStudents();
        label();
        remplirCombo();
        setTableColumnWidths();
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
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(0, 0, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Matiere", "Nbr de presence"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Enter le code ");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "selectionner la matiere" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Simplified Arabic", 3, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Au revoir !");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(109, 109, 109))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
  
}
   
   private void setMultiLineRenderer(javax.swing.JTable table) {
    for (int i = 0; i < table.getColumnCount(); i++) {
        table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineTableCellRenderer());
    }
}
  private void label() {
    String p = "SELECT nom, prenom , niveau  , specialite , classe  FROM etudiant WHERE cin = ?";
    try {
        pst = con.prepareStatement(p);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String niveau = rs.getString("niveau");
            String specialite = rs.getString("specialite");
            String classe = rs.getString("classe");
            jLabel1.setText(nom.trim() + " " + prenom.trim()+ " "+ niveau.trim() +" "+ specialite.trim() + " "+classe.trim() );}
       

        rs.close();
        pst.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Erreur: " + e.getMessage());
        
    }
}
  private void remplirCombo(){
      
      
       String p ="select niveau , specialite from etudiant where cin =?  ";
        try{
            pst = con.prepareStatement(p);
            pst.setString(1, cin);
            rs = pst.executeQuery();

            if (rs.next()) {
                String niveau = rs.getString("niveau");
                String specialite = rs.getString("specialite");

                String p1 = "SELECT matiere FROM matiere WHERE specialite = ? AND niveau = ?";
                pst = con.prepareStatement(p1);
                pst.setString(1, specialite);
                pst.setString(2, niveau);
                rs = pst.executeQuery();

                jComboBox1.removeAllItems();               
                

                while (rs.next()) { 
                    jComboBox1.addItem(rs.getString("matiere"));
                }

            }
            else{
                System.out.println("lerreur est ici ");
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(this,e.toString()); 
        }  
  }  
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String matiere = (String) jComboBox1.getSelectedItem();
    String code = jTextField1.getText().trim();
    String p;
    String niveau;
    String specialite;
    String queryEtudiant = "SELECT niveau, specialite FROM etudiant WHERE cin = ?";
    try {
        pst = con.prepareStatement(queryEtudiant);
        pst.setString(1, cin);
        rs = pst.executeQuery();
        if (rs.next()) {
            niveau = rs.getString("niveau");
            specialite = rs.getString("specialite");
        } else {
            return;
        }
    
    
    
            p = "SELECT matiere FROM presence WHERE cin = ? AND matiere = ? AND CAST(date AS date) = CAST(GETDATE() AS date)";
            try {
                pst = con.prepareStatement(p);
                pst.setString(1, cin);
                pst.setString(2, matiere);
                rs = pst.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Vous êtes déjà présent pour cette matière aujourd'hui.");
                    jTextField1.setText("");
                    return;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erreur lors de la vérification de présence: " + e.getMessage());
            }

       
            p = "SELECT code FROM code WHERE code = ? AND matiere = ? AND CAST(date AS date) = CAST(GETDATE() AS date)";
            try {
                pst = con.prepareStatement(p);
                pst.setString(1, code);
                pst.setString(2, matiere);
                rs = pst.executeQuery();

                if (rs.next()) {
                    String p1 = "INSERT INTO presence (cin, matiere, date, niveau, specialite) VALUES (?, ?, ?, ?, ?)";
                    try {
                        pst = con.prepareStatement(p1);
                        pst.setString(1, cin);
                        pst.setString(2, matiere);
                        pst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                        pst.setString(4, niveau);
                        pst.setString(5, specialite);

                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Présence enregistrée avec succès !");
                        jTextField1.setText("");
                        loadStudents();

                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement de la présence: " + e.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Code incorrect ou expiré");
                }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la vérification du code: " + e.getMessage());}
            
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur lors de la récupération des données étudiant: " + e.getMessage());}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Login p =new Login (); 
        p.setVisible(true);
        this.dispose();
        





        
    }//GEN-LAST:event_jButton2ActionPerformed
    
    
 private  void loadStudents() {
    try {
        String queryProf = "SELECT nom , prenom , niveau, specialite, classe FROM Etudiant WHERE cin = ?";
        pst = con.prepareStatement(queryProf);
        pst.setString(1, cin);
        rs = pst.executeQuery();

        if (rs.next()) {
            String nom = rs.getString("nom");
            String prenom = rs.getString("prenom");
            String niveau = rs.getString("niveau");
            String specialite = rs.getString("specialite");
            String classe = rs.getString("classe");
            jLabel1.setText(nom + " "+ prenom + " " +niveau+" "+ specialite+ " "+ classe);
            String queryEtudiants = "SELECT COUNT(*) AS nombre_presences, matiere FROM presence WHERE cin = ? GROUP BY matiere ORDER BY nombre_presences DESC;";
            pst = con.prepareStatement(queryEtudiants);
            pst.setString(1, cin);
            rs = pst.executeQuery();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                    model.addRow(new Object[]{
                    rs.getString("matiere"), 
                    rs.getInt("nombre_presences") 
                });
}
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
