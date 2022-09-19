# Git 사용법
---

## **Git이란?**
#
Git은 분산형 버전관리 시스템 중 하나이다.  

Github에 저장하는 것은 매번, 매버전을 모두 저장하고 upload하는 방식이 아닌 **각 버전들의 차이 혹은 변경이력**을 저장하는 것이다.  
이를 통해서 훨씬 적은 용량으로 많은 버전 이력들을 저장할 수 있은 것이다.  

#
---
#

## **Git 기초 흐름**
#
1. 저장소 설정

```git
git init
```

- git 저장소를 만들게 되면 해당 디렉토리 내에 .git/ 폴더가 생성된다.  
- git bash에서는 (master)라는 표기가 같이 등장한다.  
- 현재 작업중인 브랜치를 의미한다.

2. Add  
작업위치 폴더에 작업한 파일이 있을 경우 add를 통해서 staging Area로 옮길 수 있다.  
staging Area는 commit을 진행하기 전의 임시 저장된 상태 정도로 생각하면 된다.

    1. 해당 폴더에서 작업 후
    2. add를 통해 staging area에 추가한 후
    3. status 명령어를 통해 상태를 확인한다.  

3. Commit

커밋 메시지는 현재 버전에 대한 내용이 들어가야한다.  

commit 메시지에 대해서 사람들끼리 정해진 작성법도 있다. [참고](https://meetup.toast.com/posts/106)


```git
git commit –m “커밋 메시지”
```  
위 와 같은 방식으로 커밋 메시지를 작성하여 add한 파일들을 commit 한다.

커밋 이력을 확인하기 위해서는 아래와 같은 명령어를 입력한다.

```git
git log
```  


#
---
#

## **Git 원격 저장소 활용(Github)**
#

1. **Github에 repository를 생성한다.**

2. **원격 저장소 설정**  

    원격저장소(remote)로 origin이름으로 url를 추가한다.

    git remote add origin [url]

    git remote –v : 원격저장소 목록 조회

    git remote –rm : 원격저장소 삭제

3. **push**  

    `git push origin master`

    현재 폴더를 그대로 업로드하는 것이 아니라, 지금까지의 이력/버전을 push 하는 것이다.
    Working directory, Staging area의 변경사항들은 원격저장소로 push되지 않고 add한 사항들만    원격저장소로 저장된다.
    따라서, push전에 어디까지 추가했는지 꼼꼼히 확인해야한다.


4. **pull**  
    `git pull`

    원격저장소 변경 사항을 받아온다.
    다른 작업 환경이나 위치에서 작업 할 때, 혹은 공동 작업에서 타인이 commit해서 이력이     변경되었을 경우 등의 경우가 있다. 따라서 pull을 통해 가져온 후 작업을 진행하는 것이     추후에 충돌을 막을 수 있다.

[참고문서](https://chancoding.tistory.com/76)