package com.adobe.aem.animals.project.core.services;

import com.adobe.aem.animals.project.core.configs.CustomConfiguration;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(
        service = CustomService.class,
        immediate = true,
        property = {
                Constants.SERVICE_ID + "=Custom Service",
                Constants.SERVICE_DESCRIPTION + "=This is a sample custom services which reads values from the Custom Configuration"
        }
)
@Designate(ocd = CustomConfiguration.class)
public class CustomServiceImpl implements CustomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomServiceImpl.class);

    private CustomConfiguration configuration;

    @Activate
    protected void activate(CustomConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public String getProjectName() {
        LOGGER.info("Reading project name from Custom configuration");
        return configuration.getProjectName() == null ? "Fail" : configuration.getProjectName();
    }
}
