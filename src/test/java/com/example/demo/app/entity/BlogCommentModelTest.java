package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class BlogCommentModelTest {

	BlogCommentModel model;
	
	@Before
	public void Setup() {
		model = new BlogCommentModel();
	}
	
	@Test
	public void InitTest0() {
		// TODO 初期コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getName(), "");
		assertEquals(model.getThanksCnt(), 0);
		assertEquals(model.getComment(), "");
		assertEquals(model.getBlogid(), 0);
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}

	@Test
	public void InitTest() {
		// TODO 値設定後のテスト
		LocalDateTime dateTime = LocalDateTime.now();
		
		model.setId(1);
		model.setName("テスト");
		model.setThanksCnt(0);
		model.setComment("テストコメント");
		model.setBlogid(1);
		model.setCreated(dateTime);
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getName(), "テスト");
		assertEquals(model.getThanksCnt(), 0);
		assertEquals(model.getComment(), "テストコメント");
		assertEquals(model.getBlogid(), 1);
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}
}
