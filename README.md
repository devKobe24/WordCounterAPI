# WordCounterAPI

[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Gradle](https://img.shields.io/badge/Gradle-8.14.3+-blue.svg)](https://gradle.org/)

텍스트 분석 기능을 제공하는 **Spring Boot 기반 REST API**입니다.  
다양한 텍스트 통계 정보와 단어 빈도 분석을 통해 텍스트의 특성을 파악할 수 있습니다.

## 📋 목차

- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [빠른 시작](#-빠른-시작)
- [API 가이드](#-api-가이드)
- [테스트](#-테스트)
- [프로젝트 구조](#-프로젝트-구조)

## ✨ 주요 기능

### 🔍 텍스트 통계 분석
- **총 글자 수** 계산 (공백 포함/제외)
- **단어 수** 및 **줄 수** 분석
- **평균 단어 길이** 계산

### 📊 고급 분석
- **단어 빈도 분석**: 각 단어의 출현 횟수 계산
- **최빈 단어 식별**: 가장 많이 사용된 단어 추출
- **다국어 지원**: 한글, 영어 등 다양한 언어 텍스트 분석

## 🛠 기술 스택

| 기술 | 버전 | 용도 |
|------|------|------|
| **Java** | 17+ | 백엔드 언어 |
| **Spring Boot** | 3.x | 애플리케이션 프레임워크 |
| **Gradle** | 8.14.3+ | 빌드 도구 |
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

2. **프로젝트 빌드**
   ```bash
   ./gradlew clean build
   ```

3. **애플리케이션 실행**
   ```bash
   ./gradlew bootRun
   ```

4. **실행 확인**
   - 서버: `http://localhost:8080`
   - Health Check: `GET http://localhost:8080/api/word-counter/health`

## 📖 API 가이드

### Base URL
```
http://localhost:8080/api/word-counter
```

### 1. 텍스트 분석 API

**`POST /analyze`**

#### 요청 예시
```http
POST /api/word-counter/analyze
Content-Type: application/json

{
  "text": "안녕하세요! 이것은 테스트 텍스트입니다. 단어 빈도를 분석해보겠습니다."
}
```

#### 응답 예시
```json
{
  "totalCharacters": 42,
  "charactersWithoutSpaces": 35,
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
  "averageWordLength": 5.0
}
```

#### 응답 필드 설명

| 필드 | 타입 | 설명 |
|------|------|------|
| `totalCharacters` | Integer | 총 글자 수 (공백 포함) |
| `charactersWithoutSpaces` | Integer | 공백 제외 글자 수 |
| `wordCount` | Integer | 총 단어 수 |
| `lineCount` | Integer | 총 줄 수 |
| `wordFrequency` | Object | 단어별 빈도수 |
| `mostFrequentWord` | String | 최빈 단어 |
| `averageWordLength` | Double | 평균 단어 길이 |

### 2. Health Check API

**`GET /health`**

애플리케이션 상태를 확인합니다.

#### 응답 예시
```json
"Word Counter API is running"
```

## 🧪 테스트

### 전체 테스트 실행
```bash
./gradlew test
```

### 테스트 커버리지 확인
```bash
./gradlew jacocoTestReport
```

### 테스트 결과 확인
- **HTML 리포트**: `build/reports/tests/test/index.html`
- **커버리지 리포트**: `build/reports/jacoco/test/html/index.html`

## 📁 프로젝트 구조

```
WordCounterAPI/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/wordcounter/
│   │   │       ├── WordCounterApiApplication.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       └── model/
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
├── build.gradle
└── README.md
```

## 🤝 기여하기

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 라이선스

This project is licensed under the MIT License - see the `LICENSE` file for details.

## 📞 문의

프로젝트에 대한 질문이나 제안사항이 있으시면 이슈를 생성해주세요.

---

⭐ 이 프로젝트가 도움이 되셨다면 Star를 눌러주세요!