# Product Name
> Shoten URL Conversion Api

## Introduce
원하는 URL을 단축 URL로 변환하며 각 URL별 통계 정보를 얻기위해 만들었다.

## Fuction
* 원하는 URL을 단축 URL로 변환
```yml
# application.yml 파일에 변환될 URL 정의(도메인에 맞게 변경할 것)
# Define Your Shorten URL(Domain)
app:
  path:
    local: http://localhost:8098/shorten/
    
# Original URL을 단축 URL로 변환시 아래와 같은 형식으로 변환
http://localhost:8098/shorten/ + "랜덤 문자열"
ex) http://localhost:8098/shorten/JHMPWHEJ1D
```
* 단축 URL에 대한 통계정보 확인
```text
단축 URL에 대한 시간별, 날짜, 월별 접속 횟수
```  

## Details
* 컴파일 후 Swagger를 통해 Request와 Response 확인 가능  
http://localhost:8080/swagger-ui.html
