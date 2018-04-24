package com.markatta.stackdetective.distance;

import com.markatta.stackdetective.distance.levehnstein.WeightedLevehnsteinDistance;
import com.markatta.stackdetective.distance.misc.LoggedAlgorithm;
import com.markatta.stackdetective.distance.misc.NumberOfSegmentsAlgorithm;
import com.markatta.stackdetective.distance.misc.RootTextComparisonAlgorithm;
import com.markatta.stackdetective.distance.misc.SameCauseAlgorithm;
import com.markatta.stackdetective.distance.misc.StackTraceTypeAlgorithm;
import com.markatta.stackdetective.model.StackTrace;

import java.util.concurrent.ExecutorService;

public class StacktraceDistanceCalculatorFactory {

	/**
	 * @return A sensible default algorithm to use
	 */
	public static DistanceAlgorithm<StackTrace> createDefaultCalculator(ExecutorService executorService) {
		WeightedAlgorithmCombination<StackTrace> combination = new WeightedAlgorithmCombination<>(executorService);
		combination.addAlgorithm(0.80, new LoggedAlgorithm<>(new WeightedLevehnsteinDistance()));
		combination.addAlgorithm(0.05, new LoggedAlgorithm<>(new StackTraceTypeAlgorithm()));
		combination.addAlgorithm(0.05, new LoggedAlgorithm<>(new NumberOfSegmentsAlgorithm()));
		combination.addAlgorithm(0.05, new LoggedAlgorithm<>(new RootTextComparisonAlgorithm()));
		combination.addAlgorithm(0.05, new LoggedAlgorithm<>(new SameCauseAlgorithm()));
		
		return new LoggedAlgorithm<>(combination);
	}
	
}
