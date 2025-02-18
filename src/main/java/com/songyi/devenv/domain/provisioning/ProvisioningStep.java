package com.songyi.devenv.domain.provisioning;

import com.songyi.devenv.domain.provisioning.enums.StepStatus;
import com.songyi.devenv.domain.provisioning.enums.StepType;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ProvisioningStep {
    private final StepType type;
    private StepStatus status;
    @Setter
    private String resourceId;
    private String errorMessage;

    public ProvisioningStep(StepType type) {
        this.type = type;
        this.status = StepStatus.PENDING;
    }

    public void start() {
        if(this.status != StepStatus.PENDING) throw new IllegalStateException("PENDING 상태의 단계만 시작할 수 있습니다.");
        this.status = StepStatus.IN_PROGRESS;
    }

    public void complete() {
        if(this.status != StepStatus.IN_PROGRESS) throw new IllegalStateException("IN_PROGRESS 상태의 단계만 완료할 수 있습니다.");
        this.status = StepStatus.COMPLETED;
    }

    public void fail(String reason) {
        this.status = StepStatus.FAILED;
        this.errorMessage = reason;
    }

}
