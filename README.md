# DevBase: 프로젝트 개요

DevBase는 멀티모듈 기반의 서버 스켈레톤 프로젝트로, 지속 가능성과 확장성을 목표로 설계되었습니다.
이 스켈레톤은 프레젠테이션 레이어, 도메인 레이어, 스토리지 레이어로 명확히 분리된 구조를 갖추고 있으며,
추가적으로 지원 모듈과 유틸리티 레이어를 포함하여 모든 개발자가 동일한 기준에서 작업할 수 있도록 설계되었습니다.

---
# 프로젝트 구조

```
root/
├── core/                            # 코어 모듈 폴더
│   ├── core-api/                    # 공통 API 구성 요소 및 인터페이스 모듈
│   ├── core-batch/                  # 공통 배치 구성 요소 및 인터페이스 모듈
│   └── core-enum/                   # 공통 Enum 정의 모듈
├── domain/                          # 도메인 모듈 폴더
│   └── domain-core/                 # 도메인 비즈니스 로직 모듈
├── storage/                         # 데이터 저장소 관련 모듈
│   ├── db-core/                     # RDS 접근 및 엔티티 관리 모듈
│   ├── db-cache/                    # 캐시 관리 모듈
│   └── db-index/                    # NOSQL 관리 모듈
├── support/                         # 지원 모듈 폴더
│   ├── logging/                     # 로깅 모듈
│   └── utils/                       # 공통 유틸리티 모듈
├── tests/                           # 테스트 모듈 폴더
│   └── api-docs/                    # API 문서화 및 테스트 모듈
├── external-client/                 # 외부 API 요청, 응답 로직 모듈
├── build.gradle                     # Gradle 빌드 설정 파일
├── gradle.properties                # Gradle 프로퍼티 파일 (의존성 버전 관리)
└── settings.gradle                  # Gradle 설정 파일
```


---

# 레이어 설명

1. **Core Layer**
   - core-api: 프로젝트 전반에서 사용되는 공통 인터페이스 정의.
   - core-batch: 배치 작업과 관련된 공통 구성 요소.
   - core-enum: 프로젝트 전역에서 사용되는 Enum 정의.

2. **Domain Layer**
   - domain-core: 핵심 도메인 로직과 비즈니스 규칙이 구현된 모듈.

3. **Storage Layer**
   - db-core: 관계형 데이터베이스(RDS)를 통한 엔티티 관리와 데이터 접근.
   - db-cache: Redis를 활용한 캐싱 로직.
   - db-index: Elasticsearch 기반의 도큐먼트 관리.

4. **Support Layer**
   - logging: 로깅 구성 요소 및 모니터링 로직.
   - utils: 공통적으로 사용되는 유틸리티 함수 및 클래스.
   
5. **External Layer**
   - 외부 API와 내부 도메인 로직이 분리되어 변경에 유연함.
   - 어댑터를 통해 외부 형식을 캡슐화하여, 도메인 계층에서 외부 형식에 의존하지 않음.
   - 어댑터와 클라이언트를 분리했기 때문에 Mocking으로 테스트 가능.

6. **Tests**
   - api-docs: API 테스트 및 문서화 작업을 위한 모듈.

---


# 개발 가이드


1. **브랜치 전략**:

- main: 배포 가능한 안정된 코드.
- develop: 개발 진행 중인 코드.
- feature/<모듈 이름>/<기능 이름>: 새로운 기능 개발.
- hotfix/<이슈 이름>: 긴급 수정 사항.

2. **코딩 컨벤션**:

- 모든 코드 스타일은 프로젝트에 설정된 린터(Checkstyle, Spotless 등)를 따릅니다.
- CI/CD에서 컨벤션 위반 시 빌드가 실패합니다.

3. **자동화된 코드 리뷰**:

- PR 생성 시 GitLab CI/CD를 통해 코드 품질 및 테스트 커버리지를 자동으로 평가합니다.
- 특정 기준에 미달하는 경우 PR이 자동으로 반려됩니다.
- 
4. **문서화**:
- 모든 API는 tests/api-docs 모듈을 통해 자동으로 문서화됩니다.
-  Cucumber를 활용해 비즈니스 로직을 자연어로 표현하여, 새로운 팀원도 추가적인 설명 없이 프로젝트의 흐름을 쉽게 이해할 수 있습니다

---



