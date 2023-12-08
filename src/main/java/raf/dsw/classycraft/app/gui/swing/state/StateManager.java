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

        public StateManager () {
            initialise();
        }

        public void initialise () {
            addState = new AddState();
            connectionState = new ConnectState();
            moveState = new MoveState();
            selectState = new SelectState();
            deleteState = new DeleteState();
            state = selectState;
        }

        public void setAddState() {
            state = addState;
            addState.izaberiTip();
        }
        
        public void setMoveState() {
            state = moveState;
        }
        

    public void setDeleteState() {state = connectionState;}

    public void setSelectState() {state = selectState;}

    public void setConnectState() {state = deleteState;}

    public State getCurrent() {
        return state;}
}


