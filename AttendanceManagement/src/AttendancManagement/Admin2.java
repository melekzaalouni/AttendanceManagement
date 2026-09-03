
package AttendancManagement;
import javax.swing.*;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;
public class Admin2 extends javax.swing.JFrame {
    Connection con = DBConnection.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    private int num ;
    private String a1=null ;
    private String a2 =null ;
    private String a3=null ;
    private String a4=null ;
    private String a5=null ;
    private String a6=null ;
    private String a7=null;
    private String a8=null ;
    private String adminCin;

    public Admin2(int num , String a1 ,String a2 ,String a3 ,String a4 ,String a5 ,String a6 ,String a7 ,String a8 , String adminCin ) {
    initComponents(); 
    this.num = num;
    this.a1 = a1;
    this.a2 = a2;
    this.a3 = a3;
    this.a4 = a4;
    this.a5 = a5;
    this.a6 = a6;
    this.a7 = a7;
    this.a8 = a8;
    this.adminCin = adminCin;
       
    label();
    parameters();
    loadComboBoxData();
    
}

    
    public Admin2(int num , String a1 , String adminCin ) {
        initComponents(); 
       
        this.num=num ;
        this.a1=a1;
        this.adminCin = adminCin;
         label();
        parameters();
        loadComboBoxData();
       
    }

private void loadComboBoxData() {
    try {
    
        Set<String> niveaux = new HashSet<>();
        String query = "SELECT DISTINCT niveau FROM NiveauSpecialite ORDER BY niveau";
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        while (rs.next()) {
            niveaux.add(rs.getString("niveau"));
        }
        jComboBox1.removeAllItems();
        jComboBox1.addItem("");
        for (String niveau : niveaux) {
            jComboBox1.addItem(niveau);
        }
        
        
        jComboBox1.addActionListener(e -> loadSpecialitesByNiveau());
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur chargement données: " + e.getMessage());
    }
}
private void loadSpecialitesByNiveau() {
    try {
        String niveauSelected = (String) jComboBox1.getSelectedItem();
        if (niveauSelected == null || niveauSelected.isEmpty()) {
            jComboBox2.removeAllItems();
            jComboBox2.addItem("");
            return;
        }
        
        String query = "SELECT DISTINCT specialite FROM NiveauSpecialite WHERE niveau = ? ORDER BY specialite";
        pst = con.prepareStatement(query);
        pst.setString(1, niveauSelected);
        rs = pst.executeQuery();
        
        jComboBox2.removeAllItems();
        jComboBox2.addItem("");
        while (rs.next()) {
            jComboBox2.addItem(rs.getString("specialite"));
        }
        
        
        jComboBox3.removeAllItems();
        jComboBox3.addItem("");
        
        
        jComboBox4.removeAllItems();
        jComboBox4.addItem("");
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur chargement spécialités: " + e.getMessage());
    }
}
private void loadClassesByNiveauSpecialite() {
    try {
        String niveauSelected = (String) jComboBox1.getSelectedItem();
        String specialiteSelected = (String) jComboBox2.getSelectedItem();
        
        if (niveauSelected == null || niveauSelected.isEmpty() || 
            specialiteSelected == null || specialiteSelected.isEmpty()) {
            jComboBox3.removeAllItems();
            jComboBox3.addItem("");
            return;
        }
        
        String query = "SELECT DISTINCT classe FROM NiveauSpecialite WHERE niveau = ? AND specialite = ? ORDER BY classe";
        pst = con.prepareStatement(query);
        pst.setString(1, niveauSelected);
        pst.setString(2, specialiteSelected);
        rs = pst.executeQuery();
        
        jComboBox3.removeAllItems();
        jComboBox3.addItem("");
        while (rs.next()) {
            jComboBox3.addItem(rs.getString("classe"));
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur chargement classes: " + e.getMessage());
    }
}
private void loadMatieresByNiveauSpecialite() {
    try {
        String niveauSelected = (String) jComboBox1.getSelectedItem();
        String specialiteSelected = (String) jComboBox2.getSelectedItem();
        
        if (niveauSelected == null || niveauSelected.isEmpty() || 
            specialiteSelected == null || specialiteSelected.isEmpty()) {
            jComboBox4.removeAllItems();
            jComboBox4.addItem("");
            return;
        }
        
        String query = "SELECT DISTINCT m.matiere FROM matiere m " +
                      "INNER JOIN SpecialiteRef sr ON m.niveau = sr.niveau AND m.specialite = sr.specialite " +
                      "WHERE m.niveau = ? AND m.specialite = ? ORDER BY m.matiere";
        pst = con.prepareStatement(query);
        pst.setString(1, niveauSelected);
        pst.setString(2, specialiteSelected);
        rs = pst.executeQuery();
        
        jComboBox4.removeAllItems();
        jComboBox4.addItem("");
        while (rs.next()) {
            jComboBox4.addItem(rs.getString("matiere"));
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Erreur chargement matières: " + e.getMessage());
    }
}
private void label() {
        switch (num) {
            case 0: 
                jLabel1.setText("Ajouter \n un Etudiant");
                jLabel2.setText(a1); jLabel3.setText(a2); jLabel4.setText(a3);
                jLabel5.setText(a4); jLabel11.setText(a5); jLabel7.setText(a7);
                jLabel6.setText(a6); jLabel9.setText(a8);
                break;
            case 1: 
                jLabel1.setText("Mise a jour \n un Etudiant");
                jLabel2.setText(a1); jLabel3.setText(a2); jLabel4.setText(a3);
                jLabel5.setText(a4); jLabel11.setText(a5); jLabel7.setText(a7);
                jLabel6.setText(a6); jLabel9.setText(a8);
               
                jCheckBox1.setText(" Nom");
                jCheckBox3.setText(" Prenom");
                jCheckBox4.setText(" Niveau");
                jCheckBox2.setText(" Spécialité");
                jCheckBox5.setText(" Classe");
                jCheckBox6.setText(" Password");
                jCheckBox7.setText(" AGE");
                break;
            case 2:
                jLabel1.setText("Supprimer \n un Etudiant");
                jLabel2.setText("CIN à supprimer :");
                resetLabels();
                break;
            case 3: 
                jLabel1.setText("Ajouter \n un Prof");
                jLabel2.setText(a1); jLabel3.setText(a2); jLabel4.setText(a3);
                jLabel12.setText(a4); jLabel5.setText(a5); jLabel11.setText(a6);
                jLabel7.setText(a8); jLabel6.setText(a7);
                break;
            case 4: // Update Prof
                jLabel1.setText("Mise a jour \n un Prof");
                jLabel2.setText(a1); jLabel3.setText(a2); jLabel4.setText(a3);
                jLabel12.setText(a4); jLabel5.setText(a5); jLabel11.setText(a6);
                jLabel7.setText(a8); jLabel6.setText(a7);
                jCheckBox1.setText(" Nom");
                jCheckBox3.setText(" Prenom");
                jCheckBox4.setText(" Niveau");
                jCheckBox2.setText(" Spécialité");
                jCheckBox7.setText(" Matière");
                jCheckBox5.setText(" Classe");
                jCheckBox6.setText(" Password");
                break;
            case 5: 
                jLabel1.setText("Supprimer \n un Prof");
                jLabel2.setText("CIN à supprimer :");
                resetLabels();
                break;
        }
    }
private void resetLabels() {
        jLabel3.setText(""); jLabel4.setText(""); jLabel5.setText("");
        jLabel11.setText(""); jLabel7.setText(""); jLabel6.setText(""); jLabel9.setText("");
        jLabel12.setText("");
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jCheckBox6 = new javax.swing.JCheckBox();
        jCheckBox7 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setFont(new java.awt.Font("Serif", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));

        jTextField6.setBackground(new java.awt.Color(255, 255, 255));

        jTextField8.setBackground(new java.awt.Color(255, 255, 255));
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jCheckBox4.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jCheckBox5.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox5.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        jCheckBox6.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox6.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox6ActionPerformed(evt);
            }
        });

