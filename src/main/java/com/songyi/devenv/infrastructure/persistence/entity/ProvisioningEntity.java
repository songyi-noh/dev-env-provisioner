package com.songyi.devenv.infrastructure.persistence.entity;

import com.songyi.devenv.domain.provisioning.enums.ProvisioningStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "provisioning")
public class ProvisioningEntity {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @NotNull
    private String projectName;
    @Enumerated(EnumType.STRING)
    @NotNull
    private ProvisioningStatus status;
    @OneToMany(mappedBy = "provisioning", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProvisioningStepEntity> steps = new ArrayList<>();
    @Embedded
    private ProvisioningConfigurationEntity configuration;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}
