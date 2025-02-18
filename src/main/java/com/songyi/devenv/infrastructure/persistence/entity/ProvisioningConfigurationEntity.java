package com.songyi.devenv.infrastructure.persistence.entity;

import com.songyi.devenv.domain.provisioning.enums.ProjectType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Embeddable
public class ProvisioningConfigurationEntity {
    @Enumerated(EnumType.STRING)
    private ProjectType projectType;
    @Embedded
    private CloudConfigurationEntity cloudConfig;
    @Embedded
    private CicdConfigurationEntity cicdConfig;
}