        jCheckBox7.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox7.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox7ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Done!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Retourner");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jComboBox1.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox2.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox3.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(50, 50, 50)
                                                .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jCheckBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jCheckBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(114, 114, 114))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox4)
                            .addComponent(jCheckBox5))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox3)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox6)))
                    .addComponent(jCheckBox7)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel8)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void parameters() {
        
        if (num == 1 || num == 4) {
            jTextField1.setEditable(false); 
            jTextField2.setEditable(false); 
            jTextField3.setEditable(true);  
            jTextField6.setEditable(false);
            jTextField8.setEditable(false); 
            jComboBox1.setEnabled(false);  
            jComboBox2.setEnabled(false);  
            jComboBox3.setEnabled(false);  
            jComboBox4.setEnabled(false);  
        }


        if (num == 2 || num == 5) {
            setupDeleteMode();
        } 

        else {
            setupEditMode();
        }

    
        boolean isUpdate = (num == 1 || num == 4);
        jCheckBox1.setVisible(isUpdate);
        jCheckBox2.setVisible(isUpdate);
        jCheckBox3.setVisible(isUpdate);
        jCheckBox4.setVisible(isUpdate);
        jCheckBox5.setVisible(isUpdate);
        jCheckBox6.setVisible(isUpdate);
        jCheckBox7.setVisible(isUpdate); 

        this.revalidate();
        this.repaint();
    }
