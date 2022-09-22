# Django_기본 개념 정리

## MVC & MVT

![1](https://mblogthumb-phinf.pstatic.net/20160416_183/1_soft_14607691559704Qh0l_JPEG/mvc.jpg?type=w800)

- Model
    - 데이터를 저장(DB에 있는 데이터)
- View
    - 모델에 있는 데이터를 웹 서버에 가지고 온 후 유저가 원하는 데이터로 전달해주는 것.
- Control / Template(Django)
    - 사용자의 입력과 이벤트에 반응하여 Model과 View를 업데이트


## Django 개념


1. Browser에서 요청이 들어오면 WSGI(Web Server Gateway Interface)가 웹서버와 장고가 적절히 연결되도록 해줌.
2. URL Resolution에서 정규표현식에 맞는 URL를 View에 보냄.
3. views.py가 우리가 많이 코드를 많이 작성할 곳임.
4. Model에서 알맞는 데이터를 가공함
5. 사용자에게 보여주기위한 Template를 만들어서 웹서버로 전송.

## Django 흐름
![2](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FbwIe1F%2FbtqT17dJvvr%2FjfEp1bmu8lork4sJsqxz81%2Fimg.png)
1. 사용자가 접속을 한다.
2. urls.py에서 어떤 경로로 보내줄지 결정
3. 경로가 정해지면 알맞는 app으로 이동하고 app안에 있는 urls.py에서 적당한 view로 이동
4. view에서는 DB에 있는 데이터를 사용하기 위해 model을 통해서 데이터 사용

## Setting.py

1. Debug > true로 설정하기
2. installed_apps
3. middelware_classes
    1. request와 reponse사이의 주요 기능 레이어 (보안)
4. Templates
    1. 실제 뷰(HTML, 변수)
5. Databases
    1. 데이터베이스 엔진의 연결 설정
6. Static_URL
    1. 정적 파일의 URL(css, js, image.etc) / 디렉토리 관련된 것들
    

## manage.py

- 프로젝트 관리 명령어 모음
- 주요명령어
    - startapp - 앱 생성
    - runserver - 서버 실행
    - createsuperuser - 관리자 생성
    - makemigrations app - app의 모델 변경 사항 체크
    - migrate - 변경 사항을 DB에 반영
    - shell - 쉘을 통해 데이터를 확인
    - collectstatic - static파일을 한 곳에 모음
-