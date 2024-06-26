
package com.github.derickfelix.bankapplication.views.users;

import com.github.derickfelix.bankapplication.repositories.impl.RepositoryFactory;
import com.github.derickfelix.bankapplication.models.Customer;
import com.github.derickfelix.bankapplication.repositories.CustomerRepository;
import com.github.derickfelix.bankapplication.utilities.MessageUtility;
import java.util.Optional;

public class CustomersFrameForm extends javax.swing.JInternalFrame {

    private final MainForm mainForm;
    private final CustomerRepository repository;
    private Customer customer;
    
    public CustomersFrameForm(MainForm mainForm)
    {
        this.mainForm = mainForm;
        this.repository = (CustomerRepository) new RepositoryFactory().getInstance("customer");;
        initComponents();
        customSettings();
    }
    
    private void customSettings()
    {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        toolbar = new javax.swing.JToolBar();
        tbtnAdd = new javax.swing.JButton();
        tbtnSave = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        paneInputs = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        cmbAccountType = new javax.swing.JComboBox<>();
        lblAccountType = new javax.swing.JLabel();
        txtAccountNumber = new javax.swing.JTextField();
        lblAccountNumber = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Zwei Bank Application - User Form");

        toolbar.setFloatable(false);
        toolbar.setRollover(true);

        tbtnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        tbtnAdd.setToolTipText("Add New");
        tbtnAdd.setFocusable(false);
        tbtnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbtnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbtnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tbtnAddActionPerformed(evt);
            }
        });
        toolbar.add(tbtnAdd);

        tbtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        tbtnSave.setToolTipText("Search");
        tbtnSave.setFocusable(false);
        tbtnSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tbtnSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        tbtnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                tbtnSaveActionPerformed(evt);
            }
        });
        toolbar.add(tbtnSave);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCloseActionPerformed(evt);
            }
        });

        paneInputs.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 102)));

        lblName.setText("Name");

        lblAddress.setText("Address");

        cmbAccountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select One", "Current", "Savings" }));

        lblAccountType.setText("Account Type");

        lblAccountNumber.setText("Account Number");

        lblPassword.setText("Password");

        javax.swing.GroupLayout paneInputsLayout = new javax.swing.GroupLayout(paneInputs);
        paneInputs.setLayout(paneInputsLayout);
        paneInputsLayout.setHorizontalGroup(
            paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputsLayout.createSequentialGroup()
                        .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAccountNumber)
                            .addComponent(txtName)
                            .addComponent(lblAccountNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtAddress)
                            .addComponent(cmbAccountType, javax.swing.GroupLayout.Alignment.TRAILING, 0, 329, Short.MAX_VALUE)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblAccountType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(txtPassword)
                    .addComponent(lblPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        paneInputsLayout.setVerticalGroup(
            paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneInputsLayout.createSequentialGroup()
                .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneInputsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(paneInputsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblName))
                    .addGroup(paneInputsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAddress)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAccountNumber)
                    .addComponent(lblAccountType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(paneInputsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAccountNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbAccountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(toolbar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClose))
                    .addComponent(paneInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(paneInputs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnSave))
                .addGap(12, 12, 12))
        );

        setBounds(300, 100, 692, 355);
    }// </editor-fold>//GEN-END:initComponents

    private void tbtnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tbtnSaveActionPerformed
    {//GEN-HEADEREND:event_tbtnSaveActionPerformed
        save();
    }//GEN-LAST:event_tbtnSaveActionPerformed

    private void tbtnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_tbtnAddActionPerformed
    {//GEN-HEADEREND:event_tbtnAddActionPerformed
        clearForm();
    }//GEN-LAST:event_tbtnAddActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSaveActionPerformed
    {//GEN-HEADEREND:event_btnSaveActionPerformed
        save();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnCloseActionPerformed
    {//GEN-HEADEREND:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void clearForm()
    {
        txtName.setText("");
        txtAddress.setText("");
        txtAccountNumber.setText("");
        cmbAccountType.setSelectedIndex(0);
        lblPassword.setVisible(true);
        txtPassword.setVisible(true);
        txtPassword.setText("");
    }
    
    private void save()
    {
        String name = txtName.getText();
        String address = txtAddress.getText();
        String accountNumber = txtAccountNumber.getText();
        String accountType = cmbAccountType.getItemAt(cmbAccountType.getSelectedIndex());
        String password = new String(txtPassword.getPassword());
        
        if (name.isEmpty() || address.isEmpty() || accountNumber.isEmpty() || cmbAccountType.getSelectedIndex() == 0 || (customer == null && password.isEmpty())) {
            MessageUtility.warning(mainForm, "There are invalid fields");
        } else {
            if (customer == null) {
                customer = new Customer();
                customer.setPassword(password);
            }

            Optional<Customer> optional = repository.findByAccountNumber(accountNumber);
            if (optional.isPresent() && !optional.get().getAccountNumber().equals(customer.getAccountNumber())) {
                MessageUtility.warning(mainForm, "Account Number already in use!");
                return;
            }
            
            customer.setName(name);
            customer.setAddress(address);
            customer.setAccountNumber(accountNumber);
            customer.setAccountType(accountType);
            
            repository.save(customer);
            
            MessageUtility.info(mainForm, "Content saved successfully!");
            clearForm();
        }
    }
    
    public CustomersFrameForm setCustomer(Customer customer)
    {
        this.customer = customer;
        this.lblPassword.setVisible(false);
        this.txtPassword.setVisible(false);
        
        txtName.setText(customer.getName());
        txtAddress.setText(customer.getAddress());
        txtAccountNumber.setText(customer.getAccountNumber());
        
        int index = 0;
        for (int i = 0; i < cmbAccountType.getItemCount(); i++) {
            if (cmbAccountType.getItemAt(i).equals(customer.getAccountType())) {
                index = i;
                break;
            }
        }

        cmbAccountType.setSelectedIndex(index);
        
        return this;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cmbAccountType;
    private javax.swing.JLabel lblAccountNumber;
    private javax.swing.JLabel lblAccountType;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPanel paneInputs;
    private javax.swing.JButton tbtnAdd;
    private javax.swing.JButton tbtnSave;
    private javax.swing.JToolBar toolbar;
    private javax.swing.JTextField txtAccountNumber;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
