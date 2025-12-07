package model;

import myEnum.ActionStatus;

public class BookHistory {
	private static long cpt = 0;
	
	private long id;
	private String actionName;
	private ActionStatus status;
	private String details;
	
	public BookHistory() {
		this.id = cpt++;
	}
	
	public BookHistory(String actionName, ActionStatus status, String details) {
		this.actionName = actionName;
		this.status = status;
		this.details = details;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getActionName() {
		return actionName;
	}
	
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	
	public ActionStatus getStatus() {
		return status;
	}
	
	public void setStatus(ActionStatus status) {
		this.status = status;
	}
	
	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}
}
