# **Fork와 PR(Pull Request)**

## **Fork란?**
Fork는 다른 사람의 Github repository에서 내가 어떤 부분을 수정하거나 추가 기능을 넣고 싶을 때 해당 repository를 내 Git repository로 그대로 복제하는 기능입니다.
즉, 다른사람의 Repository를 복사하여 내가 원하는데로 코드를 변경할 수 있다는 의미입니다.
추가적으로 Fork한 저장소는 원본과 연결되어 있어 추후에 코드의 master가 fetch나 rebase를 통해 변경사항을 받아드릴 수 있습니다.  
original repository에 변경 사항을 적용하고 싶으면 해당 저장소에 pull requeset를 해야합니다.
pull request가 original repository의 관리자로 부터 승인 되었으면 내가 만든 코드가 commit,merge되어 original에 반영됩니다.
pull request하기 전 까지는 내 github에 있는 forked repository에만 적용됩니다.

## **PR(pull request)란?**
깃허브 레포지토리에 있는 브랜치에 푸시한 내역들, 변경된 사항들을 다른 사람들에게 알리는 것입니다.
마스터 브랜치에 merge되기 전, 변경 사항에 대해 다른 사람들과 논의, 검토할 수 있습니다.  
PR을 통해 코드 충돌을 최소화할 수 있고 push권한이 없는 오픈 소스 프로젝트에 기여할 수도 있습니다.  

## **PR(pull request)사용 단계**
![git flow](./image/git%20_flow.png)
1. 내 원격 repository에 Fork
2. clone 설정
3. remote 설정
4. branch 생성
5. 수정 작업 후 add, commit, push (만일 나 뿐만 아니라 다른 기여자(팀원)이 소스를 수정했다면 fetch로 코드를 가져와 충돌을 해결)
6. Pull Request 생성
7. Merge Pull Request
8. Merge 이후 동기화 및 branch 삭제
