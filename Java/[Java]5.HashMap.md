# **자바 HashMap**

## HashSet이란?
* HashMap은 Map 인터페이스를 구현한 대표적인 Map컬렉션입니다.
* Map 인터페이스를 상속하고 있기에 Map의 성질을 그대로 가지고 있습니다.
* Map은 Key와 Value값으로 구성되어 있습니다.
* Value는 중복된 값을 가질 수 있지만 Key값은 중복될 수 없습니다. (Key = 중복X / Value = 중복 O)
* 만약 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대체됩니다.
* 검색하는데 있어서 뛰어난 성능을 보입니다.


## HashMap 변수 선언
```java
HashMap<String,String> map1 = new HashMap<String,String>(); //HashMap생성
HashMap<String,String> map2 = new HashMap<>(map1); //map1 HashMap그대로 생성
HashMap<String,String> map4 = new HashMap<>(10); //capacity 생성
```

## HashMap 값 추가
```java
HashMap<Integer,String> map = new HashMap<>();
map.put(1,"장욱");
map.put(2,"이진곤");
map.put(3,"이현수");
```

## HashMap 값 삭제
```java
map.remove(1); //key값 1 제거
map.clear(); //모든 값 제거
```

## HashMap 값 출력
```java
HashMap<Integer,String> map = new HashMap<Integer,String>(){{
        put(1,"장욱");    //Key = 1 : Value = "장욱"
        put(2,"이진곤");   //Key = 2 : Value = "이진곤"
        put(3,"이현수");   //Key = 3 : Value = "이현수"
        }};

System.out.println(map); //전체 출력 : {1=장욱, 2=이진곤, 3=이현수}
System.out.println(map.get(1));//key값 1의 value얻기 : 장욱

//entrySet() 활용
for (Entry<Integer, String> entry : map.entrySet()) {
System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
}
//[Key]:1 [Value]:장욱
//[Key]:2 [Value]:이진곤
//[Key]:3 [Value]:이현수

//KeySet() 활용
for(Integer i : map.keySet()){ //저장된 key값 확인
System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
}
//[Key]:1 [Value]:장욱
//[Key]:2 [Value]:이진곤
//[Key]:3 [Value]:이현수
```

[참고자료](https://coding-factory.tistory.com/556)