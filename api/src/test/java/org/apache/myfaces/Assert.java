/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.myfaces;

/**
 * Provides various assert calls which can be used for tests.
 * 
 * @author Mathias Broekelmann (latest modification by $Author$)
 * @version $Revision$ $Date$
 */
public class Assert
{
    protected Assert()
    {
    }

    /**
     * Asserts that the execution of the {@link TestRunner#run()} method will throw the <code>expected</code>
     * exception
     * 
     * @param expected
     *            the expected Exception
     * @param testCase
     *            the testcase to run
     */
    public static void assertException(Class<? extends Throwable> expected, TestRunner testCase)
    {
        junit.framework.Assert.assertNotNull(expected);
        junit.framework.Assert.assertNotNull(testCase);
        try
        {
            testCase.run();
        }
        catch (Throwable e)
        {
            if (!expected.isAssignableFrom(e.getClass()))
            {
                junit.framework.Assert.fail("caught exception <" + e.getClass() + "> does not match expected <"
                        + expected + ">: " + e.getMessage());
            }
        }
        junit.framework.Assert.fail(expected + " expected");
    }

}