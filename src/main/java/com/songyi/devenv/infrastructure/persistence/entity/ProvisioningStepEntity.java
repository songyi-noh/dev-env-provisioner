package com.songyi.devenv.infrastructure.persistence.entity;

import com.songyi.devenv.domain.provisioning.enums.StepStatus;
import com.songyi.devenv.domain.provisioning.enums.StepType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
@Entity
@Table(name = "provisioning_step")
public class ProvisioningStepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @NotNull
    private StepType type;
    @Enumerated(EnumType.STRING)
    @NotNull
    private StepStatus status;
    private String resourceId;
    private String errorMessage;
}
