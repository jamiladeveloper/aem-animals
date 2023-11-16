package com.adobe.aem.animals.project.core.configs;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(
        name = "Animals Project - Custom Configuration",
        description = "This is a custom configuration for practice purpose"
)
public @interface CustomConfiguration {

    @AttributeDefinition(
            name = "Project Name",
            description = "This is the project name"
    )
    String getProjectName();
}
