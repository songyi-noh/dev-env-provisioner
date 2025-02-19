package com.songyi.devenv.infrastructure.persistence.entity;

import com.songyi.devenv.infrastructure.enums.CicdProvider;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
public class CicdConfigurationEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "cicd_provider", nullable = false)
    private CicdProvider provider;
    @ElementCollection
    @CollectionTable(
            name = "cicd_environments",
            joinColumns = @JoinColumn(name = "provisioning_id")
    )
    @Column(name = "environment")
    private List<String> environments = new ArrayList<>();
}
