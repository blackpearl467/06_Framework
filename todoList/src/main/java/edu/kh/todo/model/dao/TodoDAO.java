package edu.kh.todo.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.todo.model.mapper.TodoMapper;

@Repository //DAO 계층 역할 명시 + Bean 등록
public class TodoDAO {//그냥 테스트용

	@Autowired
	private TodoMapper mapper; //TodoMapper 인터페이스를 상속받은 자식객체
								//그 자식객체가 sqlSessionTemplate 이용
	public String testTitle() {
		
		
	/**(TEST) todoNo가 1인 할일 제목 조회
	 * @return title
	 * */	
		return mapper.testTitle();
	}

}
