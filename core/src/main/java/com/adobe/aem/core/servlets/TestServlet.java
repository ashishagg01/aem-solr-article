package com.adobe.aem.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.core.TestConfiguration;

@Component(immediate = true, metatype = true)
@Service(Servlet.class)
@Properties({
        @Property(name = "sling.servlet.methods", value = "GET"),
        @Property(name = "sling.servlet.paths", value = "/bin/solr/ashish/test") })
public class TestServlet extends SlingAllMethodsServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 3041890690813355354L;

    private static final Logger LOG = LoggerFactory
            .getLogger(IndexContentToSolr.class);

    @Reference
    TestConfiguration testConfiguration;

    @Override
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
        response.setContentType("text/html");
        response.getWriter()
                .write("<h3>Successfully :" + testConfiguration.getTestData());
    }
}
