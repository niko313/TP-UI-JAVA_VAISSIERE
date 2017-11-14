package swing;

import swing.windows.general_setting;
import swing.manager.view_manager;

public class fenetre {

    public static void main(String[] args){
        general_setting window = new general_setting();
        view_manager viewManager = new view_manager(window);

        viewManager.printDashboard();
    }
}
