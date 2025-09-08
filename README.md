# 🚀 박현주 | 실전 프로젝트 중심 풀스택 포트폴리오

> 코드를 넘어 흐름을 설계하는 개발자.  
**기획 → 구현 → 배포**, 전 과정을 주도한 실전형 풀스택 포트폴리오

***문제 해결 중심 사고**와 **협업 경험**으로  
실무에 가까운 프로젝트를 직접 구현했습니다.*


---
<!-- 이름, 이메일, 깃허브 주소, 포트폴리오 2*4의 테이블 형식으로-->
## 💡Contact & Links
<img src="./track001_github/3319946_수정.gif"
    alt="프로필" width="100"/>

|||
|-|-|
|**NAME**|박현주|
|**EMAIL**|tkasid00@gmail.com|
|**GITHUB**|https://github.com/tkasid00/fullstack_hj|


---
<!-- Track001 github -->
## ✨Golds
- GitHub의 핵심 기능을 이해하고 실습을 통한 활용 능력 강화
- Markdown을 활용한 기술 문서 작성 및 문서화 역량 향상
- 협업을 위한 GitHub 워크플로우 이해 및 적용 경험
- AI 도구를 활용한 개발 환경 구성 및 실무 적용 체험

---

## ✔기술 스택 기반 CS 역량

| 기술 스택                | 실무 중심 CS 역량 설명                                                                                   |
|--------------------------|--------------------------------------------------------------------------------------------------------|
| **Git & GitHub**         | **분산 버전 관리 시스템의 원리와 구조 이해**, 브랜치 전략 및 병합 충돌 해결 경험, GitHub를 통한 **프로젝트 관리 및 팀워크** |
| **Markdown**             | **기술 문서화 표준과 마크업 구조 이해**, README 및 API 문서 작성, 오픈소스 협업을 위한 문서 관리 역량 강화         |
| **Visual Studio Code**   | **IDE의 동작 원리와 확장 기능 활용**, 디버깅 및 코드 분석을 통한 **코드 품질 향상**, 개발 환경 자동화 경험         |
| **HTML5**                | **DOM 구조와 시맨틱 태그의 역할 이해**, 웹 접근성과 SEO를 고려한 구조적 웹 페이지 설계 및 구현                   |
| **CSS3**                 | **박스 모델, Flex/Grid 등 레이아웃 원리 이해**, 반응형 디자인 및 애니메이션을 통한 **사용자 경험(UX) 개선**        |
| **AI 프롬프트 엔지니어링** | **AI 모델의 동작 원리와 프롬프트 설계**, ChatGPT, Copilot 등 도구를 활용한 **코드 생성·문서화·아이디어 브레인스토밍** |

---
<!-- JAVA, HTML+CSS+JS/JQUERTY...-->
<!--## 📌포트폴리오

<br/>
<br/>
<br/>

--- -->

## 😱트러블슈팅(Github 발생)

<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅01(커밋 오류)</summary>

**[문제점]**  
- 파일 수정 후 커밋하려 했으나 변경 사항이 스테이지에 올라가지 않아 커밋이 되지 않음.

**[오류 코드]**   
```bash
$ git commit -m "git 수정 후 다시 올리기"
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   day001.md

no changes added to commit (use "git add" and/or "git commit -a")
```

**[원인 분석]**  
- 파일을 수정한 뒤 저장(ctrl+s)을 하지 않아 실제로 변경된 내용이 반영되지 않았음.

**[해결 방안]**  
- 파일을 저장한 뒤 `git add <파일명>` 또는 `git add .`로 변경 사항을 스테이지에 추가하고 커밋을 진행.

**[느낀점]**  
- 커밋 전에는 반드시 파일이 저장되었는지 확인해야 하며, 작은 실수 하나가 커밋 과정에서 오류를 발생시킬 수 있음을 경험함.  
- 기본적인 Git 워크플로우(수정→저장→add→commit)의 중요성을 다시 한 번 인식함.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅02(경로 문제)</summary>

