package raf.dsw.classycraft.app.gui.swing.classyRepository.composite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public abstract class ClassyNodeComposite extends ClassyNode {

    List<ClassyNode> children;
    public ClassyNodeComposite(String name, ClassyNode parent)  {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public ClassyNodeComposite(String name, ClassyNode parent, List<ClassyNode> children)
    {
        super(name, parent);
        this.children = children;
    }

    public List<ClassyNode> getChildren() {
        return children;
    }

    public void setChildren(List<ClassyNode> children) {
        this.children = children;
    }

    public abstract void addChild(ClassyNode child);

    public abstract void removeChild(ClassyNode child);

    public ClassyNode getByName(String name)
    {
        for(ClassyNode child : children)
        {
            if(child.getName() == name)
            {
                return child;
            }
        }
        return null;
    }

}
