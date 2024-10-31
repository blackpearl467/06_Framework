package edu.kh.todo.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
	//스펠링 맞고 카멜케이스만 써서 적으면됨
	private int todoNo; //할일 번호
	private String todoTitle; //할일 제목
	private String todoContent; //할일 내용
	private String complete; //할일 완료여부 ("Y", "N")
	private String regDate; //할일 등록일
}
