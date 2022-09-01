package site.metacoding.red.domain.users.boards;

import java.util.List;

import site.metacoding.red.domain.users.users.Users;
import site.metacoding.red.web.dto.request.boards.WriteDto;
import site.metacoding.red.web.dto.request.users.JoinDto;

public interface BoardsDao {//무조건 있어야함
	public void insert(WriteDto writeDto);
	public Users findById(Integer id);
	public List<Boards>findAll();
	public void update(Boards boards);
	public void delete(Integer id);
}
