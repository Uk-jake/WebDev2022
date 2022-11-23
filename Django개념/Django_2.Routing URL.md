# Django_Routing URL

## Routing이란?
Routing이란 우리가 네트어크에서 특정 경로로 데이터를 보낼 때 사용되는 과정을 합니다.
Routing은 네트워크를 다룰 때 많이 사용되는데 Django에서 Routing이 어떤 식으로 되는지 간단히 설명드리겠습니다.

![Untitled](//Django%EA%B0%9C%EB%85%90/image/Routing.png)

1. 사용자가 서버로 URL요청.
2. Django는 Project의 Url.py에서 알맞는 Url주소가 있는지 확인.
3. 지정된 url주소가 있다면 지정된 view페이지를 사용자에게 전달.

이러한 요청의 구성을 효율적으로 처리하기위해서는 최적화된 로직을 사용해야합니다.