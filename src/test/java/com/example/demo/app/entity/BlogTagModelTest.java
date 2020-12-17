package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class BlogTagModelTest {
	
	private BlogTagModel model;
	
	@Before
	public void SetUp() {
		// TODO セットアップ
		model = new BlogTagModel();
	}

	@Test
	public void InitTest0() {
		// TODO コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getTag(), "");
	}
	
	@Test
	public void InitTest1() {
		// TODO コンストラクタのテスト
		model.setId(1);
		model.setTag("テストタグ");
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getTag(), "テストタグ");
	}

}
