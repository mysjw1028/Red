package site.metacoding.red.domain.boards.mapper;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter//안필요하면 그때 지우기
public class BoardsDetail {//엔티티는 아님 / 자바오브젝트로 받을 오브젝트가 없어서 만들었다. 조인한 결과를 받음 xml 이랑 같게 해야함
	private Integer id;
	private String title;
	private String content;
	private Timestamp createdAt;
	private Integer usersId;
	private String username;
	private String password;
	private String email;
	
}
