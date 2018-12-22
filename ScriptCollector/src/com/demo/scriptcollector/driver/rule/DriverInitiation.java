package com.demo.scriptcollector.driver.rule;

import java.util.concurrent.TimeUnit;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.strategy.StrategyRule;
import com.demo.scriptcollector.utils.SeleniumDriver;

/**
 * @author TAPU
 *
 */
public class DriverInitiation implements StrategyRule{

	@Override
	public void logic(DomainModel domainModel) {
		SeleniumDriver.setUpDriver();
		SeleniumDriver.driver.get(domainModel.getUrl());
		
		String storyNum = "RD-"+domainModel.getStoryNumber();
		domainModel.setStoryNumber(storyNum);
		SeleniumDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
