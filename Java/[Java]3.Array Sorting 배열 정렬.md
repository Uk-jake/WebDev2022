# **Java 배열 정렬(오릎차순, 내림차순)**
자바에서 배열을 정렬할 때는 java.uitl.Arrays 클래스의 sort() 메서드를 사용해야합니다.
Arrays클래스는 배열의 복사, 항목 정렬, 검색과 같은 배열을 조작할 수 있는 기능을 가지고 있습니다.

## 배열의 오름차순 정렬
Arrays.sort()메서드의 매개값으로 기본 타입 배열 또는
String 배열을 지정해주면 자동으로 오름차순 정렬이 됩니다.
```java
import java.uiti.Arrays;

public class Sort{
    public static void main(String[] args){
        int arr[] = {5, 3, 2, 1, 4};
        //배열 arr을 오름차순으로 정렬
        Arrays.sort(arr);
    }
}
```

## 배열의 내림차순 정렬
배열을 내림차순으로 정렬할 때는 Collections클래스의 reverseOrder()함수를 사용하면 됩니다.  
만약 기본 타입 배열을 내림차순으로 정렬하고 싶다면 기본 타입의 배열을 래퍼클래스로 만들어 Comparator를 두번째 인자에 넣어주어야 역순으로 정렬할 수 있습니다.
```java
import java.uiti.Arrays;

public class Sort{
    public static void main(String[] args){
        int arr[] = {5, 3, 2, 1, 4};
        //배열 arr을 내림차순으로 정렬
        Arrays.sort(arr,Collections.reverseOrder());
    }
}
```

## 배열의 일부분만 정렬
Arrays.sort()메서드의 매개값으로 배열, 시작 index, 끝 index를 넣어주면 일부분만 정렬할 수 있습니다.
```java
import java.uiti.Arrays;

public class Sort{
    public static void main(String[] args){
        int arr[] = {5, 3, 2, 1, 4};
        //배열 arr의 0번부터 2번까지만 정렬
        Arrays.sort(arr,0,2);
        // 정렬 결과 > { 2, 3, 5, 1, 4}
    }
}
```

## 객체 배열 정렬
기본적인 배열을 정렬하기 위해서는 Arrays.sort함수만 사용하여 정렬할 수 있지만  
객체로 이루어진 배열을 정렬하기 위해서는 Comparable인터페이스 또는 Comparator 인터페이스를 사용해야합니다.
Comparable과 Comparator는 정렬을 위한 인터페이스인데, 객체를 정렬하기 위해서는 인터페이스에 내부 구현되어 있는 함수를 오버라이딩을 해야합니다.

### Comparable 인터페이스
Comparable 인터페이스에는 comparaTo() 추상 메서드 하나만 존재해야합니다.
![img.png](asset/자바%20정렬%20img1.png)  
compareTo() 함수는 주어진 객체보다 작으면 음수, 같으면 0, 크면 양수를 리턴합니다.
객체를 정렬하기위해서는 이 comparaTo()함수를 오버라이딩하여 비교할 객체를 넣어 반환값을 변경해줘야합니다.
```java
class Students implements Comparable<Students> {
	public String name;
	public int age;
	
	public NameCard(String name, int age) {
		this.name = name;
		this.age = age;
	}

    //객체 배열을 정렬하기위한 오버라이딩
	@Override
	public int compareTo(NameCard o) {
		if(this.age < o.age) {
			return -1;
		} else if(this.age == o.age) {
			return 0;
		} else {
			return 1;
		}
	}
}

public class Sort{
    public static void main(String[] args)  {
        Students[] arr = {
                new Students("욱", 20),
                new Students("진곤", 14),
                new Students("현수", 31),
                new Students("도진", 40),
                new Students("상현", 24)
        };

        Arrays.sort(arr); //오름차순 정렬

        for (Students i : arr) { //오름차순 출력
            System.out.print("["+i.print()+"]");
        }

        Arrays.sort(arr,Collections.reverseOrder()); //내림차순 정렬
        System.out.println();

        for (Students i : arr) { //내림차순 출력
            System.out.print("["+i.print()+"]");
        }
    }
}

```
### Comparator 인터페이스
Comparable정렬이 일반적이고 객체에 이미 정해진 정렬이라면, Comparator는 조금 더 복잡하게 정렬도 가능하고 필요할 때마다 구현해서 사용할 수 있는 인터페이스입니다.
Comparator 인터페이스는 int compare(T t1,T t2)를 구현해줘야합니다.
```java
public class Sort{
    public static void main(String[] args)  {
        Students[] arr = {
                new Students("욱", 20),
                new Students("진곤", 14),
                new Students("현수", 31),
                new Students("도진", 40),
                new Students("상현", 24)
        };

        Comparator<Student> comparator = new Comparator<>(){
            @Override
            public int compare(Student t1, Student t2){
                return t1.age - t2.age;
            }
        };
        
        Collection.sort(arr, comparator);
    }
}
```  
위 코드는 Comparator 객체를 Collections.sort() 메서드의 두번째 인자로 넘겨서 이전 섹션과 동일한 정렬 결과를 만들어 내고 있고
이렇게 Comparator 객체를 인자로 넘기면, 정렬 대상 객체가 Comparable 인터페이스를 구현 여부와 상관없이, 
넘어온 Comparator 구현체의 compare() 메서드 기준으로 정렬을 수행한다. compare() 메서드는 비교 대상 2 개의 객체를 인자를 차례로 인자로 받습니다.
