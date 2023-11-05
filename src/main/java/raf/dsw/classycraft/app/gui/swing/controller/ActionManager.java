package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewProjectAction newProjectAction;

    public ActionManager() {
        this.exitAction = new ExitAction();
        this.aboutUsAction = new AboutUsAction();
        this.newProjectAction = new NewProjectAction();
    }

}
