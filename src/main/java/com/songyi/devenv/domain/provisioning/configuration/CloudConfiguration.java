package com.songyi.devenv.domain.provisioning.configuration;

import com.songyi.devenv.infrastructure.enums.CloudProvider;
import com.songyi.devenv.infrastructure.enums.CloudResourceType;

import java.util.List;

public record CloudConfiguration(
        CloudProvider provider,
        String region,
        List<CloudResourceType> resources
) {
    public void validate() {
        if (provider == null) throw new IllegalArgumentException("클라우드 프로바이더는 필수입니다.");
        if (region == null || region.trim().isEmpty()) throw new IllegalArgumentException("리전은 필수입니다.");
        if (resources == null || resources.isEmpty()) throw new IllegalArgumentException("최소 하나 이상의 리소스를 지정해야 합니다.");
    }
}
