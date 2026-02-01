# 🛠️ GitHub Troubleshooting Notes
> Git 기반 협업 및 저장소 운영 과정에서 발생한 이슈를 분석하고 해결한 기록입니다.

---

## 📌 Troubleshooting List

| No | Topic | Status |
|---:|------|:------:|
| 01 | 경로 문제 (프로젝트 폴더 외부에서 `git add .`) | ✅ |
| 02 | 병합 충돌 (Merge Conflict) | ✅ |
| 03 | 병합 미완료 상태에서 Pull 시도 (`MERGE_HEAD exists`) | ✅ |
| 04 | 병합 이력 불일치 (`refusing to merge unrelated histories`) | ✅ |
| 05 | 권한 거부 오류 (403 / Permission denied) | ✅ |
| 06 | repo 안의 repo 문제 (Nested repository) | ✅ |
| 07 | `git restore` 경로 인식 오류 (`pathspec did not match`) | ✅ |

---

## 📝 Troubleshooting Details

<details id="error1">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting01 (경로 문제: 프로젝트 폴더 외부에서 git add . 실행)</summary>

<p><strong>[Problem]</strong><br>
프로젝트 폴더가 아닌 상위 디렉토리(홈 디렉토리)에서 <code>git add .</code>를 실행하여 시스템 폴더까지 스캔되며 권한 오류가 대량 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
$ git add .
warning: could not open directory ... Permission denied
fatal: adding files failed
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
작업 디렉토리가 프로젝트 루트가 아닌 상태에서 실행되어, Git이 OS/사용자 시스템 폴더까지 관리 대상으로 인식함.
</p>

<p><strong>[Solution]</strong><br>
항상 프로젝트 폴더 루트에서 Git 명령어를 실행하도록 경로를 점검하고, 작업 폴더 기준으로 add/commit/push 수행.
</p>

<p><strong>[Impressions]</strong><br>
Git 사용 시 “현재 경로”는 가장 중요한 전제 조건이며, 명령 실행 전 작업 디렉토리 확인 습관이 필요함.
</p>
</details>

---

<details id="error2">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting02 (병합 충돌: Merge Conflict)</summary>

<p><strong>[Problem]</strong><br>
<code>git pull</code> 수행 시 동일 파일에 대해 로컬/원격 변경 사항이 충돌하여 자동 병합 실패.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
CONFLICT (content): Merge conflict in day002.md
Automatic merge failed; fix conflicts and then commit the result.
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
같은 파일을 서로 다른 내용으로 수정한 상태에서 pull을 수행해 Git이 자동으로 병합할 수 없는 상태가 됨.
</p>

<p><strong>[Solution]</strong><br>
충돌 파일을 직접 수정 후:
<code>git add .</code> → <code>git commit</code> → <code>git push</code> 순으로 병합 완료.
</p>

<p><strong>[Impressions]</strong><br>
협업 환경에서는 충돌이 자연스럽게 발생하며, 충돌을 “장애”가 아닌 “프로세스”로 이해하고 해결 흐름을 익히는 것이 중요함.
</p>
</details>

---

<details id="error3">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting03 (병합 미완료: MERGE_HEAD exists)</summary>

<p><strong>[Problem]</strong><br>
병합이 끝나지 않은 상태에서 pull을 다시 수행하여 병합 상태 오류 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
error: You have not concluded your merge (MERGE_HEAD exists).
fatal: Exiting because of unfinished merge.
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
이전 merge 과정이 완료되지 않았는데 추가 pull을 수행함.
</p>

<p><strong>[Solution]</strong><br>
충돌 해결 후:
<code>git add .</code> → <code>git commit</code> 으로 merge 상태를 종료한 뒤 pull/push 재시도.
</p>

<p><strong>[Impressions]</strong><br>
Git은 merge 상태를 명확히 관리하기 때문에, “현재 상태 확인 후 처리”가 우선이라는 점을 학습함.
</p>
</details>

---

