package raf.dsw.classycraft.app.gui.swing.controller;

import raf.dsw.classycraft.app.gui.swing.view.AboutUsView;


public class ActionManager {

    private ExitAction exitAction;
    private AboutUsSection aboutUsSection;

    public ActionManager() {
        this.exitAction = new ExitAction();
    }


    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public AboutUsSection getAboutUsSection() {
        return aboutUsSection;
    }

    public void setAboutUsSection(AboutUsSection aboutUsSection) {
        this.aboutUsSection = aboutUsSection;
    }
}
