# **향상된 for문**
향상된 for문을 사용하기 위해서는 2가지의 조건이 있습니다.
1. 일반 for문과 다르게 반복에 배열을 이용하고 배열이 이미 선어되어있어야합니다.
2. 배열의 길이로 for문의 반복 횟수가 정해집니다.

## **문법**
> for(자료형 변수명 : 배열명)

## **예시 코드**
```java
public class Main{
    public static void main(String[] args){
        int[] array = {1,2,3,4,5};

        for(int tmp : array){
            System.out.println(tmp);
        }
    }
}
```
위 코드의 결과값은
>1<br>
>2<br>
>3<br>
>4<br>
>5  

위와 같이 나옵니다.

이러한 향상된 for문을 사용하면 가독성이 올라가고 인덱스 문제를 방지할 수 있다.