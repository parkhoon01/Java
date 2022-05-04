# Java

# 객체 지향 프로그래밍(Object-oriented Programming)

현실에 존재하는 사물과 개념을 소프트웨어적으로 구현하고, 그 구현된 객체들이 서로 상호작용하여 데이터를 처리하는 방식.

- 코드에 재사용성이 높다.
- 신뢰성이 높은 프로그래밍을 가능하게 한다.
- 코드관리가 용이하다.

## 클래스

객체의 속성과 기능등을 정의한 설계도

```
ex)붕어빵 틀
인스턴스 변수: 객체마다 가지는 고유한 변수
클래스 변수: 모든 인스턴스가 공통된 값을 공유하는 변수
메서드: 특정한 작업이나 논리를 구성하는 코드를 괄호로 묶어 놓은 것.

인스턴스
클래스를 메모리에 생성한 것
ex) 붕어빵
```
### 인스턴스 생성과 사용

클래스명 변수명;   // 클래스의 객체를 참조하기 위한 참조 변수
변수명 = new 클래스명();   // 클래스의 객체를 생성후, 객체의 주소를 참조변수에 저장.

```java
pacakge com.pcwk.oop01;
public class TvMain{
  public static void main(String[] args){
    Tv t; // Tv 인스턴스를 참조하기 위한 변수 t
    t = new Tv(); // Tv 인스턴스를 생성
    
    System.out.println("전원: " + t.power);
    t.power();  // 전원 켜기
    System.out.println("전원: " + t.power);
    
    t.channel = 3;  // tvN
    t.volume = 11;
    
    System.out.println("현 채널: " + t.channel);
    System.out.println("볼륨: " + t.volume);
    
    // 메서드 호출
    t.channelUp();
    System.out.println("형채널: " + t.channel_'
    
    // 전원off
    t.power();
    System.out.println("전원: " + t.power);
  }
}
```


# 추상 클래스

추상 메서드를 멤버로 가지는 클래스

## 추상 메서드

선언부만 있고 구체적인 내용은 비워놓은 메서드

```
abstract class 클래스명{
  abstract void play(int pos);  // 추상 메서드
  abstract void stop();         // 추상 메서드
  
  void disp(){}   // 일반 메서드
}
```
