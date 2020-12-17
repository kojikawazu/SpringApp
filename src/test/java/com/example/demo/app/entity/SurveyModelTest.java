package com.example.demo.app.entity;

import static org.junit.Assert.*;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

public class SurveyModelTest {
	
	private SurveyModel model;
	
	@Before
	public void SetUp() {
		// TODO セットアップ
		model = new SurveyModel();
	}

	@Test
	public void InitTest0() {
		// TODO コンストラクタテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		assertEquals(model.getId(), 0);
		assertEquals(model.getName(), "");
		assertEquals(model.getAge(), 0);
		assertEquals(model.getProfession(), 0);
		assertEquals(model.getMen_or_female(), 0);
		assertEquals(model.getSatisfaction(), 0);
		assertEquals(model.getComment(), "");
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}
	
	@Test
	public void InitTest1() {
		// TODO コンストラクタテスト
		LocalDateTime dateTime = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		
		model.setId(1);
		model.setName("テストネーム");
		model.setAge(10);
		model.setProfession(2);
		model.setMen_or_female(1);
		model.setSatisfaction(1);
		model.setComment("テストコメント");
		model.setCreated(dateTime);
		
		assertEquals(model.getId(), 1);
		assertEquals(model.getName(), "テストネーム");
		assertEquals(model.getAge(), 10);
		assertEquals(model.getProfession(), 2);
		assertEquals(model.getMen_or_female(), 1);
		assertEquals(model.getSatisfaction(), 1);
		assertEquals(model.getComment(), "テストコメント");
		assertEquals(model.getCreated().toString(), dateTime.toString());
	}

}
