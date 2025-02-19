package com.songyi.devenv.infrastructure.persistence.repository;

import com.songyi.devenv.domain.provisioning.enums.StepStatus;
import com.songyi.devenv.domain.provisioning.enums.StepType;
import com.songyi.devenv.infrastructure.persistence.entity.ProvisioningStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProvisioningStepRepository extends JpaRepository<ProvisioningStepEntity, Long> {

    // 실패한 단계 조회(롤백 처리용)
    List<ProvisioningStepEntity> findAllByStatus(StepStatus status);

    // StepType 별 단계 조회
    List<ProvisioningStepEntity> findAllByType(StepType type);
}