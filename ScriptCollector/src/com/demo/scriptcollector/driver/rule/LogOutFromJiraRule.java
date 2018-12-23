package com.demo.scriptcollector.driver.rule;

import org.openqa.selenium.By;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.strategy.StrategyRule;
import com.demo.scriptcollector.utils.SeleniumDriver;

/**
 * @author TAPU
 *
 */
public class LogOutFromJiraRule implements StrategyRule{

	@Override
	public void logic(DomainModel domainModel) {
		
		SeleniumDriver.driver.findElement(By.id("header-details-user-fullname")).click();
		SeleniumDriver.driver.findElement(By.id("log_out")).click();
		
	}

}
