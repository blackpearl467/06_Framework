package edu.kh.todo.model.service;

import java.util.List;
import java.util.Map;

import edu.kh.todo.model.dto.Todo;

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

	/**할일 상세조회
	 * @param todoNo
	 * @return todo
	 * */
	Todo todoDetail(int todoNo);

	/**완료여부 변경
	 * 
	 * 
	 * */
	int changeComplete(Todo todo);

	/** 할일 수정
	 * @param todo
	 * @return result
	 */
	int todoUpdate(Todo todo);

	/** 할 일 삭제
	 * @param todoNo
	 * @return result
	 */
	int todoDelete(int todoNo);

	/**전체 할일 개수 조회
	 * @return
	 * */
	int getTotalCount();

	/**완료된 할일 개수 조회
	 * @return
	 * */
	int getCompleteCount();

	/**할일 목록 조회
	 * @return
	 * */
	List<Todo> selectList();

}
