# **자바 HashSet**

## HashSet이란?
* Set인터페이스에서 지원하는 구현 클래스이다.
* 순서대로 입력되지 않고 일정하게 유지되지 않는다.
* null 요소도 허용한다.
* **가장 큰 특징은 중복을 허용하지 않는 것이다.**

## HashSet이 중복을 걸러내는 과정
HashSet은 객체를 저장하기 전에 먼저 객체의 hashCode()메소드를 호출해서 해시 코드를 얻음.  
저장되어 있는 객체들의 해시 코드와 비교한 뒤 동인한 해시 코드가 있다면  
equal()메소드로 두 객체를 비교해서 true가 나오면 동일한 객체로 판단한고
중복 저장을 하지 않는다.

## HashSet 변수 선언
```java
HashSet<Integer> set new HastSet<Integer>();
HashSet<String> set new HastSet<String>();
```

## HashSet 값 추가
```java
HashSet<Integer> set new HastSet<Integer>();

set.add(1);
set.add(2);
set.add(3);
set.add(4);

```

## HashSet 값 삭제
```java
HashSet<Integer> set new HastSet<Integer>();

set.remove(1);  //1값만 삭제
set.clear();    //Set에 있는 모든 값 삭제

```

## HashSet 크기 구하기
```java
HashSet<Integer> set new HastSet<Integer>();

set.size();

```

## HashSet 검색하기
```java
HashSet<Integer> set new HastSet<Integer>();

set.contains(1);    //1값이 있으면 true값 반환 없으면 false값 반환

```


[참고자료](https://crazykim2.tistory.com/474)