private void setupDeleteMode() {
        jLabel2.setVisible(true);
        jTextField3.setVisible(true);

        jTextField1.setVisible(false); jTextField2.setVisible(false);
        jTextField6.setVisible(false); jTextField8.setVisible(false);
        jComboBox1.setVisible(false); jComboBox2.setVisible(false);
        jComboBox3.setVisible(false); jComboBox4.setVisible(false);
        
        jLabel3.setVisible(false); jLabel4.setVisible(false); jLabel5.setVisible(false);
        jLabel6.setVisible(false); jLabel7.setVisible(false); jLabel9.setVisible(false);
        jLabel10.setVisible(false); jLabel11.setVisible(false); jLabel12.setVisible(false);
    }    
private void setupEditMode() {
        jLabel2.setVisible(true); jLabel3.setVisible(true); jLabel4.setVisible(true);
        jLabel5.setVisible(true); jLabel6.setVisible(true); jLabel7.setVisible(true);
        jLabel11.setVisible(true);
        jTextField1.setVisible(true); jTextField2.setVisible(true);
        jTextField3.setVisible(true); jTextField6.setVisible(true);
        jComboBox1.setVisible(true); jComboBox2.setVisible(true);
        jComboBox3.setVisible(true);
        boolean isStudent = (num == 0 || num == 1);
        jTextField8.setVisible(isStudent);
        jLabel9.setVisible(isStudent);
        jLabel10.setVisible(isStudent);
        boolean isProf = (num == 3 || num == 4);
        jComboBox4.setVisible(isProf);
        jLabel12.setVisible(isProf);
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Admin a1 =new Admin(adminCin);
        a1.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       try {
            switch (num) {
                case 0: ajouterEtudiant(); break;
                case 1: updateEtudiant(); break;
                case 2: supprimerEtudiant(); break;
                case 3: ajouterProf(); break;
                case 4: updateProf(); break;
                case 5: supprimerProf(); break;
            }
            
            Admin a1 = new Admin(adminCin);
            a1.setVisible(true);
            this.dispose();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erreur Base de Données : " + ex.getMessage());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Erreur de format (Age doit être un nombre) : " + ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jCheckBox7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox7ActionPerformed
      if (num == 1) {
        jTextField8.setEditable(jCheckBox7.isSelected()); 
    } 
    else if (num == 4) {
        jComboBox4.setEnabled(jCheckBox7.isSelected());
    }
    }//GEN-LAST:event_jCheckBox7ActionPerformed

    private void jCheckBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox6ActionPerformed
        jTextField6.setEditable(jCheckBox6.isSelected());
    }//GEN-LAST:event_jCheckBox6ActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
      jComboBox3.setEnabled(jCheckBox5.isSelected()); 
    }//GEN-LAST:event_jCheckBox5ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
jComboBox1.setEnabled(jCheckBox4.isSelected());
        
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        jTextField2.setEditable(jCheckBox3.isSelected());

    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
jComboBox2.setEnabled(jCheckBox2.isSelected());

    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed

        jTextField1.setEditable(jCheckBox1.isSelected());
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed

    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
       
    }//GEN-LAST:event_jTextField3ActionPerformed
private void ajouterEtudiant() throws SQLException {
        if (jTextField3.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "CIN obligatoire");
            return;
        }

        String sql = "INSERT INTO dbo.Etudiant (Cin, nom, prenom, password, niveau, specialite, classe, age) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, jTextField3.getText());
            pst.setString(2, jTextField1.getText());
            pst.setString(3, jTextField2.getText());
            pst.setString(4, jTextField6.getText());
            pst.setString(5, (String) jComboBox1.getSelectedItem());
            pst.setString(6, (String) jComboBox2.getSelectedItem());
            pst.setString(7, (String) jComboBox3.getSelectedItem());
            
            int age = 0;
            if (!jTextField8.getText().trim().isEmpty()) {
                age = Integer.parseInt(jTextField8.getText().trim());
            }
            pst.setInt(8, age);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Etudiant ajouté avec succès");
        }
    }
