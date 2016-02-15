JUnit Rules
===========

![Build Status](https://codeship.com/projects/0ec65960-b5ae-0133-ac0b-4a56b254b363/status?branch=master)

This library contains a collection of JUnit rules for enhancing JUnit test cases.

LoggingRule
-----------

The **LoggingRule** delineates individual test cases with log messages using the [SLF4J](http://slf4j.org) logging framework.

### Usage

To use the **LoggingRule** in your test case you just need to add the following rule
declaration.

```java
@Rule
public LoggingRule loggingRule = new LoggingRule();
```

### Example

Below are a couple of sample JUnit tests and the logging output that those tests would generate:

#### Test Case

```java
package com.btmatthews.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.btmatthews.junit.rules.LoggingRule;

public class TestCase {

  @Rule
  public LoggingRule loggingRule = new LoggingRule();

  @Test
  public void succeedsBecauseItDoesNothing() {
  }

  @Test
  public void failsBecauseAnExceptionIsThrown() throws Exception {
    throw new Exception();
  }
}
```

#### Log output

```
[main] INFO com.btmatthews.test.TestCase - Starting test case [failsBecauseAnExceptionIsThrown(com.btmatthews.test.TestCase)]
[main] INFO com.btmatthews.test.TestCase - Exception thrown in test case [failsBecauseAnExceptionIsThrown(com.btmatthews.test.TestCase)]
java.lang.Exception
	at com.btmatthews.test.TestCase.throwException(TestCase.java:18)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:601)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:47)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:44)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at com.btmatthews.junit.rules.LoggingRule$1.evaluate(LoggingRule.java:68)
	at org.junit.rules.RunRules.evaluate(RunRules.java:20)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:271)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:70)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:50)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:309)
	at org.junit.runner.JUnitCore.run(JUnitCore.java:160)
	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:74)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:196)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:64)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:601)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:120)
[main] INFO com.btmatthews.test.TestCase - Finished test case [failsBecauseAnExceptionIsThrown(com.btmatthews.test.TestCase)]
[main] INFO com.btmatthews.test.TestCase - Starting test case [succeedsBecauseItDoesNothing(com.btmatthews.test.TestCase)]
[main] INFO com.btmatthews.test.TestCase - Finished test case [succeedsBecauseItDoesNothing(com.btmatthews.test.TestCase)]
```

Maven Central Coordinates
-------------------------
**JUnit Rules** has been published in [Maven Central](http://search.maven.org) at the following
coordinates:

```xml
<dependency>
    <groupId>com.btmatthews.junit.rules</groupId>
    <artifactId>junit-rules</artifactId>
    <version>1.0.0</version>
</dependency>
```

License & Source Code
---------------------
The **JUnit Rules** is made available under the
[Apache License](http://www.apache.org/licenses/LICENSE-2.0.html) and the source code is hosted on
[GitHub](http://github.com) at https://github.com/bmatthews68/junit-rules.
