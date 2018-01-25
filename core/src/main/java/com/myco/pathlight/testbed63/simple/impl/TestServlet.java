package com.myco.pathlight.testbed63.simple.impl;

import com.myco.pathlight.testbed63.simple.NameGenerator;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.Nonnull;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(property = {
        "sling.servlet.resourceTypes=myco/pathlight/testbed63/simple/test",
        "sling.servlet.extensions=txt"
}, service = Servlet.class)
public class TestServlet extends SlingSafeMethodsServlet {

    @Reference
    private NameGenerator nameGenerator;

    @Override
    protected void doGet(@Nonnull SlingHttpServletRequest request, @Nonnull SlingHttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.getWriter().println(nameGenerator.generateName());
    }
}
