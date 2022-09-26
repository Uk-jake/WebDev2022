# Django_Routing URL

## Routing이란?

우리가 네트워크에서 특정 경로로 데이터를 보낼때 사용되는 과정을 말한다.

![Untitled](/Django%EA%B0%9C%EB%85%90/image/Routing.png)

Django로 URL요청이 들어오면

Project에 있는 urls.py을 통하여 적절한 app으로 경로가 매핑되고

app에 있는 urls.py에서는 적절한 view에게 경로가 매핑된다.