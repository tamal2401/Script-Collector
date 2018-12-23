package com.demo.scriptcollector.driver.rule;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.model.ScriptCollectorModel;
import com.demo.scriptcollector.strategy.StrategyRule;
import com.demo.scriptcollector.utils.EnumUtils;
import com.demo.scriptcollector.utils.SeleniumDriver;

/**
 * @author TAPU
 *
 */
public class CaptureStoryElements implements StrategyRule{

	@Override
	public void logic(DomainModel domainModel) {
		
		ScriptCollectorModel model = (ScriptCollectorModel)domainModel;
		StringBuilder builder = new StringBuilder();
		try {
			WebElement element = SeleniumDriver.driver.findElement(By.id(EnumUtils.SearchBar_Id));
			element.clear();
			element.sendKeys(model.getStoryNumber());
			element.sendKeys(Keys.ENTER);
			SeleniumDriver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			List<WebElement> elementList = null;
			element = SeleniumDriver.driver.findElement(By.className(EnumUtils.User_Story_Class));
			for(WebElement i : elementList) {
				String body = i.getText();
				builder.append(body);
			}
			
			String userBody = builder.toString();
			model.setBody(userBody);
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(userBody);
		}catch(Exception e){
			String msg = e.getMessage();
			System.out.println("Error while getting Story Body ---> "+msg);
		}
		
		//to capture the story header
		try {
			WebElement element = SeleniumDriver.driver.findElement(By.id(EnumUtils.Story_Header));
			String header = element.getText();
			model.setStoryHeader(header);
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(header);
			}catch(Exception e){
				String msg = e.getMessage();
				System.out.println("Error while getting Story Body ---> "+msg);
			}
		
		//to capture story description
		try {
			WebElement desc = SeleniumDriver.driver.findElement(By.className("user-content-block"));
			String Description = desc.getText();
			model.setDescription(Description);
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(Description);
			}catch(Exception e){
				String msg = e.getMessage();
				System.out.println("Error while getting Story Body ---> "+msg);
			}
		
		//to capture the story point
		try {
			WebElement point = SeleniumDriver.driver.findElement(By.cssSelector("#customfield_1002-val"));
			String storyPoint = point.getText();
			model.setStoryPoint(storyPoint);
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println(storyPoint);
			}catch(Exception e){
				String msg = e.getMessage();
				System.out.println("Error while getting Story Body ---> "+msg);
			}
		
		//to capture the Assignee
				try {
					WebElement asgne = SeleniumDriver.driver.findElement(By.id("assignee-val"));
					String assignee = asgne.getText();
					model.setAssignee(assignee);
					System.out.println("-----------------------------------------------------------------------------");
					System.out.println(assignee);
					}catch(Exception e){
						String msg = e.getMessage();
						System.out.println("Error while getting Story Body ---> "+msg);
					}
	}
}
