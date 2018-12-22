package com.demo.scriptcollector.strategy.strategyBuilder;

import com.demo.scriptcollector.strategy.IStrategy;
import com.demo.scriptcollector.strategy.StrategyImpl;

/**
 * @author TAPU
 *
 */
public class BuildRulesForQC extends StrategyImpl{

	@Override
	public IStrategy build() {
		return this;
	}

}
