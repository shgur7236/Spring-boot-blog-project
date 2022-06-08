package blogproject.blog.repository;


import blogproject.blog.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findByTitleOrContent(String title, String content);
}