private void supprimerEtudiant() throws SQLException {
    String cin = jTextField3.getText().trim();

    if (cin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "CIN obligatoire");
        return;
    }

    String checkSql = "SELECT COUNT(*) FROM dbo.etudiant WHERE CIN=?";
    pst = con.prepareStatement(checkSql);
    pst.setString(1, cin);
    rs = pst.executeQuery();
    if (rs.next() && rs.getInt(1) == 0) {
        JOptionPane.showMessageDialog(this, "Ce CIN n'existe pas dans la base des étudiants");
        return;
    }

    int confirm = JOptionPane.showConfirmDialog(this, 
        "Voulez-vous vraiment supprimer cet étudiant ?\nToutes ses présences seront aussi supprimées.", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }

    String deletePresences = "DELETE FROM dbo.Presence WHERE cin=?";
    pst = con.prepareStatement(deletePresences);
    pst.setString(1, cin);
    pst.executeUpdate();

    String sql = "DELETE FROM dbo.etudiant WHERE CIN=?";
    pst = con.prepareStatement(sql);
    pst.setString(1, cin);
    pst.executeUpdate();

    JOptionPane.showMessageDialog(this, "Etudiant supprimé avec succès");
}
private void ajouterProf() throws SQLException {
        String sql = "INSERT INTO dbo.prof (CIN, nom, prenom, niveau, specialite, matiere, classe, password1) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, jTextField3.getText());
            pst.setString(2, jTextField1.getText());
            pst.setString(3, jTextField2.getText());
            pst.setString(4, (String) jComboBox1.getSelectedItem());
            pst.setString(5, (String) jComboBox2.getSelectedItem());
            pst.setString(6, (String) jComboBox4.getSelectedItem());
            pst.setString(7, (String) jComboBox3.getSelectedItem());
            pst.setString(8, jTextField6.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Professeur ajouté.");
        }
    }
private void supprimerProf() throws SQLException {
    String cin = jTextField3.getText().trim();

    if (cin.isEmpty()) {
        JOptionPane.showMessageDialog(this, "CIN obligatoire");
        return;
    }

    // Vérification d'existence du Prof
    String checkSql = "SELECT COUNT(*) FROM dbo.prof WHERE CIN=?";
    pst = con.prepareStatement(checkSql);
    pst.setString(1, cin);
    rs = pst.executeQuery();
    if (rs.next() && rs.getInt(1) == 0) {
        JOptionPane.showMessageDialog(this, "Ce CIN n'existe pas dans la base des professeurs");
        return;
    }
    int confirm = JOptionPane.showConfirmDialog(this, 
        "Voulez-vous vraiment supprimer ce professeur ?\nToutes ses présences et codes seront aussi supprimés.", 
        "Confirmation", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirm != JOptionPane.YES_OPTION) {
        return;
    }
    String deleteCodes = "DELETE FROM dbo.Code WHERE cin=?";
    pst = con.prepareStatement(deleteCodes);
    pst.setString(1, cin);
    pst.executeUpdate();


    String sql = "DELETE FROM dbo.prof WHERE CIN=?";
    pst = con.prepareStatement(sql);
    pst.setString(1, cin);
    pst.executeUpdate();

    JOptionPane.showMessageDialog(this, "Professeur supprimé avec succès");
}
private void updateEtudiant() throws SQLException {
        String cin = jTextField3.getText().trim();
        if (cin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Entrez le CIN de l'étudiant à modifier");
            return;
        }
        String selectSql = "SELECT * FROM dbo.Etudiant WHERE Cin=?";
        String oldNom = "", oldPrenom = "", oldPass = "", oldNiveau = "", oldSpec = "", oldClasse = "";
        int oldAge = 0;

        try (PreparedStatement pst = con.prepareStatement(selectSql)) {
            pst.setString(1, cin);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    oldNom = rs.getString("nom");
                    oldPrenom = rs.getString("prenom");
                    oldPass = rs.getString("password");
                    oldNiveau = rs.getString("niveau");
                    oldSpec = rs.getString("specialite");
                    oldClasse = rs.getString("classe");
                    oldAge = rs.getInt("age");
                } else {
                    JOptionPane.showMessageDialog(this, "Ce CIN n'existe pas.");
                    return;
                }
            }
        }


        String newNom = jCheckBox1.isSelected() ? jTextField1.getText() : oldNom;
        String newPrenom = jCheckBox3.isSelected() ? jTextField2.getText() : oldPrenom;
        String newPass = jCheckBox6.isSelected() ? jTextField6.getText() : oldPass;
        String newNiveau = jCheckBox4.isSelected() && jComboBox1.getSelectedItem() != null ? (String) jComboBox1.getSelectedItem() : oldNiveau;
        String newSpec = jCheckBox2.isSelected() && jComboBox2.getSelectedItem() != null ? (String) jComboBox2.getSelectedItem() : oldSpec;
        String newClasse = jCheckBox5.isSelected() && jComboBox3.getSelectedItem() != null ? (String) jComboBox3.getSelectedItem() : oldClasse;
        int newAge = oldAge;
        if (jCheckBox7.isSelected() && !jTextField8.getText().trim().isEmpty()) {
            try {
                newAge = Integer.parseInt(jTextField8.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "L'âge doit être un nombre valide !");
                return; 
            }
}

        String updateSql = "UPDATE dbo.Etudiant SET nom=?, prenom=?, niveau=?, specialite=?, classe=?, password=?, age=? WHERE Cin=?";
        try (PreparedStatement pst = con.prepareStatement(updateSql)) {
            pst.setString(1, newNom);
            pst.setString(2, newPrenom);
            pst.setString(3, newNiveau);
            pst.setString(4, newSpec);
            pst.setString(5, newClasse);
            pst.setString(6, newPass);
            pst.setInt(7, newAge);
            pst.setString(8, cin);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Etudiant mis à jour !");
        }
    }