**[문제점]**  
- `git add .` 명령어 실행 시 시스템 폴더에 접근 권한이 없어 수많은 warning과 fatal error가 발생함.

**[오류 코드]**  
```bash
tj-bu-703-20@DESKTOP-L48OJRJ MINGW64 ~ (master)
$ git add .
warning: could not open directory 'AppData/Local/Application Data/': Permission denied
warning: could not open directory 'AppData/Local/History/': Permission denied
warning: could not open directory 'AppData/Local/Microsoft/Windows/INetCache/Content.IE5/': Permission denied
warning: could not open directory 'AppData/Local/Microsoft/Windows/Temporary Internet Files/': Permission denied
warning: could not open directory 'AppData/Local/Temp/WinSAT/': Permission denied
warning: could not open directory 'AppData/Local/Temporary Internet Files/': Permission denied
warning: could not open directory 'AppData/Roaming/Microsoft/Windows/Start Menu/프로그램/': Permission denied
warning: could not open directory 'Application Data/': Permission denied
warning: could not open directory 'Cookies/': Permission denied
warning: could not open directory 'Documents/My Music/': Permission denied
warning: could not open directory 'Documents/My Pictures/': Permission denied
warning: could not open directory 'Documents/My Videos/': Permission denied
warning: could not open directory 'Local Settings/': Permission denied
warning: could not open directory 'My Documents/': Permission denied
warning: could not open directory 'NetHood/': Permission denied
warning: could not open directory 'PrintHood/': Permission denied
warning: could not open directory 'Recent/': Permission denied
warning: could not open directory 'SendTo/': Permission denied
warning: could not open directory 'Templates/': Permission denied
warning: could not open directory '시작 메뉴/': Permission denied
warning: in the working copy of '.gitconfig', LF will be replaced by CRLF the next time Git touches it
warning: in the working copy of '.lesshst', LF will be replaced by CRLF the next time Git touches it
warning: in the working copy of '.vscode/argv.json', LF will be replaced by CRLF the next time Git touches it
error: open("AppData/Local/Comms/UnistoreDB/USS.jtx"): Permission denied
error: unable to index file 'AppData/Local/Comms/UnistoreDB/USS.jtx'
fatal: adding files failed
```

**[원인 분석]**  
- 작업 디렉토리를 상위 폴더(홈 디렉토리)로 지정한 상태에서 `git add .`를 실행하여 시스템 폴더까지 Git이 스캔함.
- Windows 사용자 폴더에는 권한이 제한된 시스템 디렉토리가 많아, 접근 시 오류가 발생함.

**[해결 방안]**  
- 반드시 프로젝트 폴더에서 Git 명령어를 실행하여, 불필요한 시스템 폴더가 Git의 관리 대상에 포함되지 않도록 경로를 재설정함.
- 작업 폴더를 정확하게 지정한 후 `git add .`를 실행하면 정상적으로 동작함.

**[느낀점]** 
- Git 명령어를 사용할 때는 반드시 현재 작업 경로를 확인해야 하며 실수로 상위 폴더에서 실행하면 시스템 파일까지 스캔되어 권한 문제로 오류가 발생할 수 있음을 알게 됨.  
- 프로젝트 폴더 구조와 경로 관리의 중요성을 체감함.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅03(병합 충돌)</summary>



**[문제점]**  
- `git pull origin master` 실행 시 병합되지 않은 변경 사항이 있어 merge conflict가 발생함.

**[오류 코드]**  
```bash
$ git pull origin master
remote: Enumerating objects: 5, done.
remote: Counting objects: 100% (5/5), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 3 (delta 1), reused 0 (delta 0), pack-reused 0 (from 0)
Unpacking objects: 100% (3/3), 946 bytes | 105.00 KiB/s, done.
From https://github.com/tkasid00/fullstack_hj
 * branch            master     -> FETCH_HEAD
   f46d107..504ab2c  master     -> origin/master
Auto-merging day002.md
CONFLICT (content): Merge conflict in day002.md
Automatic merge failed; fix conflicts and then commit the result.
```

