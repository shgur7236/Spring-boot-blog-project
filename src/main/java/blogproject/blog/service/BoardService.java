package blogproject.blog.service;

import blogproject.blog.domain.board.Board;
import blogproject.blog.domain.board.BoardRepository;
import blogproject.blog.domain.user.User;
import blogproject.blog.dto.board.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto, User user){
        boardSaveRequestDto.setUser(user);
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }

    /**
     * 글목록 로직
     */
    public List<Board> findAll(){
        return boardRepository.findAll();
    }
}