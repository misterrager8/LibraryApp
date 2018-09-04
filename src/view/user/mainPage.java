package view.user;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.user;
import view.loginPage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chemlleijoseph
 */
public class mainPage extends javax.swing.JFrame {

    user model = new user();

    public JTable getBookTable() {
        return bookTable;
    }

    public void setBookTable(JTable bookTable) {
        this.bookTable = bookTable;
    }

    
    
    /**
     * Creates new form mainPage
     *
     * @param uname
     */
    public mainPage(String uname) throws SQLException {

        model.setUser(uname);
        model.findUser();
        initComponents();
        welcomeLabel.setText("Welcome, " + model.getfName() + "!");

        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String title = bookTable.getValueAt(bookTable.getSelectedRow(), 0).toString();
                    try {
                        new bookInfoPage(title).setVisible(true);
                    } catch (IOException ex) {
                        Logger.getLogger(mainPage.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        welcomeLabel = new javax.swing.JLabel();
        exitButton = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        profileTab = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        catalogTab = new javax.swing.JPanel();
        genreSelect = new javax.swing.JComboBox<>();
        statusSelect = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookTable = new javax.swing.JTable();
        submitButton = new javax.swing.JLabel();
        checkOutTab = new javax.swing.JPanel();
        logoutButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(176, 216, 251));

        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        exitButton.setText("X");
        exitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitButtonMouseClicked(evt);
            }
        });

        profileTab.setBackground(new java.awt.Color(176, 216, 251));

        nameLabel.setText("Name: " + model.getfName() + " " + model.getlName());

        jLabel2.setText("Username: " + model.getUser());

        jLabel1.setText("Member Since: " + model.getDateCreated());

        javax.swing.GroupLayout profileTabLayout = new javax.swing.GroupLayout(profileTab);
        profileTab.setLayout(profileTabLayout);
        profileTabLayout.setHorizontalGroup(
            profileTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(515, Short.MAX_VALUE))
        );
        profileTabLayout.setVerticalGroup(
            profileTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", profileTab);

        catalogTab.setBackground(new java.awt.Color(176, 216, 251));

        genreSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre", "Fantasy", "Horror", "Adventure", "Science Fiction", "Romance", "Mystery", "Comics / Graphic Novels", "Biography / Autobiography", "Self - Help", "Reference / Textbooks", " " }));

        statusSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Status", "Available", "Checked Out", "Reserved", "In Process" }));

        bookTable.setAutoCreateRowSorter(true);
        bookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title", "Author", "Genre", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bookTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(bookTable);

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        submitButton.setText("Search");
        submitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        submitButton.setOpaque(true);
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                submitButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                submitButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButtonMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout catalogTabLayout = new javax.swing.GroupLayout(catalogTab);
        catalogTab.setLayout(catalogTabLayout);
        catalogTabLayout.setHorizontalGroup(
            catalogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catalogTabLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(catalogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(statusSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genreSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 339, Short.MAX_VALUE)
                .addContainerGap())
        );
        catalogTabLayout.setVerticalGroup(
            catalogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(catalogTabLayout.createSequentialGroup()
                .addGroup(catalogTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(catalogTabLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(catalogTabLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(genreSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Catalog", catalogTab);

        checkOutTab.setBackground(new java.awt.Color(176, 216, 251));

        javax.swing.GroupLayout checkOutTabLayout = new javax.swing.GroupLayout(checkOutTab);
        checkOutTab.setLayout(checkOutTabLayout);
        checkOutTabLayout.setHorizontalGroup(
            checkOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
        );
        checkOutTabLayout.setVerticalGroup(
            checkOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 222, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Check-Out", checkOutTab);

        logoutButton.setBackground(new java.awt.Color(255, 255, 255));
        logoutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutButton.setText("Logout");
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutButton.setOpaque(true);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                logoutButtonMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutButtonMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutButtonMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitButton))
                    .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitButtonMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitButtonMouseClicked

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        // TODO add your handling code here:
        this.dispose();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        new loginPage().setVisible(true);
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void logoutButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMousePressed
        // TODO add your handling code here:
        changeColor(logoutButton, 155, 155, 155);
    }//GEN-LAST:event_logoutButtonMousePressed

    private void logoutButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseReleased
        // TODO add your handling code here:
        changeColor(logoutButton, 255, 255, 255);
    }//GEN-LAST:event_logoutButtonMouseReleased

    private void logoutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseEntered
        // TODO add your handling code here:
        changeColor(logoutButton, 155, 155, 155);
    }//GEN-LAST:event_logoutButtonMouseEntered

    private void logoutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseExited
        // TODO add your handling code here:
        changeColor(logoutButton, 255, 255, 255);
    }//GEN-LAST:event_logoutButtonMouseExited

    private void submitButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMousePressed
        // TODO add your handling code here:
        changeColor(submitButton, 155, 155, 155);
    }//GEN-LAST:event_submitButtonMousePressed

    private void submitButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseReleased
        // TODO add your handling code here:
        changeColor(submitButton, 255, 255, 255);
    }//GEN-LAST:event_submitButtonMouseReleased

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        // TODO add your handling code here:
        clearTable();
        findBooks();
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseExited
        // TODO add your handling code here:
        changeColor(submitButton, 255, 255, 255);
    }//GEN-LAST:event_submitButtonMouseExited

    private void submitButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseEntered
        // TODO add your handling code here:
        changeColor(submitButton, 155, 155, 155);
    }//GEN-LAST:event_submitButtonMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new mainPage("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(mainPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable bookTable;
    private javax.swing.JPanel catalogTab;
    private javax.swing.JPanel checkOutTab;
    private javax.swing.JLabel exitButton;
    private javax.swing.JComboBox<String> genreSelect;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel logoutButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel profileTab;
    private javax.swing.JComboBox<String> statusSelect;
    private javax.swing.JLabel submitButton;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables

    public void changeColor(JLabel label, int r, int g, int b) {
        label.setBackground(new Color(r, g, b));
    }

    public void findBooks() {

        String url = "jdbc:sqlite:test.db";
        String sql = "";

        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
        if (genreSelect.getSelectedIndex() == 0 && statusSelect.getSelectedIndex() == 0) {
            sql += "select * from books";
            try {
                Connection conn = DriverManager.getConnection(url, "cj", "123");
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String d = rs.getString("title");
                    String e = rs.getString("author");
                    String f = rs.getString("genre");
                    String g = rs.getString("status");
                    model.addRow(new Object[]{d, e, f, g});
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        } else {
            sql += "select * from books where genre = ? AND status = ?";
            try {
                Connection conn = DriverManager.getConnection(url, "cj", "123");
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, String.valueOf(genreSelect.getSelectedItem()));
                stmt.setString(2, String.valueOf(statusSelect.getSelectedItem()));
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    String d = rs.getString("title");
                    String e = rs.getString("author");
                    String f = rs.getString("genre");
                    String g = rs.getString("status");
                    model.addRow(new Object[]{d, e, f, g});
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    public void clearTable() {
        DefaultTableModel model = (DefaultTableModel) bookTable.getModel();
        model.setRowCount(0);
    }

}
