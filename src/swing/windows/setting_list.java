package swing.windows;

import swing.manager.view_manager;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import better.domain.Employee;

public class setting_list implements ActionListener{

    private view_manager viewManager;

    private JButton back;
    private JButton save;

    public setting_list(view_manager viewManager){

        this.viewManager = viewManager;
        this.viewManager.jPanel = new JPanel(new BorderLayout());

        ArrayList <Employee> listEmployee = this.viewManager.personnel.getEmployees();

        Object[][] data = new Object[listEmployee.size()+2][];

        int i = 0 ;
        int total =0;
        for (Employee e : listEmployee){
            data[i]= (new Object[]{
                    e.getPosition(),
                    e.getName(),
                    e.getAge(),
                    e.getEntryYear(),
                    e.calculerSalaire()
            }); i++;
            total += e.calculerSalaire();
        }

        data[i] = new Object[]{"Salaire moyen", "", "", "", this.viewManager.personnel.salaireMoyen()};
        i++;
        data[i] = new Object[]{"Total salaires", "", "", "", total};
        String[] entetes = {"Metiers", "Employe", "Age", "Année d'entrée", "Salaire"};
        JTable table = new JTable( data, entetes);



        this.back = new JButton("Retour ");
        this.back.addActionListener(this);

        this.save = new JButton("Ajouter un employé");
        this.save.addActionListener(this);

        this.viewManager.jPanel.add(table.getTableHeader(),BorderLayout.NORTH);
        this.viewManager.jPanel.add(table, BorderLayout.CENTER);


        this.viewManager.jPanel.add(this.back, BorderLayout.SOUTH);
        this.viewManager.jPanel.add(this.save, BorderLayout.SOUTH);





    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.back){
            System.out.println("list");
            this.viewManager.printDashboard();
        }

        else if(event.getSource() == this.save){
            System.out.println("add");
            this.viewManager.printForm();
        }
    }


}