package com.songyi.devenv.domain.provisioning.configuration;

import com.songyi.devenv.domain.provisioning.enums.ProjectType;

public record ProvisioningConfiguration(ProjectType projectType, CloudConfiguration cloudConfig,
                                        CicdConfiguration cicdConfig) {

    public void validate() {
        if (projectType == null) throw new IllegalArgumentException("프로젝트 타입은 필수입니다.");
        cloudConfig.validate();
        cicdConfig.validate();
    }
}
