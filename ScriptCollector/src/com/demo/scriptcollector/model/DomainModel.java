package com.demo.scriptcollector.model;

import com.demo.scriptcollector.utils.EnumUtils;

/**
 * @author TAPU
 *
 */
public abstract class DomainModel implements IDomainModel{

	public String url = EnumUtils.JiraLink;
	public String flowName;
	public String storyNumber;
	public String  description;
	public String storyPoint;
	public String assignee;
	public String storyHeader;
	public String body;
	
	public DomainModel(String storyNumber) {
		super();
		this.storyNumber = storyNumber;
	}
	
	public String getFlowName() {
		return flowName;
	}
	public void setFlowName(String flowName) {
		this.flowName = flowName;
	}
	public String getStoryNumber() {
		return storyNumber;
	}
	public void setStoryNumber(String storyNumber) {
		this.storyNumber = storyNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStoryPoint() {
		return storyPoint;
	}
	public void setStoryPoint(String storyPoint) {
		this.storyPoint = storyPoint;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getStoryHeader() {
		return storyHeader;
	}
	public void setStoryHeader(String storyHeader) {
		this.storyHeader = storyHeader;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getUrl() {
		return url;
	}
	
}
