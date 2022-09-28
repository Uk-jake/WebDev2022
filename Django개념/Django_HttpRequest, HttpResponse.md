# Django_HttpRequest, HttpResponse

## 서버 - 클라이언트

1. 페이지에서 요청(request)가 날라오면, 장고는 HttpRequest객체를 생성한다.
2. 장고는 url.py에서 정의한 View클래스 or  함수에 첫번째 인자로 해당 객체(request)를 전달한다.
3. 해당 View는 결과값(return)을 HttpResponse or JsonResponse 객체에 담아서 전달한다.

### HttpRequest

- 클라이언트로부터의 모든 요청 내용을 담고 있다.
    - 함수 기반 뷰 : 매 요청시마다 뷰 함수의 첫번째 인자 request로 전달.
- Form 처리 관련 속성들
    - .method : 요청의 종류 GET , POST로서 모두 대문자.
    - .GET : GET 인자 목록
    - .POST : POST인자 목록
    - .FILES : POST인자 중에서 파일 목록
    - .body : request의 body 객체
    - .COOKIES : 모든 쿠키를 담고 있는 딕셔너리 객체

### HttpResponse

- 다양한 응답을 Wrapping : HTML 문자열, 이미지 등 # 주로 html을 반환
- View에서는 반환값으로서 HttpResponse 객체를 기대 Middleware에서 HttpResponse객체를 기대
- 하나의 함수는 최소 하나의 HttpResponse를 반환해야한다.

참고자료([HttpRequest, HttpResponse, JsonResponse (tistory.com)](https://devdongbaek.tistory.com/82))