**[원인 분석]**  
- 로컬과 원격 저장소의 동일 파일에 서로 다른 변경 사항이 있어 자동 병합이 불가능한 상태에서 pull을 시도함.

**[해결 방안]**  
- 충돌 파일을 직접 수정하여 병합한 뒤,  
  `git add .` → `git commit -m "오류 해결"` → `git pull origin master` → `git push origin master` 순서로 정상적으로 병합 및 푸시함.

**[느낀점]**  
- 협업 환경에서는 충돌이 자주 발생할 수 있으므로 충돌 해결 방법과 병합 과정에 익숙해지는 것이 중요함.  
- 충돌 상황을 두려워하지 않고 차분하게 원인 파악과 해결 절차를 밟는 습관이 필요함.  
- 특히 실무에서는 팀원과의 적극적인 소통이 문제 해결과 원활한 협업에 매우 중요하다는 것을 깨달음.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅04(병합 미완료 에러) </summary>
 

**[문제점]**  
- 병합이 완료되지 않은 상태에서 추가 pull을 시도하여 "You have not concluded your merge (MERGE_HEAD exists)" 에러가 발생함.

**[오류 코드]**  
```bash
$ git pull origin master
error: You have not concluded your merge (MERGE_HEAD exists).
hint: Please, commit your changes before merging.
fatal: Exiting because of unfinished merge.
```

**[원인 분석]**  
- 이전 병합 작업이 완료되지 않은 상태에서 추가로 pull을 시도함.
- Git은 병합 중인 상태를 명확히 관리하므로, 병합이 끝나지 않은 상황에서는 추가 작업이 불가능함.

**[해결 방안]**  
- 병합 중인 파일을 수정 및 저장한 뒤 `git add .` → `git commit -m "merge 완료"`로 병합을 마무리한 후 pull/push를 재시도함.

**[느낀점]**  
- Git은 병합 중인 상태를 명확히 관리하므로 병합이 끝나지 않은 상황에서는 추가 작업이 불가능함을 알게 됨.  
- 단계별로 작업을 마무리하는 습관과 Git의 상태 메시지를 꼼꼼히 확인하는 것이 중요함.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅05(병합 이력 불일치 오류) </summary>

**[문제점]**  
- 새 컴퓨터에서 Git 저장소를 세팅하고 `git pull origin master` 명령어를 실행했을 때,  
  `fatal: refusing to merge unrelated histories` 오류가 발생함.

**[오류 코드]**  
```bash
$ git pull origin master
remote: Enumerating objects: 344, done.
remote: Counting objects: 100% (62/62), done.
remote: Compressing objects: 100% (53/53), done.
remote: Total 344 (delta 26), reused 28 (delta 7), pack-reused 282 (from 1)
Receiving objects: 100% (344/344), 4.66 MiB | 13.07 MiB/s, done.
Resolving deltas: 100% (144/144), done.
From https://github.com/tkasid00/fullstack_hj
 * branch            master     -> FETCH_HEAD
 * [new branch]      master     -> origin/master
fatal: refusing to merge unrelated histories
```

**[원인 분석]**  
- 로컬 저장소와 원격 저장소가 각각 독립적으로 생성되어 커밋 이력이 서로 연결되어 있지 않음.
- 새 컴퓨터에서 `git init`으로 저장소를 만들고 원격 저장소와 연결한 뒤 pull을 시도했으나  
  두 저장소의 커밋 이력이 달라 Git이 병합을 거부함.

**[해결 방안]**  
- `git pull origin master --allow-unrelated-histories` 명령어를 사용하여 강제로 병합을 진행함.
- 병합 과정에서 충돌이 발생할 수 있으므로, 충돌 파일을 직접 수정한 뒤  
  `git add .` → `git commit -m "병합 이력 불일치 해결"`로 병합을 마무리함.

