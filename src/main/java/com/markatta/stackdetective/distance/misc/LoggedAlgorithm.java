package com.markatta.stackdetective.distance.misc;

import com.markatta.stackdetective.distance.DistanceAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bekrenev Dmitry
 */
public class LoggedAlgorithm<T> implements DistanceAlgorithm<T> {
    private DistanceAlgorithm<T> algorithm;
    private Logger logger;

    public LoggedAlgorithm(DistanceAlgorithm<T> algorithm) {
        this.logger = LoggerFactory.getLogger(algorithm.getClass());

        this.algorithm = algorithm;
    }

    @Override
    public double calculateDistance(T a, T b) {
        double distance = algorithm.calculateDistance(a, b);
        logger.debug("Distance: {}", distance);
        return distance;
    }
}
