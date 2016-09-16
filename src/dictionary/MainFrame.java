/*
 * Copyright (C) 2016 Игорь
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package dictionary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Igor Banchkov
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        TranslatePanel = new javax.swing.JPanel();
        EngReadLabel = new javax.swing.JLabel();
        EngReadTextField = new javax.swing.JTextField();
        RusReadTextField = new javax.swing.JTextField();
        RusReadLabel = new javax.swing.JLabel();
        TranslateButton = new javax.swing.JButton();
        LearnButton = new javax.swing.JButton();
        AddWordPanel = new javax.swing.JPanel();
        EngAddWordLabel = new javax.swing.JLabel();
        RusAddWordLabel = new javax.swing.JLabel();
        EngAddTextField = new javax.swing.JTextField();
        RusAddTextField = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        YaTranslateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(400, 400));
        setMinimumSize(new java.awt.Dimension(800, 300));
        setName("Dictionary"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 300));
        setType(java.awt.Window.Type.POPUP);

        jTabbedPane1.setFont(new java.awt.Font("Book Antiqua", 0, 18)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(800, 300));

        EngReadLabel.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        EngReadLabel.setText("Input english word");

        EngReadTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        EngReadTextField.setMinimumSize(new java.awt.Dimension(200, 50));

        RusReadTextField.setEditable(false);
        RusReadTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RusReadTextField.setMinimumSize(new java.awt.Dimension(200, 50));

        RusReadLabel.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        RusReadLabel.setText("Возможный вариант перевода");

        TranslateButton.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        TranslateButton.setText("Перевод");
        TranslateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TranslateButtonMouseClicked(evt);
            }
        });

        LearnButton.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        LearnButton.setText("Учить слова");
        LearnButton.setToolTipText("");
        LearnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LearnButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TranslatePanelLayout = new javax.swing.GroupLayout(TranslatePanel);
        TranslatePanel.setLayout(TranslatePanelLayout);
        TranslatePanelLayout.setHorizontalGroup(
            TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TranslatePanelLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TranslateButton)
                    .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(EngReadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(EngReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RusReadTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                    .addComponent(LearnButton)
                    .addComponent(RusReadLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        TranslatePanelLayout.setVerticalGroup(
            TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TranslatePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EngReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RusReadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EngReadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RusReadTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(TranslatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TranslateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LearnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", TranslatePanel);

        AddWordPanel.setMinimumSize(new java.awt.Dimension(795, 265));
        AddWordPanel.setPreferredSize(new java.awt.Dimension(795, 265));

        EngAddWordLabel.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        EngAddWordLabel.setText("Input english word");

        RusAddWordLabel.setFont(new java.awt.Font("Bookman Old Style", 0, 16)); // NOI18N
        RusAddWordLabel.setText("Введите перевод английского слова");

        EngAddTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        EngAddTextField.setMinimumSize(new java.awt.Dimension(200, 50));

        RusAddTextField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        RusAddTextField.setMinimumSize(new java.awt.Dimension(200, 50));

        AddButton.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        AddButton.setText("Добавить в словарь");
        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddButtonMouseClicked(evt);
            }
        });

        YaTranslateButton.setFont(new java.awt.Font("Bookman Old Style", 0, 24)); // NOI18N
        YaTranslateButton.setText("Перевод от Yandex");
        YaTranslateButton.setName("YandexTranslate"); // NOI18N
        YaTranslateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YaTranslateButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout AddWordPanelLayout = new javax.swing.GroupLayout(AddWordPanel);
        AddWordPanel.setLayout(AddWordPanelLayout);
        AddWordPanelLayout.setHorizontalGroup(
            AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddWordPanelLayout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddButton)
                    .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(EngAddTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EngAddWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(RusAddTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RusAddWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(YaTranslateButton))
                .addGap(35, 35, 35))
        );
        AddWordPanelLayout.setVerticalGroup(
            AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddWordPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RusAddWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EngAddWordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EngAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RusAddTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(AddWordPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AddButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(YaTranslateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", AddWordPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TranslateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TranslateButtonMouseClicked
        Dictionary.localTranslate(EngReadTextField, RusReadTextField, RusReadLabel);
    }//GEN-LAST:event_TranslateButtonMouseClicked

    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked
        Dictionary.addWordToLocDic(EngAddTextField, RusAddTextField, EngAddWordLabel, RusAddWordLabel);
    }//GEN-LAST:event_AddButtonMouseClicked

    private void YaTranslateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YaTranslateButtonMouseClicked
        try {
            RusAddTextField.setText(Dictionary.yandexTranslate("ru", EngAddTextField.getText()));
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_YaTranslateButtonMouseClicked

    private void LearnButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LearnButtonMouseClicked
        // TODO Method for form learning word pair their.
    }//GEN-LAST:event_LearnButtonMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JPanel AddWordPanel;
    private javax.swing.JTextField EngAddTextField;
    private javax.swing.JLabel EngAddWordLabel;
    private javax.swing.JLabel EngReadLabel;
    private javax.swing.JTextField EngReadTextField;
    private javax.swing.JButton LearnButton;
    private javax.swing.JTextField RusAddTextField;
    private javax.swing.JLabel RusAddWordLabel;
    private javax.swing.JLabel RusReadLabel;
    private javax.swing.JTextField RusReadTextField;
    private javax.swing.JButton TranslateButton;
    private javax.swing.JPanel TranslatePanel;
    private javax.swing.JButton YaTranslateButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
