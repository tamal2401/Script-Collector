package com.demo.scriptcollector.strategy;

import com.demo.scriptcollector.model.DomainModel;

/**
 * @author TAPU
 *
 */
public interface Strategy {

	IStrategy buildStrategy(DomainModel model);
}
