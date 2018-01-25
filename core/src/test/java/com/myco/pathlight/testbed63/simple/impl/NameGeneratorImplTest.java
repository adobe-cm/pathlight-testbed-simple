package com.myco.pathlight.testbed63.simple.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class NameGeneratorImplTest {

    @Test
    public void testFromConfig() {
        final String testString = RandomStringUtils.randomAlphanumeric(10);
        NameGeneratorImpl.Config config = mock(NameGeneratorImpl.Config.class);
        when(config.name()).thenReturn(testString);

        NameGeneratorImpl underTest = new NameGeneratorImpl();
        underTest.activate(config);

        assertEquals(testString, underTest.generateName());

    }

}