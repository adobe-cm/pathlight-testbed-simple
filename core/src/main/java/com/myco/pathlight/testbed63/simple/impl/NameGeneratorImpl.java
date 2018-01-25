package com.myco.pathlight.testbed63.simple.impl;

import com.myco.pathlight.testbed63.simple.NameGenerator;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@Component
@Designate(ocd = NameGeneratorImpl.Config.class)
public class NameGeneratorImpl implements NameGenerator {

    private String name;

    @Activate
    protected void activate(Config config) {
        this.name = config.name();
    }

    @Override
    public String generateName() {
        return name;
    }

    @ObjectClassDefinition
    public @interface Config {

        String name() default "Pathlight";
    }
}
