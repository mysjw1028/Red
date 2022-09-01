package site.metacoding.red.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.red.domain.users.users.Users;
import site.metacoding.red.domain.users.users.UsersDao;
import site.metacoding.red.web.dto.request.users.JoinDto;
import site.metacoding.red.web.dto.request.users.UpdateDto;
import site.metacoding.red.web.dto.resonse.RespDto;

@RequiredArgsConstructor//final 붙은거만 인식한다
@RestController
public class UsersController {

	private final UsersDao usersDao;// fianl로 정리된 필드는 해당개체가 new 될대 값이 있어야함 찾을때 타입으로 찾는다.

	@GetMapping("/users/{id}")
	public RespDto<?> getUsers(@PathVariable Integer id) {// 자바 오브젝트는 제이슨으로 리턴		
		return new RespDto<>(1,"성공",(id));//타입은 앞에서만 결정
	}

	@GetMapping("/users")
	public  RespDto<?> GetUsersList() {
		return new RespDto<>(1,"성공",usersDao.findAll());//타입은 앞에서만 결정
	}
	
	@PostMapping("/users")//통신은 통일해야한다.
	public RespDto<?>insert(JoinDto joinDto) {//? -> 리턴타입이 오브젝트라고 한다
		usersDao.insert(joinDto);
		return new RespDto<>(1,"회원가입완료",null);//201번 - insert됨
	}
	
	@PutMapping("/users/{id}")
	public RespDto<?> update(@PathVariable Integer id ,UpdateDto updateDto){//외부통신을 위한 디티오는 따로 만들어야한다
		
		//1번 : id로 select한다 (영속화)
		Users usersPS =usersDao.findById(id);
		
		//2번:변경
		usersPS.전체수정(updateDto);
		
		//3번 : 영속화된 오브젝트로 update하기
		usersDao.update(usersPS);
		return new RespDto<>(1,"회원수정 완료",null);
	}
	
	@PutMapping("/users/{id}/password")//주소는 명사만 넣어야한다
	public RespDto<?> updatePassword(@PathVariable Integer id ,String password){//외부통신을 위한 디티오는 따로 만들어야한다
		//1번 영속화
		Users usersPS = usersDao.findById(id);
	
		//2번 변경
		usersPS.패스워드수정(password);
		
		//3번 전체 업데이트 메서드가 하나만 있어야한다 
		usersDao.update(usersPS);
		return new RespDto<>(1,"회원패스워드 수정완료",null);
	}
	
	@DeleteMapping("/users/{id}")
	public RespDto<?> delete(@PathVariable Integer id){
		usersDao.delete(id);
		return new RespDto<>(1,"회원삭제 완료",null);
	}
	
}
