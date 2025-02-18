package com.songyi.devenv.domain.provisioning;

import com.songyi.devenv.domain.provisioning.configuration.ProvisioningConfiguration;
import com.songyi.devenv.domain.provisioning.enums.ProvisioningStatus;
import com.songyi.devenv.domain.provisioning.enums.StepStatus;
import com.songyi.devenv.domain.provisioning.enums.StepType;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
* Provisioning
* 프로비저닝 전체 프로세스를 관리하는 Aggregate Root
* 프로비저닝 단계들을 초기화하고 관리
* */

@Getter
public class Provisioning {
    private final String id;
    private String projectName;
    private ProvisioningStatus status;
    private List<ProvisioningStep> steps;
    private ProvisioningConfiguration configuration;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Provisioning(String projectName, ProvisioningConfiguration configuration) {
        this.id = UUID.randomUUID().toString();
        this.projectName = projectName;
        this.status = ProvisioningStatus.PENDING;
        this.steps = initializeSteps();
        this.configuration = configuration;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    private List<ProvisioningStep> initializeSteps() {
        List<ProvisioningStep> steps = new ArrayList<>();
        steps.add(new ProvisioningStep(StepType.GITHUB_REPOSITORY));
        steps.add(new ProvisioningStep(StepType.CLOUD_RESOURCE));
        steps.add(new ProvisioningStep(StepType.CICD_PIPELINE));
        return steps;
    }

    public void start() {
        validateCanStart();
        this.status = ProvisioningStatus.IN_PROGRESS;
        this.steps.get(0).start();
        updateTimestamp();
    }

    private void validateCanStart() {
        if(this.status != ProvisioningStatus.PENDING){
            throw new IllegalStateException("프로비저닝은 PENDING 상태에서만 시작할 수 있습니다.");
        }
        configuration.validate();
    }

    public void completeCurrentStep() {
        ProvisioningStep currentStep = getCurrentStep();
        currentStep.complete();
        if(hasNextStep()) {
            getNextStep().start();
        } else {
            this.status = ProvisioningStatus.COMPLETED;
        }
        updateTimestamp();
    }

    public void fail(String reason) {
        this.status = ProvisioningStatus.FAILED;
        getCurrentStep().fail(reason);
        updateTimestamp();
    }

    private ProvisioningStep getCurrentStep() {
        return steps.stream()
                .filter(step -> step.getStatus() == StepStatus.IN_PROGRESS)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("진행 중인 단계를 찾을 수 없습니다."));
    }

    private boolean hasNextStep() {
        return steps.stream()
                .anyMatch(step -> step.getStatus() == StepStatus.PENDING);
    }

    private ProvisioningStep getNextStep() {
        return steps.stream()
                .filter(step -> step.getStatus() == StepStatus.PENDING)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("다음 단계를 찾을 수 없습니다."));
    }

    private void updateTimestamp() {
        this.updatedAt = LocalDateTime.now();
    }

}
