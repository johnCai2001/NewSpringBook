package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository <BookEntity,Long> {

	public List<BookEntity> findAll();
}
