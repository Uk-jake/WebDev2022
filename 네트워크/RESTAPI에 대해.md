# - **REST란?**

REST란 “Representational State Transfer”의 약자이다.
웹에 존재하는 모든 자원에 고유한 URL를 부여해 활용하는 것으로, 자원을 정의하고 자원에 대한 주소를 지정하는 방법론을 의미한다.
이런 REST형식을 따른 시스템을 REST full 방식이라고 부른다.
HTTP URL을 통해 자원을 명시하고 HTTP Method를 통해 해당 자원에 대한 CRUD Operation을 적용한다.
<br><br>

## **REST 구성요소**

**1. 자원(Resource), URL**

모든 자원은 고유한 ID를 가지고 ID는 서버에 존재하고 클라이언트는 각 자원의 상태를 조작하기 위해 요청을 보낸다.
HTTP에서 이러한 자원를 구별하는 ID는 HTTP URL이다.


**2. 행위(Verb), Method**

클라이언트는 URL를 이용하여 자원을 지정하고 자원을 조작하기 위해 Mehtod를 사용한다.
HTTP 프로토콜에서는 GET,POST,PUT,DELETE같은 Method를 제공한다.


**3. 표현(Representation)**

클라이언트가 서버로 요청을 보냈을 때 서버가 응답으로 보내주는 자원의 상태를 Representation이라고 한다.
REST에서 하나의 자원은 JSON, XML, TEXT, RSS등 여러 형태의 Representation으로 나타낼 수 있다.

<br><br>

## **REST API의 설계 가이드**

리소스에 대한 행위는 HTTP Method(POST, GET, PUT, DELETE)로 표현해야 한다.
/(슬래시)는 계층관계를 나타낼 때 사용한다.
URL 마지막 문자에 /(슬래시)를 사용하지 않는다.
URL에 _(underscore)는 사용하지 않도록 합니다. 또한 영어 대문자보다는 소문자를 쓴다.
URL에 동사는 GET,POST와 같은 HTTP Method를 사용하지 않고 동사가 아닌 명사를 사용한다.
URL에 파일의 확장자를 포함시키지 않는다.
<br><br>

## **RESTful API란?**

RESTful API는 REST API 설계 가이드를 따라 API를 만드는것 입니다. REST API 설계 가이드에 따라 API를 만들어서 웹 서비스를 제공하면 해당 웹 서비스는 RESTful하다고 한다.
<br><br>

### **- HTTP API와 REST API의 차이점.**

우아한형제들 김영한 개발이사님 답변에 따르면,
HTTP API와 REST API는 사실 거의 같은 의미로 사용하고 있다고 하셨다.
정확한 차이점으로 REST API는 HTTP 프로토콜을 따르면서 아래의 4가지 가이드 원칙을 지켜야 한다.


1. 자원의 식별
2. 메세지를 통한 리소스 조작
3. 자기서술적 메세지
4. 애플리케이션의 상태에 대한 엔진으로서 하이퍼미디어(HATEOAS)


이러한 제약 조건들을 완벽하게 지키면서 개발하는 것을 RESTful API라고 하는데 실무에서는 이런 방법으로 개발하는 것은 현실적으로 어렵고 개발비용 대비 효과가 있는 것도 아니다.
그런데 이미 많은 사람들이 이 조건들을 지키지 않아도 REST API라고 하기 때문에 HTTP API와 같은 의미로 사용하고 있다고 한다. 하지만 위 제약 조건들을 모두 지켜야 REST API라고 말할 수 있다.


참고
RESTful API란 무엇인가? - RESTful API 초보자 가이드 - AWS (amazon.com)
API, HTTP API, REST API 차이 (tistory.com)
API, REST API, RESTful API 개념정리 (velog.io)