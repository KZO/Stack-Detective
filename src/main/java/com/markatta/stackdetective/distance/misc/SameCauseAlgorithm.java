package com.markatta.stackdetective.distance.misc;

import com.markatta.stackdetective.distance.DistanceAlgorithm;
import com.markatta.stackdetective.model.Entry;
import com.markatta.stackdetective.model.StackTrace;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public class SameCauseAlgorithm implements DistanceAlgorithm<StackTrace> {

	@Override
	public double calculateDistance(StackTrace a, StackTrace b) {
		// if both empty decide that is same
		if (a.getCauseSegment().getEntries().isEmpty() && b.getCauseSegment().getEntries().isEmpty()) {
			return 1.0;
		}
		
		Optional<Entry> firstEntryOfA = a.getCauseSegment().getEntries().stream().findFirst();
		Optional<Entry> firstEntryOfB = b.getCauseSegment().getEntries().stream().findFirst();

		return firstEntryOfA.flatMap(entry1 -> firstEntryOfB.map(entry2 -> Pair.of(entry1, entry2)))
				.map(this::compareByClassAndMethodNames)
				.orElse(false) ? 1.0 : 0.0;
	}

	private boolean compareByClassAndMethodNames(Pair<Entry,Entry> entries) {
		Entry entry1 = entries.getLeft();
		Entry entry2 = entries.getRight();

		return entry1.getClassName().equals(entry2.getClassName()) &&
			   entry1.getMethodName().equals(entry2.getMethodName());
	}

}
