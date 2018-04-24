/*
 * Copyright (C) 2011 Johan Andren <johan@com.markatta.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.markatta.stackdetective.distance;


public interface DistanceAlgorithm<T> {
    /**
     * Calculate distance between <code>a</code> and <code>b</code>
     * @return a float value between 1 (identic) and 0 (not at all alike) 
     */
    double calculateDistance(T a, T b);
    
}
