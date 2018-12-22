package com.demo.scriptcollector.strategy;

import static com.demo.scriptcollector.utils.EnumUtils.JIRA;
import static com.demo.scriptcollector.utils.EnumUtils.QC;

import com.demo.scriptcollector.model.DomainModel;
import com.demo.scriptcollector.strategy.strategyBuilder.BuildRulesForJira;
import com.demo.scriptcollector.strategy.strategyBuilder.BuildRulesForQC;

/**
 * @author TAPU
 *
 */
public class StrategyResolver implements Strategy  {

	BuildRulesForQC qcResolver = new BuildRulesForQC();
	BuildRulesForJira jiraResolver = new BuildRulesForJira();
	
	@Override
	public IStrategy buildStrategy(DomainModel model) {
		String flowName = model.getFlowName();
		switch(flowName) {
		case JIRA: return jiraResolver.build();
		case QC: return qcResolver.build();
		default: return jiraResolver.build();
		}
	}

	
	
}
