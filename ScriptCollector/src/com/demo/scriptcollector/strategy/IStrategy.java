package com.demo.scriptcollector.strategy;

import com.demo.scriptcollector.model.DomainModel;

/**
 * @author TAPU
 *
 */
public interface IStrategy {

	IStrategy build();
	
	void executeStrategy(DomainModel domainModel);
}