private void updateProf() throws SQLException {
        String cin = jTextField3.getText().trim();
        if (cin.isEmpty()) { JOptionPane.showMessageDialog(this, "CIN obligatoire"); return; }

        // 1. Récupération des données actuelles
        String oldNom = "", oldPrenom = "", oldPass = "", oldNiveau = "", oldSpec = "", oldClasse = "", oldMatiere = "";
        try (PreparedStatement pst = con.prepareStatement("SELECT * FROM dbo.prof WHERE CIN=?")) {
            pst.setString(1, cin);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    oldNom = rs.getString("nom");
                    oldPrenom = rs.getString("prenom");
                    oldPass = rs.getString("password1"); // Attention au nom de colonne
                    oldNiveau = rs.getString("niveau");
                    oldSpec = rs.getString("specialite");
                    oldClasse = rs.getString("classe");
                    oldMatiere = rs.getString("matiere");
                } else {
                    JOptionPane.showMessageDialog(this, "Prof introuvable.");
                    return;
                }
            }
        }

        // 2. Fusion avec les nouvelles données si checkbox cochée
        String newNom = jCheckBox1.isSelected() ? jTextField1.getText() : oldNom;
        String newPrenom = jCheckBox3.isSelected() ? jTextField2.getText() : oldPrenom;
        String newNiveau = jCheckBox4.isSelected() && jComboBox1.getSelectedItem() != null ? (String) jComboBox1.getSelectedItem() : oldNiveau;
        String newSpec = jCheckBox2.isSelected() && jComboBox2.getSelectedItem() != null ? (String) jComboBox2.getSelectedItem() : oldSpec;
        String newClasse = jCheckBox5.isSelected() && jComboBox3.getSelectedItem() != null ? (String) jComboBox3.getSelectedItem() : oldClasse;
        String newMatiere = jCheckBox7.isSelected() && jComboBox4.getSelectedItem() != null ? (String) jComboBox4.getSelectedItem() : oldMatiere;
        String newPass = jCheckBox6.isSelected() ? jTextField6.getText() : oldPass;

        // 3. Update
        String sql = "UPDATE dbo.prof SET nom=?, prenom=?, password1=?, niveau=?, specialite=?, classe=?, matiere=? WHERE CIN=?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, newNom);
            pst.setString(2, newPrenom);
            pst.setString(3, newPass);
            pst.setString(4, newNiveau);
            pst.setString(5, newSpec);
            pst.setString(6, newClasse);
            pst.setString(7, newMatiere);
            pst.setString(8, cin);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Professeur mis à jour.");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JCheckBox jCheckBox6;
    private javax.swing.JCheckBox jCheckBox7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
