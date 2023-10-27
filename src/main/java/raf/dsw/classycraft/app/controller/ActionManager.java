package raf.dsw.classycraft.app.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private AboutUsSection aboutUsSection;

    public ActionManager() {
        this.exitAction = new ExitAction();
        this.aboutUsSection = new AboutUsSection();
    }

}
