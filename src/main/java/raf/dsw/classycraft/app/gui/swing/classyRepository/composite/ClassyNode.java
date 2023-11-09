package raf.dsw.classycraft.app.gui.swing.classyRepository.composite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import raf.dsw.classycraft.app.gui.swing.observer.Publisher;
import raf.dsw.classycraft.app.gui.swing.observer.Subscriber;

@Getter
@Setter

public abstract class ClassyNode implements Publisher {
        protected List<Subscriber> subs;
        private String name;
        private ClassyNode parent;


    public ClassyNode getParent() {
        return parent;
    }

    public ClassyNodeComposite getParent(int x) {
        return (ClassyNodeComposite) parent;
    }

    public void setParent(ClassyNode parent) {
        this.parent = parent;
    }

    public ClassyNode(String name, ClassyNode parent)
    {
        this.name = name;
        this.parent = parent;
        this.subs = new ArrayList<>();
    }

    @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof ClassyNode)
            {
                ClassyNode obj2 = (ClassyNode) obj;
                return this.getName().equals(obj2.getName());
            }
            return false;
        }


        public void setName(String name) throws IOException {
            this.name = name;
            //notifySubscribers(this);
        }
}
