# Google_Analystics4
크게 두가지 형태로 만들었습니다.     

&nbsp;&nbsp;&nbsp;&nbsp; 1.RestTemplate API    
&nbsp;&nbsp;&nbsp;&nbsp; 2.RunReport API   
<br>

## 1.RestTemplate + Google Oauth2.0
자바에서 외부 API와 통신할 수 있게 하는 API인 RestTemplate과 Google Oauth2.0으로 인증한 방법

## 2.RunReport + service account
구글 공홈 가이드의 추천으로 RunReport API와 service account 인증방식으로 만든 방법
<br>    


#### *service account방식
OS의 환경변수에 구글에서 제공한 인증키인 json파일을 GOOGLE_APPLICATION_CREDENTIALS 이름에 등록하면    
자동으로 해당 환경변수를 찾아 인증되는 방식


<br>

### ※ yml에서 각종 정보를 가져오기 위해 @Value, @ConfigurationProperties 사용     

#### @Value
개별 속성 값을 나눠 주입     
SpEL(Spring Expression Language)을 지원    
타입 변환 자동 처리    

Spring 3.0 ↑    
 
- 설정 값이 간단하거나, 복잡한 계산이 필요한 경우 SpEL과 함께 사용    


#### @ConfigurationProperties
관련 속성들을 한 번에 바인딩    
관련된 속성들을 하나의 클래스로 그룹화하여 관리    
타입 안전성 제공(컴파일 타임에 프로퍼티 타입 체크)    
@Validated 어노테이션과 함께 사용하여 검증 로직을 추가 가능     
IDE 지원이 우수하여, 프로퍼티의 자동 완성, 탐색, 리팩토링 등이 가능    

Spring Boot 1.2.0 ↑ (Spring Boot의 일부)     
Spring 지원X    

- 여러 관련 설정을 하나의 빈으로 묶어 관리해야 할 때 유용    
- 타입 안전성이 중요하거나, 설정 값에 대한 검증 로직을 추가해야 할 경우 유용   
