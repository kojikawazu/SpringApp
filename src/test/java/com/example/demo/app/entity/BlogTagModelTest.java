package com.example.demo.app.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BlogTagModelTest {

	@Test
	public void InitTest0() {
		// TODO コンストラクタのテスト
		BlogTagModel model = new BlogTagModel();
		
		Assertions.assertEquals(model.getId(), 0);
		Assertions.assertEquals(model.getTag(), "");
	}
	
	@Test
	public void InitTest1() {
		// TODO コンストラクタのテスト
		BlogTagModel model = new BlogTagModel();
		
		model.setId(1);
		model.setTag("テストタグ");
		
		Assertions.assertEquals(model.getId(), 1);
		Assertions.assertEquals(model.getTag(), "テストタグ");
	}

}
