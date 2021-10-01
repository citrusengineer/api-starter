package com.citrus.engineer.automation.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class EnvironmentUtils {

    private static final String ENV_PROPERTY = System.getProperty("env", "stage").toLowerCase();
    private static final String ENV_FILE = "environments/env."+ENV_PROPERTY+".yaml";

    private static Environment environment;

    public static synchronized Environment get(){

        if (environment==null){
            File envFile;

            try {
                envFile = new File(Objects.requireNonNull(EnvironmentUtils.class.getClassLoader().getResource(ENV_FILE)).toURI());
                ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
                environment = mapper.readValue(envFile, Environment.class);
            }catch(URISyntaxException | IOException e){
                throw new IllegalStateException(e);
            }
        }
        return environment;
    }
}
