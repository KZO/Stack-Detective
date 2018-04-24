package com.markatta.stackdetective.distance;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.concurrent.Executors;

public class WeightedAlgorithmCombinationTest {

	@Test
	public void worksWithOnlyOneAlgorithm() {
		WeightedAlgorithmCombination<Object> instance = new WeightedAlgorithmCombination<>(Executors.newSingleThreadExecutor());
		instance.addAlgorithm(1, oneDistanceCalculator);
		
		assertEquals(1, instance.calculateDistance(new Object(), new Object()), 0.000000001);
	}
	
	@Test
	public void worksWithMultipleAlgorithmsAndWeights() {
		WeightedAlgorithmCombination<Object> instance = new WeightedAlgorithmCombination<>(Executors.newSingleThreadExecutor());
		instance.addAlgorithm(0.5, oneDistanceCalculator);
		instance.addAlgorithm(0.5, oneDistanceCalculator);
		
		assertEquals(1, instance.calculateDistance(new Object(), new Object()), 0.000000001);
	}
	
	private final DistanceAlgorithm<Object> oneDistanceCalculator = (a, b) -> 1;
}
