package com.nata;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by nata on 28.04.2017.
 */
public class StoreEngine implements ActionListener {

    private String [] models = {"","Honda","Ukraine","Zai4ik","Explorer"};
    private int [] maxAmt = {0,1,3,5,2};
    private Store parent;

    public StoreEngine(Store parent){
        this.parent = parent;
    }

    public String [] getModels(){
        return models;
    }

    void processSubmit(){
        String strAmount="";
        try{
            // check for incorrect index
            int modelIdx  = parent.getSelectedModel();
            if (modelIdx ==0 ) {
                throw new Exception("Select model");
            }
            if (modelIdx> models.length){
                throw new Exception("Incorrect model number");
            }
            //check for amount
            int maxAmount = maxAmt[modelIdx];
            strAmount = parent.getAmount();

            if (strAmount ==null ) {
                throw new Exception("Enter amount");
            }

            int amount = Integer.parseInt(strAmount);
            if ((amount > maxAmount)) {
                throw new TooManyBikesException("Amount must be " + maxAmount + " or less", new ShippingErrorInfo(maxAmount, amount));
            }
            if ((amount < 1)) {
                throw new Exception("Amount must be 1 or more");
            }
            JOptionPane.showMessageDialog(null, "You ordered "+strAmount+" " +models[modelIdx]);

        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Incorrect amount  - "+strAmount, "Errror!",JOptionPane.CLOSED_OPTION);
        }
        catch (TooManyBikesException ex){
            JOptionPane.showMessageDialog(null,"Amount exceeded "+ex.getShippingErrorInfo().getMsg(), "Errror!",JOptionPane.CLOSED_OPTION);
        }
        catch (Exception  ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error!",JOptionPane.CLOSED_OPTION);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== parent.getBtnSubmit()){///!???????????????
            processSubmit();
        }
    }
}
