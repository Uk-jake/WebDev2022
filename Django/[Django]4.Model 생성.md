# Django_Model 생성

Django에서 기본적인 흐름을 공부하였다면 다음으로 데이터를 사용하기 위해 Model에 대해 알아야합니다.

## 모델이란?

모델이란 부가적인 메타데이터를 가진 데이터베이스이 구조(layout)를 말합니다.
앱에서 Question과 Choice라는 두 가지 모델을 만든다고 가정하고 model.py파일을 작성하겠습니다.

```python
from django.db import models

class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)
```

여기서 각 모델은 django.db.models.Model의 하위 클래스로 표현됩니다.
모델마다 여러 클래스 변수가 있으며, 각 클래스 변수는 모델에서 데이터베이스 필드를 나타냅니다.
데이터 베이스의 각 필드는 Field클래스의 인스턴스로서 표현됩니다.

## 모델 활성화

모델에 대한 코드가 Django에게는 상당한 양의 정보로 전달합니다.

- 앱을 위한 DB스키마 생성
- 객체에 접근하기 위한 Python DB접근 API를 생성

이러한 정보를 전달하기 위해서는 먼저 현재 프로젝트에게 앱이 설치되어 있다는 것을 알려야합니다.
이를 위해 프로젝트의 setting.py파일에
INSTALLED_APPS에 (앱이름).apps.(앱이름)Config파일을 추가해야합니다.
파일을 추가했으므로 Django는 앱이 추가된 것을 알게 되었고

```python
python manage.py makemigrations polls
```

라는 명령어를 입력해주면 모델이 완성되었다는 결과문을 볼 수 있습니다.

## DB에 모델 관련된 테이블 생성하기

```python
python manage.py migrate
```

위와 같은 코드를 입력하면 모델에서의 변경 사항들과 테이터베이스의 스키마의 동기화가 이루어집니다.

## 정리
1. models.py에서 모델을 변경하기
2. python [manage.py](http://manage.py) makemigrations을 통해 변경사항에 대한 마이그레이션을 만들기
3. python [manage.py](http://manage.py) migrate명령을 통해 변경사항을 DB에 적용하기.