package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class BlogMainModelTest {
	
	private BlogMainModel model;
	
	@Before
	public void Setup() {
		// TODO セットアップ
		model = new BlogMainModel();
	}

	@Test
	public void InitTest0() {
		// TODO 初期コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getTitle(), "");
		assertEquals(model.getTag(), "");
		assertEquals(model.getComment(), "");
		assertEquals(model.getThanksCnt(), 0);
		assertEquals(model.getCreated().toString(), dateTime.toString());
		assertEquals(model.getUpdated().toString(), dateTime.toString());
		assertNull(model.getReplyList());
	}
	
	@Test
	public void InitTest1() {
		// TODO 初期コンストラクタのテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		model.setId(1);
		model.setTitle("テストタイトル");
		model.setTag("テストタグ");
		model.setComment("テストコメント");
		model.setThanksCnt(1);
		model.setCreated(dateTime);
		model.setUpdated(dateTime);
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getTitle(), "テストタイトル");
		assertEquals(model.getTag(), "テストタグ");
		assertEquals(model.getComment(), "テストコメント");
		assertEquals(model.getThanksCnt(), 1);
		assertEquals(model.getCreated().toString(), dateTime.toString());
		assertEquals(model.getUpdated().toString(), dateTime.toString());
		assertNull(model.getReplyList());
	}

}
