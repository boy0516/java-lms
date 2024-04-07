# 학습 관리 시스템(Learning Management System)
## 진행 방법
* 학습 관리 시스템의 수강신청 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

# todo
- [x] Question 에 삭제 상태 변경 추가
- [x] Answer에 삭제 상태 변경 추가
- [x] Answer 일급컬렉션 추가

# todo
### 수강신청
- 과정
  - [] 강의 수강신청 
  - 강의
    - 시작일
    - 종료일
    - 커버 이미지
      - 이미지 크기
        - [X] 1MB 이하 허용 검증 
      - 이미지 타입
        - [X] gif, jpg(jpeg 포함), png, svg만 허용
      - 이미지 비율
        - width
          - [X] 300px 이상 값 검증
        - height
        - [X] width, heigth 비율 3:2 검증
    - 강의타입(유료, 무료)
      - 유료 강의
        - 유료 강의 최대 수강 인원 제한 검증
          - [] 유료 강의 최대 수강 인원 초과 검증.
      - 무료 강의
        - 무료 강의 최대 수강 인원 무제한 검증
    - 강의 상태(준비중, 모집중, 종료)
    - [] 강의 수강신청
      - [] 수강생이 결제한 금액 == 수강료 검증
      - [] 강의 상태가 준비중 검증
