# **리눅스 기본 명령어 정리**

## 필수 명령어들 요약
#### 1. ls - 현재 위치의 파일 목록 조회
#### 2. cd - 디렉터리 이동
#### 3. touch - 0바이트 파일 생성, 파일의 날짜와 시간을 수정
#### 4. mkdir - 디렉터리 생성
#### 5. cp - 파일 복사
#### 6. mv - 파일 이동
#### 7. rm - 파일 삭제
#### 8. cat - 파일의 내용을 화면에 출력, 리다이렉션 기호('>')를 사용하여 새로운 파일 생성
#### 9. redirection - 화면의 출력 결과를 파일로 저장
#### 10. alias - 자주 사용하는 명령어들을 별명으로 정의하여 쉽게 사용할 수 있도록 설정

### ls(List segments) : 현재 위치의 파일목록조회
* ls -l : 파일의 상세정보
* ls -a : 숨김 파일 표시
* ls -t : 파일들을 생성시간순(제일 최신 것부터)으로 표시
* ls -rt : 파일들을 생성시간순(제일 오래된 것부터)으로 표시
* ls -f : 파일 표시 시 마지막 유형에 나타내는 파일명을 끝에 표시

### cd (Change directory) :디렉터리 이동
* cd ~ : 홈 디렉터리로 이동
* cd / : 최상위 디렉터리로 이동
* cd . : 현재 디렉터리
* cd .. : 상위 디렉터리로 이동
* cd - : 이전 경로로 이동

### mkdir (Make dirctory) : 디렉터리 생성
* mkdir dirname : dirname이라는 디렉터리 생성
* mkdir dir1 dir2: 한 번에 여러 개의 디렉터리 생성
* mkdir -p dirname/sub_dirname : dirname이라는 디렉터리 생성, sub_dirname이라는 하위 디렉터리도 생성
* mkdir -m 700 dirname : 특정 퍼미션(권한)을 갖는 디렉터리 생성

### cp (Copy) : 파일 복사
* cp file1 file2 : file1을 file2라는 이름으로 복사
* cp -f file1 file2 : 강제 복사(file2라는 파일이 이미 있을 경우 강제로 기존 file2를 지우고 복사 진행)
* cp -r dir1 dir2 : 디렉터리 복사. 폴더 안의 모든 하위 경로와 파일들을 복사

### rm (Remove) : 파일 삭제
* rm file1 : file1을 삭제
* rm -f file1 : file1을 강제 삭제
* rm -r dir : dir 디렉터리 삭제 (디렉터리는 -r 옵션 없이 삭제 불가)