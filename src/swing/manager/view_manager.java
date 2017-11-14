package swing.manager;

import swing.windows.setting_windows;
import swing.windows.setting_form;
import swing.windows.setting_list;

import javax.swing.*;

import better.service.Personnel;
import swing.windows.general_setting;

import java.awt.*;

public class view_manager {

    private general_setting generalSetting;
    private setting_windows settingWindows;
    private setting_list settingList;
    private setting_form settingForm;

    public JPanel jPanel;
    public Personnel personnel;

    public view_manager(general_setting generalSetting) {

        this.generalSetting = generalSetting;
        this.personnel = new Personnel();

    }

    public void printDashboard(){

        this.settingWindows = new setting_windows(this);
        this.generalSetting.getContentPane().removeAll();
        this.generalSetting.setContentPane(this.jPanel);
        this.generalSetting.revalidate();
        this.generalSetting.repaint();

    }

    public void printList(){

        this.generalSetting.getContentPane().removeAll();
        this.settingList = new setting_list(this);
        this.generalSetting.setContentPane(this.jPanel);
        this.generalSetting.revalidate();
        this.generalSetting.setSize(540, 300);
        this.generalSetting.repaint();

    }

    public void printForm(){

        this.settingForm = new setting_form(this);
        this.generalSetting.getContentPane().setLayout(new FlowLayout());
        this.generalSetting.getContentPane().add(new JScrollPane());
        this.generalSetting.setContentPane(this.jPanel);
        this.generalSetting.setSize(240, 280);
        this.generalSetting.setVisible(true);

    }
}
