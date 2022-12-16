## 회원가입
 이번 포스팅에서는 회원가입 기능을 구현할 것입니다. 회원가입 기능은 웹사이트의 주요기능으로 필수적인 기능입니다.
 
### 회원 모델
 회원 모델을 만들기 위한 속성은 아래와 같습니다.(편의상 최소한의 속성으로 구성하였습니다.)

|    속성    |     설명     |
|:--------:|:----------:|
| username | 사용자 이름(ID) |
| password |    비밀번호    |
|  email   |    이메일     |

project/model.py 파일을 열어 위에서 정의한 속성을 바탕으로 User모델을 작성하겠습니다.

```py
class User(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(150), unique=True, nullable=False)
    password = db.Column(db.String(200), nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
```

id는 자동으로 증가하는 User 모델의 기본 키입니다. username, password, email에는 null값을 허용하지 않도로 nullable속성을 False로 설정했습니다.
또 username, email에는 중복을 없애기 위해 unique속성을 True로 설정하였습니다.

User 모델을 새로 작성하였스니 `flask db migrate` 명령으로 리비전 파일을 생성해야합니다.
이어서 `flask db upgrade` 명령으로 생성된 리비전 파일로 데이터베이스를 변경해야합니다. 

Cf) flask db migrate 명령은 새로운 모델의 리비전 파일을 생성하기 위한 명령이고 flask db upgrade 명령은 생성된 리비전 파일을 데이버테이스에 추가하는 명령입니다.

### 회원 가입 폼
 회원가입을 위한 폼을 작성해봅시다. 다음 처럼 FlaskForm을 상속하는 UserCreateFrom을 생성하자.
```py
from flask_wtf import FlaskForm
from wtforms import StringField, TextAreaField, PasswordField, EmailField
from wtforms.validators import DataRequired, Length, EqualTo, Email

(... 생략 ...)

class UserCreateForm(FlaskForm):
    username = StringField('사용자이름', validators=[DataRequired(), Length(min=3, max=25)])
    password1 = PasswordField('비밀번호', validators=[
        DataRequired(), EqualTo('password2', '비밀번호가 일치하지 않습니다')])
    password2 = PasswordField('비밀번호확인', validators=[DataRequired()])
    email = EmailField('이메일', validators=[DataRequired(), Email()])
```
계정생성을 위한 폼의 클래스명은 UserCreateForm입니다. username은 필수항목이고 길이가 3-25 사이여야 한다는 검증조건을 설정하였습니다.  
Length는 폼 유효성 검증시 문자열의 길이가 최소길이(min)와 최대길이(max) 사이에 해당하는지를 검증합니다.
password1과 password2는 "비밀번호"와 "비밀번호확인"에 대한 필드입니다. 로그인 할때는 비밀번호가 한번만 필요하지만 계정생성시에는 입력한 비밀번호가 정확한지 확인하기 위해 2개의 필드가 필요하고  
password1과 password2 속성은 PasswordField로 생성하였습니다. StringField와 비슷하지만 템플릿에서 자동변환으로 사용시 <input type="password"> 태그로 변환되는 차이점이 존재합니다.  
password1 속성과 password2 속성은 모두 필수값이어야 하고 두개의 값이 일치해야 하는 EqualTo 검증이 추가되었고 password1 속성에 지정된 EqualTo('password2') 는 password1과 password2의 값이 일치해야 함을 의미합니다.
그리고 email 속성은 EmailField로 생성하였습니다. EmailField 역시 StringField와 동일하지만 템플릿 자동변환으로 사용시 <input type="email"> 태그로 변환됩니다. email 속성에는 필수값 검증조건에 더하여 Email() 검증조건이 추가되었습니다.  
Email() 검증조건은 해당 속성의 값이 이메일형식과 일치하는지를 검증합니다.  

이후 `Email()` 검증을 사용하기 위해 아래와 같이 email-validator를 설치해야합니다.
`pip install email_validator`

### 회원가입 구현하기
 계정모델과 계정폼이 준비되었으니 회원가입을 위한 블루프린트를 만들어보겠습니다. 회원가입은 회원가입과 로그인/로그아웃을 담당할 auth_views.py 파일을 신규로 생성하여 작성하겠습니다.
 
#### 블루프린트
```py
from flask import Blueprint, url_for, render_template, flash, request
from werkzeug.security import generate_password_hash
from werkzeug.utils import redirect

from pybo import db
from pybo.forms import UserCreateForm
from pybo.models import User

bp = Blueprint('auth', __name__, url_prefix='/auth')


@bp.route('/signup/', methods=('GET', 'POST'))
def signup():
    form = UserCreateForm()
    if request.method == 'POST' and form.validate_on_submit():
        user = User.query.filter_by(username=form.username.data).first()
        if not user:
            user = User(username=form.username.data,
                        password=generate_password_hash(form.password1.data),
                        email=form.email.data)
            db.session.add(user)
            db.session.commit()
            return redirect(url_for('main.index'))
        else:
            flash('이미 존재하는 사용자입니다.')
    return render_template('auth/signup.html', form=form)
```
우선 /auth/로 시작하는 URL이 호출되면 auth_views.py 파일의 함수들이 호출될 수 있도록 블루프린트 객체 bp를 생성하였고 회원가입을 위한 signup 함수를 생성했습니다.  
signup 함수는 POST 방식에는 계정을 저장하고 GET 방식에는 계정 등록 화면을 출력합니다.
코드를 자세히 보면 계정 등록을 할 때 username으로 데이터를 조회해서 "이미 등록된 사용자"인지를 확인하고 만약 이미 등록된 사용자라면 flash('이미 존재하는 사용자입니다.')로 오류를 발생시킵니다.
flash는 필드 자체 오류가 아닌 프로그램 논리 오류를 발생시키는 함수여서 flash로 발생시킨 오류를 템플릿에 표시하는 방법도 곧 알아볼 것입니다.
그리고 비밀번호는 폼으로 전달받은 값을 그대로 저장하지 않고 generate_password_hash 함수로 암호화하여 저장하였습니다.
\generate_password_hash 함수로 암호화한 데이터는 복호화할 수 없다. 그래서 로그인할 때 입력받은 비밀번호는 암호화하여 저장된 비밀번호와 비교해야 합니다.

### 블루프린트 등록
  새로 만든 블루프린트를 사용하려면 init.py파일에 등록해야합니다.
 ```py
 (... 생략 ...)

def create_app():
    (... 생략 ...)

    # 블루프린트
    from .views import main_views, question_views, answer_views, auth_views
    app.register_blueprint(main_views.bp)
    app.register_blueprint(question_views.bp)
    app.register_blueprint(answer_views.bp)
    app.register_blueprint(auth_views.bp)

    (... 생략 ...)

    return app
 ```

