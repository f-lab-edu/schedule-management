# schedule-management
## 개요
진행중인 프로젝트 일정 관리 서버입니다.

## 기술 스택 및 아키텍처
* SpringBoot와 MyBatis를 이용하여 하나의 서버와 하나의 데이터베이스로 이루어진 모놀로틱 구조의 어플리케이션입니다.
* Database로 MySQL 도커를 사용합니다.
* 데이터를 보존하지 않을 계획이므로 볼륨 명시를 하지 않고 비즈니스 로직에 집중할 것입니다.

## 목표
* MyBatis 사용법을 익힙니다.
* Database Access 프로세스에 대하여 이해합니다.
* DML과 트랜잭션에 대하여 이해합니다.
* Table Join에 대하여 이해합니다.

## 기능
* 진행중인 프로젝트 CRD
* 일정 CRD
* 프로젝트에 연관된 일정 목록 조회

## ERD

<img width="391" alt="스크린샷 2022-08-01 오전 12 25 56" src="https://user-images.githubusercontent.com/22387547/182033592-de3966a1-5da1-41b6-b147-97013229d0c2.png">

Todo table와 Project table이 있으며, Todo table이 Project table id를 외래키로 가지고 있습니다.


## 브랜치 명명 규칙
* 혼자 작업하므로 main, feature 두 종류의 브랜치를 사용
* feature 브랜치 명명 규칙
    * feature/{#issue number}/{goal of branch}

## 이슈

