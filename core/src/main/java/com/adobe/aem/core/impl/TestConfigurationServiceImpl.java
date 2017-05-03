package com.adobe.aem.core.impl;

import java.net.MalformedURLException;
import java.util.Dictionary;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.aem.core.TestConfiguration;

@Component(
        label = "Test Configuration Service",
        description = "A service for configuring AEM to test",
        immediate = true,
        metatype = true)
@Service
public class TestConfigurationServiceImpl implements TestConfiguration {

    private static final Logger LOG = LoggerFactory.getLogger(TestConfigurationServiceImpl.class);

    private String testData;
    @Property(label = "TestData", value = "ashish", description = "any test data")
    public static final String TEST_DATA = "test.data";

    @Activate
    protected void activate(ComponentContext ctx) throws MalformedURLException {
        LOG.info("inside activate method in solr configuration service ");
        final Dictionary<?, ?> config = ctx.getProperties();
        testData = PropertiesUtil.toString(config.get(TEST_DATA), "ashish");
        LOG.info("this is the test data : {}", testData);
    }

    @Override
    public String getTestData() {
        return testData;
    }

}