<details id="error4">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting04 (병합 이력 불일치: unrelated histories)</summary>

<p><strong>[Problem]</strong><br>
새 환경에서 저장소 설정 후 <code>git pull</code> 수행 시 이력 불일치 오류 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
fatal: refusing to merge unrelated histories
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
로컬 저장소와 원격 저장소의 커밋 이력이 서로 연결되어 있지 않아 Git이 병합을 거부함.
</p>

<p><strong>[Solution]</strong><br>
아래 옵션으로 병합 후 충돌 해결 및 commit 진행:
</p>
<pre><code class="language-bash">
git pull origin master --allow-unrelated-histories
</code></pre>

<p><strong>[Impressions]</strong><br>
새 환경에서 저장소를 연결할 때는 remote 연결 전에 저장소 상태와 이력 구조를 확인하는 것이 안전함.
</p>
</details>

---

<details id="error5">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting05 (권한 거부: 403 Permission denied)</summary>

<p><strong>[Problem]</strong><br>
push 수행 시 저장소 권한이 없는 계정으로 인증되어 403 오류 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
remote: Permission to ... denied ...
fatal: ... error: 403
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
현재 로그인된 GitHub 계정에 해당 저장소 push 권한이 없어 인증이 거부됨.
</p>

<p><strong>[Solution]</strong><br>
- 저장소 소유자에게 Collaborator 등록 요청<br>
- 또는 fork 후 개인 저장소로 push<br>
- 인증 계정 전환 및 캐시된 인증 정보 정리
</p>

<p><strong>[Impressions]</strong><br>
협업 시 계정/권한/remote 설정은 기능 구현만큼 중요한 운영 요소임을 체감함.
</p>
</details>

---

<details id="error6">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting06 (repo 안의 repo: Nested repository)</summary>

<p><strong>[Problem]</strong><br>
상위 폴더와 하위 폴더 모두 Git repo로 초기화되어, 하위 repo가 submodule처럼 인식되며 commit/push가 꼬이는 문제 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
modified:   fullstack_hj (modified content, untracked content)
error: could not lock config file .../.git/config
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
workspace 폴더 자체에 <code>.git</code>이 존재하는 상태에서, 내부 프로젝트 폴더도 별도 repo로 관리되어 Git이 중복 repo 구조로 해석함.
</p>

<p><strong>[Solution]</strong><br>
의도하지 않은 상위 repo의 <code>.git</code> 제거 후, 하위 프로젝트 repo만 유지하여 정상 상태로 복구.
</p>

<p><strong>[Impressions]</strong><br>
Git은 폴더에 <code>.git</code>이 존재하면 무조건 repo로 인식하므로, repo 범위/루트 관리가 매우 중요함.
</p>
</details>

---

<details id="error7">
<summary style="font-size:20px; font-weight:bold;">📌 Troubleshooting07 (git restore 경로 인식 오류: pathspec did not match)</summary>

<p><strong>[Problem]</strong><br>
<code>git restore</code>로 특정 파일을 이전 커밋으로 되돌리려 했으나 파일을 찾지 못한다는 오류 발생.
</p>

<p><strong>[Error Code]</strong></p>
<pre><code class="language-bash">
error: pathspec 'day034.md' did not match any file(s) known to git
</code></pre>

<p><strong>[Cause Analysis]</strong><br>
파일이 하위 폴더 내부에 존재했으며, Git은 경로/대소문자/공백을 정확히 구분하므로 파일 경로가 일치하지 않아 발생.
</p>

<p><strong>[Solution]</strong><br>
정확한 파일 경로를 포함하여 restore 수행:
</p>
<pre><code class="language-bash">
git restore --source=HEAD~1 "days_Class Notes/day034.md"
</code></pre>

<p><strong>[Impressions]</strong><br>
Git 명령은 경로 문자열을 그대로 해석하므로, 파일 경로 확인(<code>git status</code>, <code>git ls-files</code>)이 선행되어야 함.
</p>
</details>

