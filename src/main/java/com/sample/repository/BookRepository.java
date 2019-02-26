package com.sample.repository;

//import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.sample.model.Book;

@Repository
@Transactional
@CrossOrigin(origins="http://localhost:4200")
public interface BookRepository extends JpaRepository<Book, Long> {
	
	/*@Query("SELECT COLUMN_NAME FROM information_schema.columns WHERE table_schema = ?1 and table_name= ?2" )
	public List<String> findColumnsName(String db, String tbl);*/
}
