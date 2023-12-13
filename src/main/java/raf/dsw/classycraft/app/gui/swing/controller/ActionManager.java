package raf.dsw.classycraft.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.controller.state.*;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;
    private NewProjectAction newProjectAction;
    private DeleteAction deleteAction;
    private EditAction editAction;
    private EditAuthorAction editAuthorAction;

    private AddStateAction addStateAction;
    private AddAttributeAction addAttributeAction;
    private ConnectStateAction connectStateAction;
    private DeleteStateAction deleteStateAction;
    private MoveStateAction moveStateAction;
    private SelectStateAction selectStateAction;
    private ZoomInAction zoomInAction;
    private ZoomOutAction zoomOutAction;
    private DuplicateAction duplicateAction;



    public ActionManager() {
        this.exitAction = new ExitAction();
        this.aboutUsAction = new AboutUsAction();
        this.newProjectAction = new NewProjectAction();
        this.deleteAction = new DeleteAction();
        this.editAction = new EditAction();
        this.editAuthorAction = new EditAuthorAction();

        this.addStateAction = new AddStateAction();
        this.addAttributeAction = new AddAttributeAction();
        this.connectStateAction = new ConnectStateAction();
        this.deleteStateAction = new DeleteStateAction();
        this.moveStateAction = new MoveStateAction();
        this.selectStateAction = new SelectStateAction();
        this.zoomInAction = new ZoomInAction();
        this.zoomOutAction = new ZoomOutAction();
        this.duplicateAction = new DuplicateAction();

    }

}
