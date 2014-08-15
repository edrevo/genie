/*
 *
 *  Copyright 2014 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package com.netflix.genie.common.model;

import com.netflix.genie.common.exceptions.GenieException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for the ClusterStatus enum.
 *
 * @author tgianos
 */
public class TestClusterStatus {

    /**
     * Tests whether a valid cluster status is parsed correctly.
     *
     * @throws GenieException
     */
    @Test
    public void testValidClusterStatus() throws GenieException {
        Assert.assertEquals(ClusterStatus.UP,
                ClusterStatus.parse(ClusterStatus.UP.name().toLowerCase()));
        Assert.assertEquals(ClusterStatus.OUT_OF_SERVICE,
                ClusterStatus.parse(ClusterStatus.OUT_OF_SERVICE.name().toLowerCase()));
        Assert.assertEquals(ClusterStatus.TERMINATED,
                ClusterStatus.parse(ClusterStatus.TERMINATED.name().toLowerCase()));
    }

    /**
     * Tests whether an invalid cluster status throws exception.
     *
     * @throws GenieException
     */
    @Test(expected = GenieException.class)
    public void testInvalidClusterStatus() throws GenieException {
        ClusterStatus.parse("DOES_NOT_EXIST");
    }

    /**
     * Tests whether an invalid cluster status throws exception.
     *
     * @throws GenieException
     */
    @Test(expected = GenieException.class)
    public void testBlankClusterStatus() throws GenieException {
        ClusterStatus.parse(null);
    }
}