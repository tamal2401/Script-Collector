package com.demo.scriptcollector.driver.rule;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.strategy.StrategyRule;
import com.demo.scriptcollector.utils.EnumUtils;
import com.demo.scriptcollector.utils.SeleniumDriver;

/**
 * @author TAPU
 *
 */
public class LoginToJiraRule implements StrategyRule{

	@Override
	public void logic(DomainModel domainModel) {
		
		SeleniumDriver.driver.findElement(By.id(EnumUtils.user_Id_Element)).sendKeys(EnumUtils.userName);
		SeleniumDriver.driver.findElement(By.id(EnumUtils.pwd_Id_Element)).sendKeys(EnumUtils.pwd);
		SeleniumDriver.driver.findElement(By.id(EnumUtils.SearchBar_Id)).click();
		SeleniumDriver.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
}
