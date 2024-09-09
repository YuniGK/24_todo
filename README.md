# TODO LIST

### 기능
추가 버튼을 통해 할일을 추가합니다.
수정 버튼을 통해 내용을 수정 또는 수정하지 않을 수 있습니다.
삭제 버튼을 통해 내용을 삭제합니다.

### DB
#### 테이블 생성
CREATE TABLE `todo` (
  `created_at` datetime(6) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `modified_at` datetime(6) NOT NULL,
  `deleted` varchar(255) DEFAULT '저장',
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) 

#### 더미 데이터
src > main > resources > data.sql

insert into todo (created_at, id, modified_at, title) values ('2024-09-20 09:44:40.000000', 1, '2024-09-20 09:44:40.000000', 'Mr 1');
insert into todo (created_at, id, modified_at, title) values ('2024-09-09 19:34:49.000000', 2, '2024-09-09 19:34:49.000000', 'Dr');
insert into todo (created_at, id, modified_at, title) values ('2024-09-21 17:23:37.000000', 3, '2024-09-21 17:23:37.000000', 'Ms');
insert into todo (created_at, id, modified_at, title) values ('2024-09-03 21:51:36.000000', 4, '2024-09-03 21:51:36.000000', 'Mrs');
insert into todo (created_at, id, modified_at, title) values ('2024-09-11 11:45:57.000000', 5, '2024-09-11 11:45:57.000000', 'Mr 2');

### 개발 환경
java 17
react
mysql

### 빌드 및 실행
react 
- 설치 파일
npm i @fortawesome/free-solid-svg-icons
npm i @fortawesome/free-regular-svg-icons   
npm i @fortawesome/react-fontawesome
npm i react-router-dom         
npm install http-proxy-middleware --save         
npm install axios --save    

frontend 파일 경로로 접속 후, npm start
또는 
https://blog.naver.com/nateen7248/222260723031

java
- 실행 시, 설정
IntelliJ > settings > Build, ... > Build Tools > Gradle
Build and run using : Gradle
Run tests using : Gradle

- 빌드


### API
http://localhost:8080/swagger-ui/index.html

조회
http://localhost:8080/todo

저장
http://localhost:8080/todo/insert

{
  "title": "test",
  "deleted": "저장"
}

수정
http://localhost:8080/todo/update/{id}

{
  "title": "test",
  "deleted": "저장"
}

삭제
http://localhost:8080/todo/deleted/{id}
삭제 시, 해당 id에 해당 하는 글 deleted 컬럼 "삭제"로 수정하였습니다.

### 컴퍼넌트
TodoContainer에서 api 연동의 부분을 수행했습니다. 
여러 곳에서 사용 할 경우 수정 시, 페이지를 찾지 못해 누락할 수 있을 것을 생각하여 한곳에서 작업했습니다.