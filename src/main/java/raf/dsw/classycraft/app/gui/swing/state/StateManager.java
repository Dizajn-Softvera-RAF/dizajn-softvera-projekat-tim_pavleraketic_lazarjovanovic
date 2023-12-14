package raf.dsw.classycraft.app.gui.swing.state;
import lombok.Getter;
import raf.dsw.classycraft.app.gui.swing.state.controller.*;

@Getter
public class StateManager {

        private State state;
        private ConnectState connectionState;
        private SelectState selectState;
        private AddState addState;
        private MoveState moveState;
        private DeleteState deleteState;
        private AddClassContentState addClassContentState;
        private DuplicateState duplicateState;
        private EditClassContentState editClassContentState;
        private ZoomInState zoomInState;
        private ZoomOutState zoomOutState;

        public StateManager () {
            initialise();
        }

        public void initialise () {
            addState = new AddState();
            connectionState = new ConnectState();
            moveState = new MoveState();
            selectState = new SelectState();
            deleteState = new DeleteState();
            addClassContentState = new AddClassContentState();
            duplicateState = new DuplicateState();
            editClassContentState = new EditClassContentState();
            zoomInState = new ZoomInState();
            zoomOutState = new ZoomOutState();
            state = selectState;
        }

        public void setAddState() {
            state = addState;
            addState.izaberiTip();
        }
        
        public void setMoveState() {
            state = moveState;
        }
        

    public void setDeleteState() {state = deleteState;}

    public void setSelectState() {state = selectState;}
    public void setZoomInState() {state = zoomInState;}
    public void setZoomOutState() {state = zoomOutState;}

    public void setConnectState() {state = connectionState;
        connectionState.izaberi();}

    public void setAddClassContentState(){state = addClassContentState;
            addClassContentState.izaberiTip();}

    public void setDuplicateState() {
        state = duplicateState;
    }
    public void setEditClassContentState() {
        state = editClassContentState;
    }


    public State getCurrent() {
        return state;}
}


