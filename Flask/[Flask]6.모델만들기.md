## 모델만들기

ORM을 통해 플라스크에서 데이터베이스를 다루는 방법을 다 익혔으니 모델을 만드는 방법을 소개하겠다.
ORM을 통해 Customer테이블을 생성하였으니 Customer에 대한 모델이 있어야한다.

> 모델은 데이터를 다룰 목적으로 만든 파이썬 클래스이다.

1. 모델 속성 구상하기.
Customer(고객)에는 id, name, gender, phone의 속성이 필요하다.
속성을 표로 나타내면 아래와 같다.

|     속성명     |     설명     |
|:-----------:|:----------:|
|     id      | 고객의 고유 아이디 |
|    name     |   고객의 이름   |
|   gender    |   고객의 성별   |
|    phone    | 고객의 핸드폰 번호 |
| create_date |   가입 날짜    |

2. 고객 모델 생성하기.
위와 같이 구상한 속성을 바탕으로 모델을 정의해보자. 먼저 프로젝트 메인 티렉토리에 모델을 정의하기 위한 models.py파일을 생성하고  
고객 모델인 Cusomter 클래스를 아래와 같이 작성해보자.
```py
from main import db

class Customer(db.Model):
    id = db.Column(db.Integer, primary_key = True)
    name = db.Column(db.String(200), nullable=False)
    gender = db.Column(db.Text(), nullable=False)
    phone = db.Column(db.String(200), nullable=False)
    create_date = db.Column(db.DateTime(), nullable=False)
```
Customer 모델 클래스는 db.Model 클래스를 상속하여 만들어야 한다. 이 때 사용한 db 객체는 __init__.py 파일에서 생성한 SQLAlchemy 클래스의 객체이다.  
Customer 모델은 고유 번호(id), 이름(name), 성별(gender), 핸드폰 번호(phone), 가입날짜(create_date)속성으로 구성했으며, 각 속성은 db.Column으로 생성했다.  
db.Column에 어떤 값들을 전달했는지 살펴보면서 각 속성의 특징을 확인해 보자.
db.Column() 괄호 안의 첫 번째 인수는 데이터 타입을 의미한다. 데이터 타입은 속성에 저장할 데이터의 종류를 결정한다. db.Integer는 고유 번호와 같은 숫자값에 사용하고,  
db.String은 제목처럼 글자 수가 제한된 텍스트에 사용한다. 글 내용처럼 글자 수를 제한할 수 없는 텍스트는 db.Text를 사용한다. 가입날짜는 날짜와 시각에 해당하는 db.DateTime을 사용했다.

db.Column에는 데이터 타입 외에 다음과 같은 속성을 추가로 설정할수 있다.

**primary_key**
id 속성에 설정한 primary_key는 id 속성을 기본 키(Primary Key)로 만든다. 기본 키는 데이터베이스에서 중복된 값을 가질 수 없게 만드는 설정이다. id는 모델에서 각 데이터를 구분하는 유일한 값으로 중복되면 안 되므로 기본키로 지정했다.
데이터베이스에서는 id와 같은 특징을 가진 속성을 기본 키(Primary Key)라고 한다. 플라스크는 데이터 타입이 db.Integer이고 기본키로 설정한 속성은 값이 자동으로 증가하는 특징도 있어서 데이터를 저장할 때 값을 세팅하지 않아도 1씩 자동으로 증가되어 저장된다.

**nullable**
nullable은 속성에 값을 저장할 때 빈값을 허용할지의 여부이다. nullable을 따로 설정하지 않으면 해당 속성은 기본으로 빈값을 허용한다. 따라서 속성에 빈값을 허용하지 않으려면 nullable=False로 설정해야 한다.

## 모델을 이용해 테이블 자동으로 생성하기
모델을 구상하고 생성했으므로 플라스크의 migrate 기능을 이용해 데이터베이스 테이블을 생성해보자.

1. 모델 import
위에서 작성한 모델을 플라스의 migrate기능이 인식하려면 다음과 같은 import 과정이 필요하다.
파일 : __init.py__
```py
(... 생략 ...)

   # ORM
   db.init_app(app)
   migrate.init_app(app, db)
   from . import models

... 생략 ...)
```

2. 리비전 파일 생성하기
이후 리비전 파일을 생성하기 위해 명령 프롬프트에서 `flask db migrate`명령을 수행해야한다.
명령을 실행하였다면 해당 버전번호의 .py파일이 생성된다.

3. 리비전 파일 실행하기
이어서 `flask db upgrade`명령으로 만들어진 리비전 파일을 실행해야한다.
(리비전 파일에은 테이블 생성을 위한 쿼리문들이 저장되어 있다.)
리비전 파일을 실행하다면 프로젝트명으로 .db파일이 생성될 것이다.

4. 생성된 테이블 확인하기.
프로젝트.db 데이터 파일에 해당 테이블이 생성되었는지 확인하기 위해서는 데이터베이스 프로그램(SQL_Lite)이 필요하다.

