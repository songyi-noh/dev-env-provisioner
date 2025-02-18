package com.songyi.devenv.domain.provisioning.configuration;

import com.songyi.devenv.domain.provisioning.enums.CicdProvider;

import java.util.List;

public record CicdConfiguration(
        CicdProvider provider,
        List<String> environments
) {
    public void validate() {
        if(provider == null) throw new IllegalArgumentException("CI/CD 프로바이더는 필수입니다.");
        if(environments == null || environments.isEmpty()) throw new IllegalArgumentException("최소 하나 이상의 환경을 지정해야 합니다.");
    }
}
