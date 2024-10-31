package edu.kh.todo.model.service;

import java.util.Map;

public interface TodoService {

	/**(TEST)todoNo가 1인 할일 제목 조회
	 * @return title
	 * */
	String testTitle();

	/**할일 목록 + 완료된 할일 갯수 조회
	 *  @return map
	 * */
	Map<String, Object> selectAll();

	/**할일 추가
	 * @param todoTitle
	 * @param todoContent
	 * @return result
	 * */
	int addTodo(String todoTitle, String todoContent);

}
