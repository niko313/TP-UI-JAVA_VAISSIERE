package swing.windows;

import swing.manager.view_manager;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class setting_windows implements ActionListener {

    private view_manager viewManager;
    private JButton showList;
    private JButton save;

    public setting_windows(view_manager viewManager){

        this.viewManager = viewManager;

        this.viewManager.jPanel = new JPanel();


        this.save = new JButton("Ajouter un employé");
        this.save.addActionListener(this);
        this.showList = new JButton("Afficher les employés");
        this.showList.addActionListener(this);


        this.viewManager.jPanel.add(this.save);
        this.viewManager.jPanel.add(this.showList);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.showList){
            System.out.println("list");
            this.viewManager.printList();
        }

        else if(event.getSource() == this.save){
            System.out.println("add");
            this.viewManager.printForm();
        }
    }

}