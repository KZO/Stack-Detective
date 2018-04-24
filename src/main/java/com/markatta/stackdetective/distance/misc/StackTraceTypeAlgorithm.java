package com.markatta.stackdetective.distance.misc;

import com.markatta.stackdetective.distance.DistanceAlgorithm;
import com.markatta.stackdetective.model.StackTrace;


public final class StackTraceTypeAlgorithm implements DistanceAlgorithm<StackTrace> {

	@Override
	public double calculateDistance(StackTrace a, StackTrace b) {
		
		String typeA = a.getCauseSegment().getExceptionType();
		String typeB = b.getCauseSegment().getExceptionType();
		
		// dead simple 1 if same type 0 if not
		return normalize(typeA.compareTo(typeB));
	}

	private double normalize(int val) {
		return val == 0 ? 1.0 : 0.0;
	}


}
