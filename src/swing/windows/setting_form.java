package swing.windows;

import swing.manager.view_manager;
import better.domain.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setting_form implements ActionListener {

    //Instanciation du manager
    private view_manager viewManager;

    //instanciation d'un textField nom
    private JTextField jtf_name = new JTextField("Nom");

    //instanciation d'un textField prenom
    private JTextField jtf_prenom = new JTextField("Prenom");

    //instanciation d'un textField age
    private JTextField jtf_age = new JTextField("Age");

    //instanciation d'un textField date d'entree
    private JTextField jtf_entryDate = new JTextField("Date");

    //instanciation d'un textField salaire
    private JSpinner jtf_salaire = new JSpinner();

    //instanciation de salaire
    private String[] jobList = {
            "Manutentionnaire",
            "Manutentionnaire à risque",
            "Technicien",
            "Technicien à risque",
            "Représentant",
            "Vendeur"

    };

    private JComboBox <String> Role;

    //Instanciation du Label Nom
    private JLabel label_name = new JLabel("Nom : ");

    //Instanciation du Label Prenom
    private JLabel label_prenom = new JLabel("Prenom :");

    //Instanciation du Label age
    private JLabel label_age = new JLabel("age :");

    //Instanciation du Label Date D'entrée
    private JLabel label_entryDate = new JLabel("Date d'entrée :");

    //Instanciation du Label Salaire
    private JLabel label_salaire = new JLabel("Salaire :");

    //Instanciation du Label Poste
    private JLabel label_poste = new JLabel("Poste occupé :");

    //Possibilité 1 : instanciation avec le libellé
    private JButton back = new JButton("Retour");

    //Possibilité 2 : instanciation sans le libellé
    private JButton save = new JButton();

    public setting_form(view_manager viewManager){

        this.viewManager = viewManager;
        this.viewManager.jPanel = new JPanel();

        this.Role = new JComboBox<>(this.jobList);

        Font police = new Font("Arial", Font.BOLD, 14);
        jtf_name.setFont(police);
        jtf_name.setPreferredSize(new Dimension(140, 30));

        jtf_prenom.setFont(police);
        jtf_prenom.setPreferredSize(new Dimension(150, 30));

        jtf_age.setFont(police);
        jtf_age.setPreferredSize(new Dimension(120, 30));

        jtf_entryDate.setFont(police);
        jtf_entryDate.setPreferredSize(new Dimension(130, 30));

        jtf_salaire.setFont(police);
        jtf_salaire.setPreferredSize(new Dimension(130, 30));



        //defintion d'un libellé pour le boutton 2
        save.setText("Enregistrer");


        this.viewManager.jPanel.setLayout(new BorderLayout());
/*

        this.viewManager.panel.add(new JLabel("Roles"));
        this.viewManager.panel.add(this.comboRole);

        this.viewManager.panel.add(new JLabel("Firstname"));
        this.viewManager.panel.add(this.firstname);

        this.viewManager.panel.add(new JLabel("Lastname"));
        this.viewManager.panel.add(this.lastname);

        this.viewManager.panel.add(new JLabel("Age"));
        this.viewManager.panel.add(this.age);

        this.viewManager.panel.add(new JLabel("Entry year"));
        this.viewManager.panel.add(this.year);

        this.viewManager.panel.add(new JLabel("Unité"));
        this.viewManager.panel.add(this.unit);

        this.viewManager.panel.add(this.submit);
        this.viewManager.panel.add(this.returnButton);
*/
        JPanel top = new JPanel();
        top.add(label_name);
        top.add(jtf_name);

        top.add(label_prenom);
        top.add(jtf_prenom);

        top.add(label_age);
        top.add(jtf_age);

        top.add(label_poste);
        top.add(Role);

        top.add(label_entryDate);
        top.add(jtf_entryDate);

        top.add(label_salaire);
        top.add(jtf_salaire);

        this.viewManager.jPanel.add(top, BorderLayout.CENTER);

        this.back = new JButton("Retour");
        back.addActionListener(this);
        this.save = new JButton("Enregistrer");
        save.addActionListener(this);

        JPanel south = new JPanel();

        //On ajoute nous boutton au panel
        south.add(back);
        south.add(save);
        this.viewManager.jPanel.add(south, BorderLayout.SOUTH);


    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.back){
            System.out.println("dashboard");
            this.viewManager.printDashboard();
        }

        else if(event.getSource() == this.save){

            String jobs = String.valueOf(this.Role.getSelectedItem());
            String nom = this.jtf_name.getText();
            String prenom = this.jtf_prenom.getText();
            String age = this.jtf_age.getText();
            String annee = this.jtf_entryDate.getText();
            int salaire = (int)this.jtf_salaire.getValue();

            Employee e;

            switch (jobs){
                case  ("Manutentionnaire"):
                    e = new Manutentionnaire(prenom,nom, age, annee,salaire);
                    break;

                case  ("Manutentionnaire à risque"):
                    e = new ManutARisque(prenom,nom, age, annee,salaire);
                    break;

                case  ("Technicien"):
                    e = new Technicien(prenom,nom, age, annee,salaire);
                    break;

                case  ("Technicien à risque"):
                    e = new TechnARisque(prenom, nom, age, annee,salaire);
                    break;

                case  ("Représentant"):
                    e = new Representant(prenom,  nom, age, annee, salaire);
                    break;

                case  ("Vendeur"):
                    e = new Vendeur(prenom,  nom, age, annee, salaire);
                    break;

                default:
                    e = null;
                    break;


            }
            if (e != null ){
                this.viewManager.personnel.ajouterEmploye(e);
                this.viewManager.printDashboard();
            }

        }
    }


}