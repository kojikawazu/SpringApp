package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class BlogReplyModelTest {
	
	private BlogReplyModel model;
	
	@Before
	public void SetUp() {
		// TODO セットアップ
		model= new BlogReplyModel();
	}

	@Test
	public void InitTest0() {
		// TODO コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getCommentid(), 0);
		assertEquals(model.getName(), "");
		assertEquals(model.getComment(), "");
		assertEquals(model.getThanksCnt(), 0);
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}
	
	@Test
	public void InitTest1() {
		// TODO コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		model.setId(1);
		model.setCommentid(1);
		model.setName("テストネーム");
		model.setComment("テストコメント");
		model.setThanksCnt(1);
		model.setCreated(dateTime);
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getCommentid(), 1);
		assertEquals(model.getName(), "テストネーム");
		assertEquals(model.getComment(), "テストコメント");
		assertEquals(model.getThanksCnt(), 1);
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}

}
