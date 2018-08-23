package com.hjyoon.persisitence;

import com.hjyoon.domain.Board;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by user on 2018-08-13.
 */
@Repository
public interface BoardRepository extends CrudRepository<Board,Long>{


		public List<Board> findBoardByTitle(String title);

		// Entity 이름을 생략하는 경우 현재 실행하는 Repository의 타입 정보를 기준으로 작동하게 되낟.
		public Collection<Board> findByWriter(String writer);

		//  '%{키워드}%' 예제
		public Collection<Board> findByWriterContaining(String writer);

		//  '{키워드}%' 예제
		public Collection<Board> findByWriterStartingWith(String writer);

		//  '%{키워드}' 예제
		public Collection<Board> findByWriterEndingWith(String writer);

		//  And 조건 예제
		public Collection<Board> findByTitleAndWriter(String title, String writer);

		//  Or 조건 예제
		public Collection<Board> findByTitleOrWriter(String title, String writer);

		//  OrderBy  조건 예제			, Order by + 속성 + Desc or Asc
		public Collection<Board> findByOrderByBnoDesc();

		//  > <  예제   GreaterThan or LessThan
		public Collection<Board> findByBnoGreaterThan(Long bno);
		public Collection<Board> findByBnoLessThan(Long bno);


}
