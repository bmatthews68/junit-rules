/*
 * Copyright 2013 Brian Thomas Matthews
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.btmatthews.junit.rules;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.powermock.api.mockito.PowerMockito.mockStatic;

/**
 * Unit test the {@link LoggingRule} JUnit rule.
 *
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 * @since 1.0.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(LoggerFactory.class)
public class TestLoggingRule {

    /**
     * Mock the SLF4J logging object.
     */
    @Mock
    private Logger logger;
    /**
     * The {@link LoggingRule} test fixture.
     */
    private TestRule rule;

    /**
     * Initalize mock objects and test fixtures.
     */
    @Before
    public void setup() {
        initMocks(this);
        rule = new LoggingRule();
        mockStatic(LoggerFactory.class);
        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(logger);
    }

    /**
     * Verify that the start and finish message are logged when a test case executes without
     * an exception.
     *
     * @throws Throwable Required by {@link org.junit.runners.model.Statement#evaluate()} but no exception should be thrown.
     */
    @Test
    public void logsStartAndFinish() throws Throwable {
        final Description description = Description.createTestDescription(TestLoggingRule.class, "logsStartAndFinish");
        rule.apply(new Statement() {
            @Override
            public void evaluate() {
            }
        }, description).evaluate();
        verify(logger).info(eq("Starting test case [logsStartAndFinish(com.btmatthews.junit.rules.TestLoggingRule)]"));
        verify(logger).info(eq("Finished test case [logsStartAndFinish(com.btmatthews.junit.rules.TestLoggingRule)]"));
        verifyNoMoreInteractions(logger);
    }

    /**
     * Verify that the start, exception and finish message are logged when a test case throws an exception during execution.
     */
    @Test
    public void logsStartExceptionAndFinish() {
        final Description description = Description.createTestDescription(TestLoggingRule.class, "logsStartExceptionAndFinish");
        try {
            rule.apply(new Statement() {
                @Override
                public void evaluate() throws Throwable {
                    throw new Exception();
                }
            }, description).evaluate();
            fail();
        } catch (final Throwable e) {
            verify(logger).info(eq("Starting test case [logsStartExceptionAndFinish(com.btmatthews.junit.rules.TestLoggingRule)]"));
            verify(logger).info(eq("Exception thrown in test case [logsStartExceptionAndFinish(com.btmatthews.junit.rules.TestLoggingRule)]"), any(Exception.class));
            verify(logger).info(eq("Finished test case [logsStartExceptionAndFinish(com.btmatthews.junit.rules.TestLoggingRule)]"));
            verifyNoMoreInteractions(logger);
        }
    }
}
