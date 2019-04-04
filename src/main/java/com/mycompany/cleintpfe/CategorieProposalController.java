package com.mycompany.cleintpfe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entities.*;
import iservice.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import service.*;

/**
 * FXML Controller class
 *
 * @author Xandrayice
 */
public class CategorieProposalController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TextField text;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            String jndi1="PFE-ejb/CategoryFacade!iservice.CategoryFacadeRemote";
            Context c =new InitialContext();
            System.out.println("ok");
            CategoryFacadeRemote cR = (CategoryFacadeRemote)c.lookup(jndi1);
            Category ca = new Category("name1");
            System.out.println(cR.create(ca));
            
        } catch (NamingException ex) {
            System.out.println("error");
            Logger.getLogger(CategorieProposalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void valider(ActionEvent event) {
        System.out.println(text.getText());
    }
    
}