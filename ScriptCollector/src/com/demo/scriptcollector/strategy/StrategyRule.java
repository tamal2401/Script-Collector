package com.demo.scriptcollector.strategy;

import com.demo.scriptcollector.model.DomainModel;

/**
 * @author TAPU
 *
 */
public interface StrategyRule {

	void logic(DomainModel domainModel);
}
