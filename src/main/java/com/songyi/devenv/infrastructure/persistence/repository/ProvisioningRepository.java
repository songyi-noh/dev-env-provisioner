package com.songyi.devenv.infrastructure.persistence.repository;

import com.songyi.devenv.domain.provisioning.enums.ProvisioningStatus;
import com.songyi.devenv.infrastructure.persistence.entity.ProvisioningEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProvisioningRepository extends JpaRepository<ProvisioningEntity, String> {
    // 프로비저닝 요청 저장

    // ID로 프로비저닝 조회

    // 프로젝트 이름으로 프로비저닝 조회
    Optional<ProvisioningEntity> findByProjectName(String projectName);

    // 상태별 프로비저닝 목록 조회
    List<ProvisioningEntity> findAllByStatus(ProvisioningStatus status);

    // 프로비저닝 상태 업데이트

    // 특정 기간 내 프로비저닝 조회
    List<ProvisioningEntity> findAllByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);
}
