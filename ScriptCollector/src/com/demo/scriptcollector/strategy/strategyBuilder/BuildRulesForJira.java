package com.demo.scriptcollector.strategy.strategyBuilder;

import java.util.ArrayList;
import java.util.List;

import com.demo.scriptcollector.driver.rule.CaptureStoryElements;
import com.demo.scriptcollector.driver.rule.DriverInitiation;
import com.demo.scriptcollector.driver.rule.LogOutFromJiraRule;
import com.demo.scriptcollector.driver.rule.LoginToJiraRule;
import com.demo.scriptcollector.driver.rule.SaveDataToSheetRule;
import com.demo.scriptcollector.strategy.IStrategy;
import com.demo.scriptcollector.strategy.StrategyImpl;
import com.demo.scriptcollector.strategy.StrategyRule;

/**
 * @author TAPU
 *
 */
public class BuildRulesForJira extends StrategyImpl{

	CaptureStoryElements captureElements = new CaptureStoryElements();
	DriverInitiation initiationRule = new DriverInitiation();
	LoginToJiraRule loginToJiraRule = new LoginToJiraRule();
	LogOutFromJiraRule logoutFromJiraRule = new LogOutFromJiraRule();
	SaveDataToSheetRule saveDataRule = new SaveDataToSheetRule();
	
	@Override
	public IStrategy build() {
		List<StrategyRule> list = new ArrayList<>();
		list.add(initiationRule);
		list.add(loginToJiraRule);
		list.add(captureElements);
		list.add(saveDataRule);
		list.add(logoutFromJiraRule);
		this.rules = list;
		return this;
	}

	

}
