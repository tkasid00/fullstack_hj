# 🛠️ AWS Deployment Troubleshooting Notes
> Pawject AWS 배포 과정에서 발생한 주요 이슈를 원인 분석 중심으로 정리한 기록입니다.

---

## 📌 Troubleshooting List
| No | Topic | Status |
|---:|------|:------:|
| 01 | 프론트 API 경로 불일치 | ✅ |
| 02 | 서버 환경변수 미등록 | ✅ |
| 03 | 운영 DB 스키마 미반영 | ✅ |
| 04 | Backend 실행 실패 (JAR 참조 경로 불일치) | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary><strong>01. 프론트 API 경로 불일치</strong></summary>

**Problem**  
프론트 UI 정상 출력되었으나 API 데이터 조회 실패 발생.

**Cause**  
React 빌드 시 환경변수가 로컬 기준으로 포함된 상태에서 배포 진행됨.

**Solution**
```bash
운영 환경 반영 후 재빌드
npm run build
pm2 restart frontend
```

**Result**  
프론트 배포 시 환경 포함 산출물 검증 절차 추가.
</details>

---

<details id="error2">
<summary><strong>02. 서버 환경변수 미등록</strong></summary>

**Problem**  
업로드 경로 등 설정값이 서버에서 적용되지 않음.

**Cause**  
코드에는 환경 설정이 존재했으나  
EC2 서버 환경에는 변수 등록이 되어 있지 않았음.

**Solution**
```bash
Linux 서버에서 env 파일 직접 생성 후 적용
export UPLOAD_PATH=/home/ubuntu/app/uploads
pm2 restart backend
```

**Result**  
환경변수 관리 기준 정립 및 배포 체크 항목에 추가.
</details>

---

<details id="error3">
<summary><strong>03. 운영 DB 스키마 미반영</strong></summary>

**Problem**  
운영 환경에서 테이블 조회 실패 발생.

**Cause**  
로컬 Oracle DB 스키마만 존재하고 서버 DB에 반영되지 않음.

**Solution**  
로컬 DB 스키마 export 후 서버 DB에 적용하여 구조 동기화 수행.

**Result**  
배포 전 DB 스키마 확인 절차 추가.
</details>

---

<details id="error4">
<summary><strong>04. Backend 실행 실패 (JAR 참조 경로 불일치)</strong></summary>

**Problem**  
백엔드 코드 수정 후 재빌드했음에도 서버 실행 시 변경 사항이 반영되지 않거나 정상 기동되지 않음.

**Cause**  
서버 실행 스크립트(PM2)가 최신 빌드 산출물이 아닌 기존 JAR 경로를 참조하고 있었음.  
이전 JAR 삭제 및 재빌드 후에도 실행 경로가 갱신되지 않아 동일 문제 반복 발생.  
배포 환경에서 실행 아티팩트 경로 관리 검증이 부족했음.

**Solution**
```bash
실행 경로 확인
which java
pwd
ls -al build/libs/

PM2 실행 대상 경로 재설정 후 재기동
pm2 restart backend
```

**Result**  
배포 절차에 실행 JAR 경로 확인 단계 추가하여 동일 문제 재발 방지.
</details>