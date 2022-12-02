# 자바 ArrayList 사용법

## **ArrayList란?**
* ArrayList는 List인터페이스를 상속받은 클래스로 크기가 가변적으로 변하는 선형리스트입니다.
* 일반적인 배열과 같은 순차리스트이며 인덱스로 내부의 객체를 관리한다는점등이 유사합니다.
* ArrayList는 객체들이 추가되어 저장 용량을 초과한다면 자동으로 부족한 크기만큼 저장 용량이 자동으로 늘어납니다. 이러한 특성을 자료의 개수가 정해지지 않았을 때 자주 사용합니다.

## **ArrayList 선언**
```java
import java.util.ArrayList;

ArrayList list = new Arraylist(); // 타입 미설정 시에는 Object로 선언된다.
ArrayList<Student> members = new ArrayList<Student>() // 타입 설정, Student객체만 사용가능
ArrayList<Integer> num = new ArrayList<>(); // new에서는 타입 생략 가능
ArrayList<Integer> num1 = new ArrayList<Integer>(10); //초기 용량 지정
ArrayList<Integer> num2 = new ArrayList<Integer>(ArrayList.asList(1,2,3)); // 생성동시에 값 추가.
```
* ArrayList선언 시 타입을 설정하지 않을 경우 임의의 값을 추가하여 사용할 수 있지만 값을 뽑아내기 위해서 캐스팅이 필요하여 사용시에는 주로 타입을 지정하여 선언해야합니다.

## **ArrayList 값 추가**
```java
ArrayList<Student> members = new ArrayList<Student>(); //Student객체를 가진 ArrayList members객체 선언
Student student1 = new Student(name, age);
members.add(student1);
members.add(new Student("jack", 24));
```
* ArrayList에 값을 추가하려면 ArrayList의 add(index, value) 메소드를 사용해야합니다.
* index를 생략하면 ArrayList 맨 뒤에 데이터가 추가됩니다.
  * ex) index가 5인상태에서 add를 한다면 index는 6으로 증가
* index 중간애 삽입하면 해당 인덱스부터 마지막 인덱스까지 모두 1씩 밀려납니다.

## **ArrayList 값 삭제**
```java
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
list.remove(1); //index 1 제거 -> 현재 ArrayList = [1,3]만 존재
list.clear(); //모든 값 제거
```
* ArrayList에 값을 제거하려면 ArrayList의 remove(index)메소드를 사용하면 됩니다.
* remove()함수를 사용하여 특정 인덱스의 객체를 제거하면 바로 뒤 인덱스부터 마지막 인덱스까지 자동으로 앞당겨집니다.
* 모든 데이터를 제거하려면 clear()메소드를 사용하면 됩니다.

## **ArrayList 크기 구하기**
```java
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
System.out.println(list.size()); //list 크기 : 3
```
* ArrayList의 크기를 구하라면 ArrayList의 size()메소드를 사용하면 됩니다.

## **ArrayList 값 출력**
```java
ArrayList<Integer> list = new ArrayList<Integet>(ArrayList.asList(1,2,3));

Integer i = list.get(0); // 0번째 index 출력.

for(int i : list)   //향상된 for문을 사용하여 ArrayList를 모두 출력할 수 있다.
    print(i);
```
* ArrayList의 get(index)메소드를 사용하면 ArrayList의 원하는 index의 값이 리턴됩니다.

## **ArrayList 값 검색**
```java
ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3));
System.out.println(list.contains(1)); //list에 1이 있는지 검색 : true
System.out.println(list.indexOf(1)); //1이 있는 index반환 없으면 -1
```
* ArrayList에서 값을 검색하려면 ArrayList의 contains(value) 메소드를 사용하면 됩니다.
* contains()함수를 사용 할 시 값이 있으면 true값이 반환되고 값이 없으면 false가 리턴됩니다.
* indexof()함수를 사용하면 찾는 값의 인덱스를 반환하고 찾는 값이 없으면 -1이 반환됩니다.  

[참고자료](https://coding-factory.tistory.com/551)