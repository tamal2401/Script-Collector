package com.demo.scriptcollector.strategy;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

import com.demo.scriptcollector.model.DomainModel;

/**
 * @author TAPU
 *
 */
public abstract class StrategyImpl implements IStrategy{

	public static final int poolsize = Runtime.getRuntime().availableProcessors();

	protected List<StrategyRule> rules;

	protected String parallalSequentialStrategy = "N";
	@Override 
	public abstract IStrategy build();

	@Override
	public void executeStrategy(DomainModel domainModel) throws InterruptedException, ExecutionException {
		if("Y".equalsIgnoreCase(parallalSequentialStrategy)) {
			doParallal(domainModel,rules);
		}else {
			doSequential(domainModel,rules);
		}
	}

	//Will execute these tasks sequentially and these tasks are dependent on each other
	
	private void doSequential(DomainModel domainModel, List<StrategyRule> rules2) {
		if(null!= parallalSequentialStrategy && null!=domainModel) {
			for(StrategyRule rule:rules2) {
				if(null!=rule) {
					try {
						rule.logic(domainModel);	
					}catch(Exception e) {
						System.out.println("Error while executing sequential task ---> "+e.getMessage());
					}
					
				}
			}
		}
	}

	//Will execute tasks parallaly and these tasks should not be dependent on each other
	
	private void doParallal(DomainModel domainModel, List<StrategyRule> rules2) throws InterruptedException, ExecutionException {
		if(null!=rules2 && null!=domainModel) {
			ForkJoinPool fPoll = new ForkJoinPool(poolsize);
			fPoll.submit(()->
			rules2.parallelStream().forEach(rule -> {
				try {
					rule.logic(domainModel);	
				}catch(Exception e) {
					System.out.println("Error while executing parallal tasks ---> " +e.getMessage());
				}
			})).get();
		}
	}
}
