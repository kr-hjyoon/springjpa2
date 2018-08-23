package com.hjyoon;

import com.hjyoon.domain.Board;
import com.hjyoon.persisitence.BoardRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springjpa2ApplicationTests {

	@Autowired
	private BoardRepository repo;

	//@Test
	public void testInsert200() {
		for(int i=1 ; i <= 200 ; i++){
			Board board = new Board();
			board.setTitle("제목"+i);
			board.setContent("내용입니다."+i);
			board.setWriter("작성자"+ (i % 10));
			repo.save(board);
		}
	}

	//@Test
	public void testByTitle(){
		repo.findBoardByTitle("제목177").forEach( board -> System.out.print(board) );

	}

	//@Test
	public void testByTWriter() {
		//repo.findByWriter("작성자0").forEach( board -> System.out.print(board) );

		Collection<Board> boards = repo.findByWriter("작성자0");
		boards.forEach(board -> System.out.println(board));
	}


	//@Test
	public void testByWriterContaining(){
		repo.findByWriterContaining("0").forEach( board -> System.out.println(board) );
	}

	//@Test
	public void testByWriterStartingWith(){
		repo.findByWriterStartingWith("작성").forEach( board -> System.out.println(board) );
	}

	//@Test
	public void testByWriterEndingWith(){
		repo.findByWriterEndingWith("9").forEach( board -> System.out.println(board) );
	}

	//@Test
	public void testByTitleAndWriter(){
		repo.findByTitleAndWriter("제목88","작성자8").forEach( board -> System.out.println(board) );
	}

	//@Test
	public void testByTitleOrWriter(){
		repo.findByTitleOrWriter("제목88","작성자7").forEach( board -> System.out.println(board) );
	}

	//@Test
	public void findByOrderByBnoDesc(){
		repo.findByOrderByBnoDesc().forEach( board -> System.out.println(board) );
	}

	//@Test
	public void testByBnoGreaterThan(){
		repo.findByBnoGreaterThan(190L).forEach( board -> System.out.println(board) );
	}

	@Test
	public void testByBnoLessThan(){
		repo.findByBnoLessThan(10L).forEach( board -> System.out.println(board) );
	}



}
