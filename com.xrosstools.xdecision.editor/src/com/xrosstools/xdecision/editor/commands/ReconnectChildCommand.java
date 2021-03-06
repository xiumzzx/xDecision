package com.xrosstools.xdecision.editor.commands;

import org.eclipse.gef.commands.Command;

import com.xrosstools.xdecision.editor.model.DecisionTreeNode;
import com.xrosstools.xdecision.editor.model.DecisionTreeNodeConnection;

public class ReconnectChildCommand extends Command {

	private DecisionTreeNodeConnection path;
	private DecisionTreeNode oldChild;
	private DecisionTreeNode newChild;

	public ReconnectChildCommand(DecisionTreeNodeConnection path, DecisionTreeNode newChild){
		this.path = path;
		this.newChild = newChild;
		oldChild = path.getChild();
	}
	
	public boolean canExecute() {
		if(newChild.getInput() != null)
			return false;
		
		if (path.getChild().equals(newChild))
			return false;
		
		DecisionTreeNode next = path.getParent();
		while(next != null){
			if (next.equals(newChild))
				return false;
			
			next = next.getInput() == null ? null : next.getInput().getParent();
		}
		
		return true;
	}

	public void execute() {
		oldChild.setInput(null);
		path.setChild(newChild);
		newChild.setInput(path);
	}

	public void undo() {
		newChild.setInput(null);
		path.setChild(oldChild);
		oldChild.setInput(path);
	}
}
