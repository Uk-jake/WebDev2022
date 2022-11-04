# 플라스크 프로젝트 구조
플라스크는 정해진 프로젝트의 구조가 없기 때문에 만들어야할 프로젝트의 특성을 잘 파악하여  
프로젝트의 구조를 잘 정해야한다.

```
├── pybo/
│      ├─ __init__.py
│      ├─ models.py
│      ├─ forms.py
│      ├─ views/
│      │   └─ main_views.py
│      ├─ static/
│      │   └─ style.css
│      └─ templates/
│            └─ index.html
└── config.py
```
위 프로젝트 구조는 점프 투 플라스크 기본 프로젝트의 구조이다.

### 데이터베이스를 처리하는 models.py파일
모델 기반으로 데이터베이스할 떄 사용하는 모델 클래스들을 정의한다.

### 서버로 전송된 폼을 처리하는 forms.py파일
폼 클래스를 정의한다.
폼 클래스에 대해서 알고 싶다면 아래 링크를 참고.  
[폼 클래스란?](https://mingyum119.tistory.com/33)

### 화면을 구성하는 views 디렉터리
view 디렉터리에는 화면을 구성하는 뷰 파일들이 들어간다.
기능에 따라 main_views.py, question_views.py, answer_view.py등 파일들이 들어간다.

### CSS, 자바스크립트, 이미지 파일을 저장한는 static 디렉터리
static 디렉터리는 css, 자바스크립트, 이미지 파일등을 저장한다.

### HTML 파일을 저장하는 templates 디렉터리
templates 디렉터리에는 파일들을 저장한다.

### 프로젝트를 설정하는 config.py 파일
config.py파일은 파이보 프로젝트의 환경을 설정한다. 환경변수, 데이터베이스 등의 설정을 이 파일에 저장한다.

