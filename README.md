# SimpleS3FileUpload
spring-boot AWS S3 image upload


### 따라한 예제 posting
https://jojoldu.tistory.com/300


### 개발환경
* STS4 ( spring-boot 2.1.2 RELEASE )
* spring-cloud-aws-dependencies 2.1.0
* maven
* template : thymeleaf


### 겪었던 에러들
1. `Error creating bean with name 'stackResourceRegistryFactoryBean' defined in class path resource [org/springframework/cloud/aws/autoconfigure/context/ContextStackAutoConfiguration.class]: Bean instantiation via factory method failed;`
   * application.properties에 cloud.aws.stack.auto=false 설정 추가

2. `com.amazonaws.SdkClientException: Unable to load AWS credentials from any provider in the chain: [com.amazonaws.auth.EC2ContainerCredentialsProviderWrapper@27966721: Unable to load credentials from service endpoint, com.amazonaws.auth.profile.ProfileCredentialsProvider@1fc36b75: profile file cannot be null]`
   * configuration클래스를 만들어서 accessKey, scretKey 세팅
Credential에러가 나서 다른 블로그를 보고 @configuration 클래스를 만들어보니 잘 되긴 하는데 사용한것들 대부분이 @Deprecated 되어있었습니다. 이 방법은 좋은방법이 아닌거 같습니다

3. `template might not exist or might not be accessible by any of the configured Template Resolvers`
   * @PostMapping 어노테이션 밑에 @ResponseBody 어노테이션을 빠트려서 생긴 문제
   * @Controller의 경우 return값으로 view를 리턴하기때문에 `@ResponseBody` 어노테이션을 달아서 HTTP ResponseBody로 직접 리턴하게 해야한다
   * 아니면 '/upload' 메서드를 @RestController로 분리하면 @ResponseBody 어노테이션이 없어도 알아서 된다.
