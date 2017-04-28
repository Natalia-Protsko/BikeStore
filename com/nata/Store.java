package com.nata;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by nata on 28.04.2017.
 */
public class Store extends JFrame {

    private StoreEngine stEng;

    private Panel pnl;
    private JComboBox cbModels;
    private JTextField txtAmount;
    private JButton btnSubmit;

    public int getSelectedModel(){
        return cbModels.getSelectedIndex();
    }

    public String getAmount(){
        return txtAmount.getText();
    }

    public JButton getBtnSubmit(){
        return btnSubmit;
    }


    private void initComponents(){///  init
        pnl = new Panel();
        pnl.setLayout(new java.awt.GridLayout(4,20));

        pnl.add(new JLabel("Make your order"));
        pnl.add(new JLabel(""));

         //Model
        pnl.add(new JLabel("Model: "));
        cbModels = new JComboBox(stEng.getModels());
        pnl.add(cbModels);

        //Amount
        pnl.add(new JLabel("Amount: "));
        txtAmount = new JTextField();
        pnl.add(txtAmount);

        //Submit button
        pnl.add(new JLabel(""));
        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(stEng);
        pnl.add(btnSubmit);

        setContentPane(pnl);
    }

    public Store(){
        //window init
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int opt  = JOptionPane.showConfirmDialog(null,"Really close?","Closing",
                                JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION){
                     System.exit(0);
                }
            }
        });
        // engine init
        stEng = new StoreEngine(this);

        // component init
        initComponents();
        pack();
        setTitle("Welcome to Store!");
        setVisible(true);
    }

    public static void main(String[] args) {
        new Store();
    }

}
