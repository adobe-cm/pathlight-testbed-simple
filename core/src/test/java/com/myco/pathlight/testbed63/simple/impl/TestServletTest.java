package com.myco.pathlight.testbed63.simple.impl;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.sling.testing.mock.sling.junit.SlingContext;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestServletTest {

    @Rule
    public final SlingContext context = new SlingContext();

    private TestServlet underTest = new TestServlet();

    @Test
    public void test() throws Exception {
        final String testString = RandomStringUtils.randomAlphanumeric(10);
        context.registerInjectActivateService(new NameGeneratorImpl(), "name", testString);
        context.registerInjectActivateService(underTest);

        MockSlingHttpServletResponse response = context.response();
        underTest.service(context.request(), response);
        assertEquals("text/plain", response.getContentType());
        assertEquals(testString, response.getOutputAsString().trim());
    }
}
