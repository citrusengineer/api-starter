package com.citrus.engineer.automation.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties
@Data
public class Environment {

    private Domains domains;
}
