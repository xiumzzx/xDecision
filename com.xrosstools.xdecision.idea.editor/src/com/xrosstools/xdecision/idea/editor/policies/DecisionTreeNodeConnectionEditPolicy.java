package com.xrosstools.xdecision.idea.editor.policies;

import com.xrosstools.gef.Command;
import com.xrosstools.gef.parts.EditPart;
import com.xrosstools.gef.parts.EditPolicy;
import com.xrosstools.xdecision.idea.editor.commands.DeletePathCommand;
import com.xrosstools.xdecision.idea.editor.model.DecisionTreeNodeConnection;
import com.xrosstools.xdecision.idea.editor.parts.DecisionTreeNodePart;

public class DecisionTreeNodeConnectionEditPolicy extends EditPolicy {

    public Command getDeleteCommand() {
        return new DeletePathCommand((DecisionTreeNodeConnection)getHost().getModel());
    }
}
