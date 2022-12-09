# ORM을 통해 데이터관리하기

웹페이지에서 데이터를 저장하거나 조회하거나 수정하는 등의 기능을 구현하기 위해서는 데이터베이스를 사용해야한다.  
그런데 데이터베이스를 사용하려면 SQL 쿼리(query)라는 구조화된 질의를 작성하고 실행하는 등의 복잡한 과정이 필요하다.  
이때 ORM(object relational mapping)을 이용하면 파이썬 문법만으로도 데이터베이스를 다룰 수 있다.  
즉, ORM을 이용하면 개발자가 쿼리를 직접 작성하지 않아도 데이터베이스의 데이터를 처리할 수 있다.
- ORM은 데이터베이스에 데이터를 저장하는 테이블을 파이썬 클래스로 맏늘어 관리하는 기술이다.
- ORM을 사용하면 파이썬 코드로 데이터베이스를 관리할 수 있다.

## 데이터베이스를 쉽게 사용할 수 있게 해주는 ORM알아보기
SQL쿼리와 ORM을 비교해보자. 다음과 같은 형태로 구성된 질문 테이블에 테이터를 입력한다고 가정해보자.
> customer 테이블에 구성 예

| id  | name | gender |
|:---:|:----:|:------:|
|  1  |  장욱  |   남    |
|  2  | 이진곤  |   남    |
|  3  | 박영지  |   여    |
표에서 id는 각 테이터를 구분하는 고유값이다.
위와 같이 구성된 customer테이블에 새로운 테이버를 삽입하는 SQL문은 아래와 같다.
```sql
INSERT INTO customer(name,gender) values ("홍길동","남");
INSERT INTO customer(name,gender) values ("김태희","여");
```
이러한 SQL문을 ORM을 사용하면 쿼리대신 파이썬 코드로 다음과 같이 작성할 수 있다.

```py
customer1 = Question(name=’홍길동’, gender='남')
db.session.add(customer1)
customer2 = Question(name=’김태희’, gender='여')
db.session.add(customer2)
```
- ORM을 이용하면 새 데이터 삽입 예는 코드 자체만 놓고 보면 양이 많아 보이지만 별도의 SQL문법을 배우지 않아도 된다는 것이 장점이 있어 훨씬 좋다.
코드에서 Question은 파이썬 클래스이며, 이처럼 데이터를 관리하는 데 사용하는 ORM 클래스를 모델이라고 한다. 모델을 사용하면 내부에서 SQL 쿼리를 자동으로 생성해 주므로 직접 작성하지 않아도 된다.  
즉, 파이썬만 알아도 데이터베이스 처리를 할수 있다.

## 플라스크 ORM 라이브러리 사용하기
파이썬 ORM 라이브러리 중 가장 많이 사용하는 SQLAlchemy를 사용해 보자.  
이와 더불어 파이썬 모델을 이용해 테이블을 생성하고 컬럼을 추가하는 등의 작업을 할 수 있게 해주는 Flask-Migrate 라이브러리도 사용해 보자.

1. ORM 라이브러리 설치하기
Flask-Mirgrate 라이브러리를 설치하면 SQLAlchemy도 함께 설치되므로 myproject가상환경에 Flask-Migrate라이브러리를 설치하자.
`pip install flask-migrate`
2. 설정 파일 추가하기
프로젝트에 ORM을 적용하려면 데이터베이스 설정이 필요하다. 루트 디렉토리에 config.py파일을 생성하고 다음과 같은 코드를 작성하자.
```py
import os

BASE_DIR = os.path.dirname(__file__)

SQLALCHEMY_DATABASE_URI = 'sqlite:///{}'.format(os.path.join(BASE_DIR, 'pybo.db'))
SQLALCHEMY_TRACK_MODIFICATIONS = False
```
SQLALCHEMY_DATABASE_URI는 데이터베이스 접속 주소이고 SQLALCHEMY_TRACK_MODIFICATIONS는 SQLAlchemy의 이벤트를 처리하는 옵션이다.  
이 옵션은 파이보에 필요하지 않으므로 False로 비활성화하자. SQLALCHEMY_DATABASE_URI 설정에 의해 SQLite 데이터베이스가 사용되고  
데이터베이스 파일은 프로젝트 홈 디렉터리 바로 밑에 pybo.db 파일로 저장된다.

3. ORM적용하기
ORM을 적용하기 위해서는 프로젝트의 init.py을 수정해야한다.

```py
from flask import Flask
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy

import config

db = SQLAlchemy()
migrate = Migrate()


def create_app():
    app = Flask(__name__)
    app.config.from_object(config)

    # ORM
    db.init_app(app)
    migrate.init_app(app, db)

    # 블루프린트
    from .views import main_views
    app.register_blueprint(main_views.bp)

    return app
```
config.py파일에 작성한 항목을 읽기 위해 app.config.form_object(config)코드를 추가해야한다. 그리고 전역 변수로 db,migrate객체를 만든다음  
create_app함수 안에서 init_app메서드를 이용헤 app을 등록했다.

4. 데이터베이스 초기화하기
ORM을 사용할 준비가 되었으므로 `flask db init`명령을 통해 데이터베이스를 초기화해야한다.

5. 데이터베이스 관리 명령어 정하기
앞으로 모델을 추가하거나 변경할 때는 flask db migrate 명령과 flask db upgrade명령만 사용하면 된다.


