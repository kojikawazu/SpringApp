package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class InquiryModelTest {
	
	private InquiryModel model;
	
	@Before
	public void Setup() {
		// TODO セットアップ
		model= new InquiryModel();
	}
	

	@Test
	public void InitTest0() {
		// TODO コンストラクタテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getName(), "");
		assertEquals(model.getEmail(), "");
		assertEquals(model.getComment(), "");
		assertEquals(model.getCreated().toString(), dateTime.toString());
		assertNull(model.getReplyList());
	}
	
	@Test
	public void InitTest1() {
		// TODO コンストラクタテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		model.setId(1);
		model.setName("テストネーム");
		model.setEmail("テストメールアドレス");
		model.setComment("テストコメント");
		model.setCreated(dateTime);
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getName(), "テストネーム");
		assertEquals(model.getEmail(), "テストメールアドレス");
		assertEquals(model.getComment(), "テストコメント");
		assertEquals(model.getCreated().toString(), dateTime.toString());
		
	}

}
