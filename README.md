# WordCounterAPI

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.3-blue.svg)](https://gradle.org/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

텍스트 분석 기능을 제공하는 **Spring Boot 기반 REST API**입니다.  
다양한 텍스트 통계 정보와 단어 빈도 분석을 통해 텍스트의 특성을 파악할 수 있습니다.

## 📋 목차

- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [빠른 시작](#-빠른-시작)
- [API 가이드](#-api-가이드)
- [프로젝트 구조](#-프로젝트-구조)
- [테스트](#-테스트)
- [개발 환경 설정](#-개발-환경-설정)

## ✨ 주요 기능

### 🔍 텍스트 통계 분석
- **총 글자 수** 계산 (공백 포함/제외)
- **단어 수** 및 **줄 수** 분석  
- **평균 단어 길이** 계산

### 📊 고급 분석
- **단어 빈도 분석**: 각 단어의 출현 횟수 계산
- **최빈 단어 식별**: 가장 많이 사용된 단어 추출
- **다국어 지원**: 한글, 영어 등 다양한 언어 텍스트 분석
- **특수문자 처리**: 구두점 및 특수문자를 제외한 순수 텍스트 분석

## 🛠 기술 스택

| 기술 | 버전 | 용도 |
|------|------|------|
| **Java** | 17+ | 백엔드 언어 |
| **Spring Boot** | 3.5.5 | 애플리케이션 프레임워크 |
| **Spring Web MVC** | 6.2.11 | REST API 구현 |
| **Gradle** | 8.14.3 | 빌드 도구 |
| **JUnit 5** | - | 테스트 프레임워크 |

## 🚀 빠른 시작

### 사전 요구사항

```bash
java --version    # Java 17 이상 필요
gradle --version  # Gradle 8.14.3 이상 필요
```

### 설치 및 실행

1. **저장소 클론**
   ```bash
   git clone https://github.com/your-username/WordCounterAPI.git
   cd WordCounterAPI
   ```

2. **실행 권한 부여** (Linux/Mac)
   ```bash
   chmod +x gradlew
   ```

3. **프로젝트 빌드**
   ```bash
   ./gradlew clean build
   ```

4. **애플리케이션 실행**
   ```bash
   ./gradlew bootRun
   ```

5. **실행 확인**
   - 서버: `http://localhost:8080`
   - Health Check: `http://localhost:8080/api/word-counter/health`

## 📖 API 가이드

### Base URL
```
http://localhost:8080/api/word-counter
```

### 1. 텍스트 분석 API

**`POST /analyze`**

주어진 텍스트를 분석하여 다양한 통계 정보를 반환합니다.

#### 요청 예시
```http
POST /api/word-counter/analyze
Content-Type: application/json

{
  "text": "안녕하세요! 이것은 테스트 텍스트입니다.\n단어 빈도를 분석해보겠습니다."
}
```

#### 응답 예시
```json
{
  "totalCharacters": 48,
  "charactersWithoutSpaces": 41,
  "wordCount": 7,
  "lineCount": 2,
  "wordFrequency": {
    "안녕하세요": 1,
    "이것은": 1,
    "테스트": 1,
    "텍스트입니다": 1,
    "단어": 1,
    "빈도를": 1,
    "분석해보겠습니다": 1
  },
  "mostFrequentWord": "안녕하세요",
  "averageWordLength": 5.857142857142857
}
```

#### 응답 필드 설명

| 필드 | 타입 | 설명 |
|------|------|------|
| `totalCharacters` | Integer | 총 글자 수 (공백 및 특수문자 포함) |
| `charactersWithoutSpaces` | Integer | 공백 제외 글자 수 |
| `wordCount` | Integer | 총 단어 수 |
| `lineCount` | Integer | 총 줄 수 |
| `wordFrequency` | Object | 단어별 빈도수 (특수문자 제외, 소문자 변환) |
| `mostFrequentWord` | String | 최빈 단어 |
| `averageWordLength` | Double | 평균 단어 길이 (특수문자 제외) |

#### 오류 응답

**400 Bad Request**: 텍스트가 비어있거나 null인 경우
```http
HTTP/1.1 400 Bad Request
```

**500 Internal Server Error**: 서버 내부 오류
```http
HTTP/1.1 500 Internal Server Error
```

### 2. Health Check API

**`GET /health`**

애플리케이션의 상태를 확인합니다.

#### 응답 예시
```http
HTTP/1.1 200 OK
Content-Type: text/plain

Word Counter API is running
```

## 📁 프로젝트 구조

```
WordCounterAPI/
├── src/
│   ├── main/
│   │   ├── java/com/kobe/wordcounterapi/
│   │   │   ├── WordCounterApiApplication.java     # 메인 애플리케이션 클래스
│   │   │   ├── controller/
│   │   │   │   └── WordCounterController.java     # REST API 컨트롤러
│   │   │   ├── service/
│   │   │   │   └── WordCounterService.java        # 텍스트 분석 서비스
│   │   │   └── model/
│   │   │       ├── TextInput.java                 # 요청 데이터 모델
│   │   │       └── WordCountResult.java           # 응답 데이터 모델
│   │   └── resources/
│   │       └── application.yml                    # 애플리케이션 설정
│   └── test/
│       └── java/com/kobe/wordcounterapi/
│           ├── WordCounterApiApplicationTests.java # 통합 테스트
│           └── WordCounterServiceTest.java        # 서비스 단위 테스트
├── gradle/wrapper/                                # Gradle Wrapper 설정
├── build.gradle                                   # Gradle 빌드 설정
├── settings.gradle                               # Gradle 프로젝트 설정
├── .gitignore                                    # Git 무시 파일 설정
└── README.md                                     # 프로젝트 문서
```

## 🧪 테스트

프로젝트는 포괄적인 테스트 스위트를 포함하고 있습니다.

### 테스트 실행

**전체 테스트 실행**
```bash
./gradlew test
```

**특정 테스트 클래스 실행**
```bash
./gradlew test --tests WordCounterServiceTest
```

**테스트 결과 확인**
- **콘솔 출력**: 실시간 테스트 결과
- **HTML 리포트**: `build/reports/tests/test/index.html`

### 테스트 커버리지

커버리지 리포트 생성 (Jacoco 플러그인 추가 시):
```bash
./gradlew jacocoTestReport
```

### 테스트 케이스

현재 구현된 테스트:

- **기본 텍스트 분석**: 영어 텍스트의 기본 통계 계산
- **빈 텍스트 처리**: 빈 문자열에 대한 안전한 처리
- **공백 전용 텍스트**: 공백만 포함된 텍스트 처리
- **다중 라인 텍스트**: 줄바꿈이 포함된 텍스트 분석
- **한글 텍스트**: 한국어 텍스트 분석 및 빈도 계산
- **단어 빈도 분석**: 단어 출현 빈도 및 최빈 단어 찾기

## 🔧 개발 환경 설정

### IDE 설정

**IntelliJ IDEA**
```bash
./gradlew idea
```

**Eclipse**
```bash
./gradlew eclipse
```

### 개발 서버 실행

Hot reload를 위한 개발 서버:
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

### 로깅 설정

애플리케이션은 다음과 같은 로깅을 제공합니다:

- **로그 레벨**: `com.kobe.wordcounterapi` 패키지는 DEBUG 레벨
- **콘솔 출력**: 타임스탬프와 메시지 형태
- **설정 파일**: `src/main/resources/application.yml`

### CORS 설정

현재 모든 오리진(`*`)에서의 요청을 허용하도록 설정되어 있습니다. 프로덕션 환경에서는 특정 도메인으로 제한하는 것을 권장합니다.

```java
@CrossOrigin(origins = "*")  // 프로덕션에서는 구체적인 도메인으로 변경
```

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### 코딩 컨벤션

- **패키지 명명**: `com.kobe.wordcounterapi.{layer}`
- **클래스 명명**: PascalCase
- **메소드 명명**: camelCase
- **상수**: UPPER_SNAKE_CASE
- **주석**: JavaDoc 형태로 작성

## 📄 라이선스

This project is licensed under the MIT License - see the `LICENSE` file for details.

## 🐛 이슈 리포팅

버그 리포트나 기능 요청은 [GitHub Issues](https://github.com/your-username/WordCounterAPI/issues)에 등록해주세요.

## 📞 문의

프로젝트에 대한 질문이나 제안사항이 있으시면 이슈를 생성해주세요.

---

⭐ 이 프로젝트가 도움이 되셨다면 Star를 눌러주세요!