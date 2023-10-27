package raf.dsw.classycraft.app.controller;


public class ActionManager {

    private ExitAction exitAction;
    private AboutUsSection aboutUsSection;

    public ActionManager() {
        this.exitAction = new ExitAction();
        this.aboutUsSection = new AboutUsSection();
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
