# 소스코드 호출 순서

* web.xml로 부터 Context가 생성될 때 실행될 ServletContextListener 정보를 가져온다.
* ServletContextLoader가 실행된다.
	* initMapping() 메소드를 호출하여, Context에 mappings라는 URL 매핑 정보를 설정한다.
*  QnaContextLoaderListener가 실행된다.
	* 데이터베이스 스키마를 초기화한다.
* ListController가 실행되며 DAO를 통해 질문 목록을 리스트로 가져오며 list.jsp를 통해 브라우저로 출력한다.