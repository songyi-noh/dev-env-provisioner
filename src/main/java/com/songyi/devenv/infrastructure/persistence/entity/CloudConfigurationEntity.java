package com.songyi.devenv.infrastructure.persistence.entity;

import com.songyi.devenv.infrastructure.enums.CloudProvider;
import com.songyi.devenv.infrastructure.enums.CloudResourceType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Embeddable
public class CloudConfigurationEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "cloud_provider", nullable = false)
    private CloudProvider provider;
    @NotNull
    private String region;
    @ElementCollection
    @CollectionTable(
            name = "cloud_resources",
            joinColumns = @JoinColumn(name = "provisioning_id")
    )
    @Column(name = "resource_type")
    @Enumerated(EnumType.STRING)
    private List<CloudResourceType> resources = new ArrayList<>();

}
