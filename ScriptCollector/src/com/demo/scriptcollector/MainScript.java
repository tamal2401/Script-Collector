package com.demo.scriptcollector;

import java.util.Scanner;

import com.demo.scriptcollector.model.ScriptCollectorModel;
import com.demo.scriptcollector.strategy.StrategyResolver;
import com.demo.scriptcollector.utils.SeleniumDriver;

/**
 * @author TAPU
 *
 */
public class MainScript {

	public static void main(String[] args) throws InterruptedException {

		System.out.println("####### Select the Following flow to execute ########");
		System.out.println(" 1. JIRA Script Collector ");
		System.out.println(" 2. Defect details fetching from QC (Under Construction)");
		
		Scanner scn = new Scanner(System.in);
		String flowId = scn.nextLine();
		String defectId=null;
		String storyNum=null;
		String flowName=null;
		
		switch(flowId) {
		case "1" : System.out.println(" Enter the User Story NUmber ---> ");
		  		   storyNum=scn.nextLine();
		  		   flowName = "jira";
		  		   break;
		case "2" : System.out.println(" Enter the User Story NUmber ---> ");
		   		   storyNum=scn.nextLine();
				   flowName = "QC_ALM";
		}
		
		ScriptCollectorModel model = new ScriptCollectorModel(storyNum);
		model.setFlowName(flowName);
		
		StrategyResolver resolver = new StrategyResolver();
		SeleniumDriver.driver.wait(5000);
		SeleniumDriver.closeDriver();
	}

}
