package site.metacoding.red.domain.users;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.red.web.dto.request.users.UpdateDto;

@Getter
public class Users {//디비랑 통신하기위한 디티오
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Timestamp createdAt;
	
	public void 패스워드수정(String password) {//기존값들이 있어야만 수정이 된다. -> 개념은 항상 전체 업데이트 
		this.password = password;
	}
	
	
	public void 전체수정(UpdateDto updateDto) {//영속화를 시키고 때린다
		this.username = updateDto.getUsername();
		this.password = updateDto.getPassword();
		this.email = updateDto.getEmail();
	}
	
}
