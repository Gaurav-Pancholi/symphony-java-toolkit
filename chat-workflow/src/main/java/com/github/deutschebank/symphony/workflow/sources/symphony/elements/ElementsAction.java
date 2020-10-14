package com.github.deutschebank.symphony.workflow.sources.symphony.elements;

import com.github.deutschebank.symphony.workflow.Action;
import com.github.deutschebank.symphony.workflow.Workflow;
import com.github.deutschebank.symphony.workflow.content.Addressable;
import com.github.deutschebank.symphony.workflow.content.User;
import com.symphony.api.model.V4SymphonyElementsAction;

/**
 * Contains all the details extracted from the {@link V4SymphonyElementsAction}, and it's originating message.
 * 
 * @author Rob Moffat
 *
 */
public class ElementsAction implements Action {

	private final Workflow workflow;
	private final Object formData;
	private final String action;
	private final Object workflowObject;
	private final Addressable a;
	private final User u;
	
	public ElementsAction(Workflow w, Addressable a, User u, Object formData, String action, Object workflowObject) {
		super();
		this.workflow = w;
		this.formData = formData;
		this.action = action;
		this.workflowObject = workflowObject;
		this.a = a;
		this.u = u;
	}

	public Object getFormData() {
		return formData;
	}

	public String getAction() {
		return action;
	}

	public Object getWorkflowObject() {
		return workflowObject;
	}

	@Override
	public String toString() {
		return "ElementsAction [formData=" + formData + ", action=" + action
				+ ", workflowObject=" + workflowObject + "]";
	}

	@Override
	public Addressable getAddressable() {
		return a;
	}

	@Override
	public User getUser() {
		return u;
	}

	@Override
	public Workflow getWorkflow() {
		return workflow;
	}
	
	
}
