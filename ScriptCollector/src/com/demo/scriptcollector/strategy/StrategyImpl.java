package com.demo.scriptcollector.strategy;

import java.util.List;

import com.demo.scriptcollector.model.DomainModel;

/**
 * @author TAPU
 *
 */
public abstract class StrategyImpl implements IStrategy{

	protected List<StrategyRule> rules;

	protected String parallalSequentialStrategy = "N";
	@Override 
	public abstract IStrategy build();

	@Override
	public void executeStrategy(DomainModel domainModel) {
		if("Y".equalsIgnoreCase(parallalSequentialStrategy)) {
			doParallal(domainModel);
		}else {
			doSequential(domainModel);
		}
	}

	private void doSequential(DomainModel domainModel) {
		if(null!= parallalSequentialStrategy && null!=domainModel) {
			for(StrategyRule rule:rules) {
				if(null!=rule) {
					rule.logic(domainModel);
				}
			}
		}
	}

	private void doParallal(DomainModel domainModel) {

	}
}