**[느낀점]**  
- 새 환경에서 Git 저장소를 세팅할 때는 로컬과 원격 저장소의 이력이 일치하는지 반드시 확인해야 함.
- `--allow-unrelated-histories` 옵션을 통해 병합할 수 있지만, 충돌 해결 등 추가 작업이 필요하므로  
  병합 과정에 대한 이해와 신중한 접근이 중요함을 깨달음.
</details>



<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅06(깃허브 권한 거부 오류/403) </summary>

**[문제점]**  
- `git push origin dev-tkasid00` 명령어 실행 시  
  `remote: Permission to tkasid00/fullstack_20250825.git denied to HSH703.`  
  `fatal: unable to access ... error: 403` 오류가 발생함.

**[오류 코드]**  
```bash
PS D:\HYUNJU\workspace\fullstack_20250825> git push origin dev-tkasid00
remote: Permission to tkasid00/fullstack_20250825.git denied to HSH703.
fatal: unable to access 'https://github.com/tkasid00/fullstack_20250825.git/': The requested URL returned error: 403
```

**[원인 분석]**  
- 현재 로그인된 깃허브 계정(HSH703)에게 해당 저장소(tkasid00/fullstack_20250825)에 대한 푸시 권한이 없음.
- 저장소 소유자 또는 협업자로 등록되지 않은 계정으로 푸시를 시도했기 때문에 권한 거부(403)가 발생함.

**[해결 방안]**  
- 저장소 소유자에게 협업자(Contributor)로 추가해 달라고 요청.
- 또는 자신의 계정으로 포크(fork)한 저장소에 푸시하거나 올바른 계정으로 인증 정보를 변경함.
- 인증 정보를 변경하려면 `git config --global user.name` 및 `git config --global user.email`을 올바른 계정으로 설정하고  
  필요 시 GitHub에 로그인된 계정을 변경하거나 **캐시된 인증 정보를 삭제함.**

**[느낀점]**  
- 깃허브 저장소에 푸시하려면 반드시 해당 저장소에 대한 권한이 필요함을 알게 됨.
- 협업 시에는 권한 관리와 계정 설정을 꼼꼼히 확인해야 하며 권한 문제 발생 시 당황하지 말고 원인을 파악해 해결하는 것이 중요함.
</details>


<details>
<summary style="font-size:20px; font-weight:bold;">📌트러블슈팅07(이미지 경로 오류)</summary>

**[문제점]**  
- 이미지가 페이지에 표시되지 않음

**[오류 코드]**  
```bash
브라우저 콘솔에 GET ./track001_github/3319946_수정.gif 404 (Not Found) 오류 발생
```

**[원인 분석]**  
- ./track001_github/... 경로는 현재 HTML 파일 기준의 상대 경로이며 실제 디렉토리 구조에서는 track001_github 폴더가 상위 디렉토리에 위치
- 따라서 경로가 잘못 지정되어 이미지 파일을 찾지 못함


**[해결 방안]**  
- 경로를 ../track001_github/~로 수정하여 상위 디렉토리에서 이미지 파일을 참조하도록 변경.


**[느낀점]**  
- 상대 경로는 현재 파일 위치 기준이므로 디렉토리 구조를 정확히 파악하는 것이 중요함
- 작은 경로 실수도 UI에 큰 영향을 줄 수 있으니 꼼꼼한 확인이 필요함
</details>


---

## 📜참고문헌

- [Git 공식 문서](https://git-scm.com/doc)  
- [Markdown 가이드](https://www.markdownguide.org/basic-syntax/)  
- [VS Code 공식 사이트](https://code.visualstudio.com/)  
- [AI 프롬프트 작성 팁](https://learn.microsoft.com/en-us/azure/ai-foundry/openai/concepts/prompt-engineering?tabs=chat)