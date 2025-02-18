# Development Environment Provisioning System

개발 환경 프로비저닝을 자동화하는 시스템입니다. GitHub 레포지토리 생성부터 클라우드 리소스 프로비저닝, CI/CD 파이프라인 구성까지 한 번에 자동화합니다.

## 기능 소개

### 코어 기능
- GitHub 레포지토리 자동 생성 및 템플릿 적용
- AWS/Azure 클라우드 리소스 자동 프로비저닝
- GitHub Actions/Jenkins CI/CD 파이프라인 자동 구성
- ArgoCD 배포 환경 자동 설정
- 모니터링 시스템 자동 구성

### 주요 특징
- 분산 트랜잭션 처리로 안정적인 리소스 관리
- 실패 시 자동 롤백
- 멀티 클라우드 지원
- 커스터마이징 가능한 템플릿
- 실시간 프로비저닝 상태 모니터링

## 기술 스택

### Backend
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- Spring for Kafka

### Infrastructure
- GitHub API
- Azure SDK
- Kafka
- PostgreSQL

### DevOps
- GitHub Actions
- ArgoCD
- Docker
- Kubernetes

## 프로젝트 구조
```
dev-env-provisioner/
├── domain/           # 핵심 도메인 로직
├── infrastructure/   # 외부 시스템 연동
└── api/             # REST API 엔드포인트
```

## 시스템 아키텍처
- DDD (Domain-Driven Design) 기반 설계
- 이벤트 기반 아키텍처
- Saga 패턴을 활용한 분산 트랜잭션 처리

## 개발 로드맵

### Phase 1: 기본 프레임워크 구축
- [ ] 프로젝트 초기 설정
- [ ] 도메인 모델 설계
- [ ] 이벤트 처리 기본 구조 구현

### Phase 2: GitHub 통합
- [ ] GitHub API 연동
- [ ] 레포지토리 생성 자동화
- [ ] 템플릿 적용 기능

### Phase 3: 클라우드 통합
- [ ] AWS/Azure SDK 연동
- [ ] 리소스 프로비저닝 자동화
- [ ] 리소스 롤백 처리

### Phase 4: CI/CD 파이프라인
- [ ] GitHub Actions 템플릿 자동화
- [ ] ArgoCD 설정 자동화
- [ ] 파이프라인 모니터링

## API 스펙

### 프로비저닝 요청
```json
POST /api/v1/provisioning
{
  "projectName": "my-service",
  "projectType": "SPRING_BOOT",
  "cloud": {
    "provider": "AWS",
    "region": "ap-northeast-2",
    "resources": ["ECS", "RDS_POSTGRESQL"]
  },
  "cicd": {
    "provider": "GITHUB_ACTIONS",
    "deployment": "ARGOCD",
    "environments": ["dev", "staging", "prod"]
  }
}
```

## 사용 예시
1. 프로비저닝 요청 API 호출
2. 자동으로 GitHub 레포지토리 생성 및 템플릿 적용
3. AWS 리소스 프로비저닝 (ECS, RDS 등)
4. GitHub Actions 워크플로우 설정
5. ArgoCD 애플리케이션 구성
6. 실시간으로 진행 상황 모니터링

## 실행 방법
```bash
# 추후 업데이트 예정
```

## 기여 방법
```bash
# 추후 업데이트 예정
```