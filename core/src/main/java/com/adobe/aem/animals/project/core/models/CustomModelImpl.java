package com.adobe.aem.animals.project.core.models;

import com.adobe.aem.animals.project.core.services.CustomService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(
        adaptables = {Resource.class},
        adapters = {CustomModel.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class CustomModelImpl implements CustomModel{

    protected static final String RESOURCE_TYPE = "animals/components/custom";
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomModelImpl.class);

    @Inject
    String projectName;

    @OSGiService
    CustomService customService;

    @PostConstruct
    protected void init() {
        projectName = customService.getProjectName();
        LOGGER.info("Retrieved project name from custom service");
    }

    @Override
    public String getProjectName() {
        return projectName;
    }
}
