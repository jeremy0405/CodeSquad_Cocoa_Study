# 예외처리

## 프로그램 에러

### 런타임 에러
- 런타임
  - 컴파일 과정을 마친 응용 프로그램이 사용자에 의해서 실행되어지는 '때(time)'를 의미합니다.
- 런타임 에러
  - 실행 시 발생하는 에러

### 컴파일 에러
- 컴파일
  - 개발 언어로 소스코드가 작성되어, 컴파일 과정을 통해 컴퓨터가 인식할 수 있는 기계어 코드로 변환되어 실행 가능한 프로그램이 되는 과정
- 컴파일 에러
  - 컴파일 시에 발생하는 에러

### 논리적 에러
- 컴파일, 실행도 다 잘 되지만 의도한 것과 다르게 동작하는 것

## 에러와 예외의 상속 관계도
<img width="1012" alt="스크린샷 2021-11-29 오후 7 45 17" src="https://user-images.githubusercontent.com/73376468/143854220-888fc82a-661b-4825-9c6c-70875e955063.png">

- 오류(Error)는 시스템이 종료되어야 할 수준의 상황과 같이 수습할 수 없는 심각한 문제를 의미합니다. 개발자가 미리 예측하여 방지할 수 없습니다.
- 반면 예외(Exception)는 개발자가 구현한 로직에서 발생한 실수나 사용자의 영향에 의해 발생합니다. 오류와 달리 개발자가 미리 예측하여 방지할 수 있기에 상황에 맞는 예외처리(Exception Handle)를 해야합니다.


## 에러
- StackOverflowError : 호출의 깊이가 깊어지거나 재귀가 지속되어 stack overflow 발생 시 던져지는 에러입니다.
- OutOfMemoryError : JVM이 할당된 메모리의 부족으로 더 이상 객체를 할당할 수 없을 때 던져지는 에러입니다. Garbage Collector에 의해 추가적인 메모리가 확보되지 못하는 상황이기도 합니다.


## 예외
| |검사 예외 Checked Exception|비검사 예외 Unchecked Exception|
|------|---|---|
|애플리케이션에서 예외 처리 여부|반드시 예외 처리 코드가 있어야 한다.|강제가 아니다.|
|예외의 확인 시점|컴파일 단계에서부터 컴파일이 되지 않는다.	|런타임 중 예외가 확인된다.
|
|예외 발생시 트랜잭션 처리	|기본적으로 Roll-back 하지 않는다.	|기본적으로 Roll-back을 한다.|
|대표적인 클래스|Exception을 상속 받는 클래스중 RuntimeException을 제외한 모든 예외 클래스IOException SQLException|RuntimeException을 상속받는 모든 클래스 NullPointerException IndexOutOfBoundException|||
 
### 검사예외 (Checked Exception)
- 컴파일 시점에서 예외를 검사하기 때문에 처리를 하지 않을경우 컴파일 에러가 발생합니다.
- Exception 클래스를 상속 받으나, RuntimeException 클래스는 상속 받지 않는 예외 클래스를 의미합니다
- 프로그램 실행 흐름상 예외발생 가능성 있는 상황을 표현
- 코드상의 문제가 아니라, 실행상황에 따라 발생가능성 있는 예외
- 프로그램 구현 흐름상 발생할 수 있는 예외

- Exception 클래스들은 주로 외부에 영향으로 발생할 수 있는 것들로, 대표적으로 I/O 입출력에 의해 발생하는 경우가 많다.
(ex: 클래스의 이름을 잘못 적거나, 데이터 형식이 잘못되었거나, 사용자가 존재하지않는 파일명을 입력한 경우)
### 비검사예외 (Unchecked Exception)
- 컴파일 시점에서 체크하지 않고 런타임 시점에 체크하는 예외입니다.
- RuntimeException을 상속받습니다.
- RuntimeException 클래스들은 주로 프로그래머의 실수에 의해 발생될 수 있는 예외들이다.
   (ex: 배열의 범위를 벗어나거나, 값이 null인 참조 변수의 멤버를 호출하려 하는 경우)
  - 코드를 잘못 짠 경우
  - 흐름보다는 기본적인 부분의 에러.
  - 컴파일 하는데 문제는 없지만 실행하면 문제가 발생함.
### 검사 예외의 종류
- ClassNotFoundException
  - 존재하지 않는 클래스를 사용하려고 할 때 발생한다.
- InterruptedException 
  - 인터럽트 되었을 때 발생한다.
- NoSuchFieldException	
  - 클래스가 명시한 필드를 포함하지 않을 때 발생한다.
- NoSuchMethodException	
  - 클래스가 명시한 메서드를 포함하지 않을 때 발생한다.
- IOException
  - 데이터 읽기 같은 입출력 문제가 있을 때 발생한다.

### 비검사 예외의 종류
- NullPointerException
  - 객체 참조가 없는 상태, 즉 null 값을 갖는 참조 변수로 객체 접근 연산자인 도트(.)를 사용했을 때 발생한다. 객체가 없는 상태에서 객체를 사용하려 했으니 예외가 발생하는 것이다.
- ArrayIndexOutOfBoundsException
  - 배열에서 인덱스 범위를 초과하여 사용할 경우인 에러이다.
- ArithmeticException
  - 산술연산 에러이고  0으로 나눌 때 에러가 발생한다.
  
출처 : [deftkang의 IT 블로그](https://deftkang.tistory.com/44)   
      [미니 블로그](https://otrodevym.tistory.com/entry/Java-%EA%B2%80%EC%82%AC-%EC%98%88%EC%99%B8Checked-%EC%99%80-%EB%B9%84%EA%B2%80%EC%82%AC-%EC%98%88%EC%99%B8UnChecked#:~:text=Java%EC%9D%98%20%EC%98%88%EC%99%B8%20%EC%B2%98%EB%A6%AC%EB%8A%94,%EC%9D%98%20%EB%B9%84%EA%B2%80%EC%82%AC%20%EC%98%88%EC%99%B8%EC%9D%B4%EB%8B%A4.)