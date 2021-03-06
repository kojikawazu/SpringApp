package com.example.demo.app.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.app.dao.BlogMainDao;
import com.example.demo.app.dao.BlogMainDaoSql;
import com.example.demo.app.entity.BlogMainModel;

class BlogMainServiceUseTest {
	
	// テスト対象
	BlogMainService service = null;
	
	LocalDateTime dateTime1 = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
	LocalDateTime dateTime2 = LocalDateTime.of(2000, 01, 02, 00, 00, 00);
	
	@Mock
	JdbcTemplate jdbcTemp = null;
	

	public void InitSelectAll() {
		// TODO 全て選択初期化
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		
		map.put("id", 1);
		map.put("title", "テストタイトル");
		map.put("tag", "テストタグ");
		map.put("comment", "テストコメント");
		map.put("thanksCnt", 1);
		map.put("created", Timestamp.valueOf(dateTime1));
		map.put("updated", Timestamp.valueOf(dateTime2));
		mapList.add(map);
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.queryForList(any())).thenReturn(mapList);
		
		setService();
	}
	
	
	@Test
	public void SelectAllTest() {
		// TODO 全選択テスト
		InitSelectAll();
		
		List<BlogMainModel> list = service.getAll();
		
		Assertions.assertEquals(list.size(), 1);
		Assertions.assertEquals(list.get(0).getId(), 1);
		Assertions.assertEquals(list.get(0).getTitle(), "テストタイトル");
		Assertions.assertEquals(list.get(0).getTag(), "テストタグ");
		Assertions.assertEquals(list.get(0).getComment(), "テストコメント");
		Assertions.assertEquals(list.get(0).getThanksCnt(), 1);
		Assertions.assertEquals(list.get(0).getCreated().toString(), dateTime1.toString());
		Assertions.assertEquals(list.get(0).getUpdated().toString(), dateTime2.toString());
		list.clear();
	}
	
	public void InitSelect_byId() {
		// TODO IDによるデータ取得初期化
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("id", 1);
		map.put("title", "テストタイトル");
		map.put("tag", "テストタグ");
		map.put("comment", "テストコメント");
		map.put("thanksCnt", 1);
		map.put("created", Timestamp.valueOf(dateTime1));
		map.put("updated", Timestamp.valueOf(dateTime2));
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.queryForMap(any(), eq(1))).thenReturn(map);
		when(jdbcTemp.queryForMap(any(), eq(2))).thenReturn(null);
		
		setService();
	}
	
	@Test
	public void Select_byIdTest() {
		// TODO 全選択テスト
		InitSelect_byId();
		
		BlogMainModel model = service.select(1);
		
		Assertions.assertNotNull(model);
		Assertions.assertEquals(model.getId(), 1);
		Assertions.assertEquals(model.getTitle(), "テストタイトル");
		Assertions.assertEquals(model.getTag(), "テストタグ");
		Assertions.assertEquals(model.getComment(), "テストコメント");
		Assertions.assertEquals(model.getThanksCnt(), 1);
		Assertions.assertEquals(model.getCreated().toString(), dateTime1.toString());
		Assertions.assertEquals(model.getUpdated().toString(), dateTime2.toString());
		
		model = service.select(2);
		Assertions.assertNull(model);
	}
	
	public void InitSelect_byTag() {
		// TODO タグ名によるデータ取得初期化
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> mapList2 = new ArrayList<Map<String, Object>>();
		
		map.put("id", 1);
		map.put("title", "テストタイトル");
		map.put("tag", "テストタグ");
		map.put("comment", "テストコメント");
		map.put("thanksCnt", 1);
		map.put("created", Timestamp.valueOf(dateTime1));
		map.put("updated", Timestamp.valueOf(dateTime2));
		mapList.add(map);
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.queryForList(any(), eq("テスト"))).thenReturn(mapList);
		when(jdbcTemp.queryForList(any(), eq("バグ"))).thenReturn(mapList2);
		
		setService();
	}
	
	@Test
	public void Select_byTagTest() {
		// TODO タグ名による選択テスト
		InitSelect_byTag();
		
		List<BlogMainModel> list = service.select_byTag("テスト");
		
		Assertions.assertEquals(list.size(), 1);
		Assertions.assertEquals(list.get(0).getId(), 1);
		Assertions.assertEquals(list.get(0).getTitle(), "テストタイトル");
		Assertions.assertEquals(list.get(0).getTag(), "テストタグ");
		Assertions.assertEquals(list.get(0).getComment(), "テストコメント");
		Assertions.assertEquals(list.get(0).getThanksCnt(), 1);
		Assertions.assertEquals(list.get(0).getCreated().toString(), dateTime1.toString());
		Assertions.assertEquals(list.get(0).getUpdated().toString(), dateTime2.toString());
		list.clear();
		
		list = service.select_byTag("バグ");
		Assertions.assertEquals(list.size(), 0);
	}
	
	public void InitInsert() {
		// TODO 更新テストの初期化
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.update(
				any(), 
				eq("テストタイトル"),
				eq("テストタグ"),
				eq("テストコメント"),
				eq(1),
				eq(dateTime2)
				)).thenReturn(1);
		
		setService();
	}
	
	@Test
	public void InsertTest() {
		// TODO 更新テスト
		InitInsert();
		
		BlogMainModel model = new BlogMainModel();
		service.save(model);
	}
	
	public void InitUpdate() {
		// TODO 更新テストの初期化
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.update(
				any(), 
				eq("テストタイトル"),
				eq("テストタグ"),
				eq("テストコメント"),
				eq(1),
				eq(dateTime2),
				eq(1)
				)).thenReturn(1);
		
		setService();
	}
	
	@Test
	public void UpdateTest() {
		// TODO 更新テスト
		InitUpdate();
		
		BlogMainModel model = new BlogMainModel();
		
		// 例外テスト1
		assertThrows(RuntimeException.class, () -> service.update(model));
		
		model.setId(1);
		model.setTitle("テストタイトル");
		model.setTag("テストタグ");
		model.setComment("テストコメント");
		model.setThanksCnt(1);
		model.setCreated(dateTime1);
		model.setUpdated(dateTime2);
		
		// 例外テスト2
		assertDoesNotThrow(() -> service.update(model));
	}
	
	public void InitDelete() {
		// TODO 削除テストの初期化
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.update(any(), eq(1))).thenReturn(1);
		when(jdbcTemp.update(any(), eq(2))).thenReturn(0);
		
		setService();
	}
	
	@Test
	public void DeleteTest() {
		// TODO 削除処理のテスト
		InitDelete();
		
		assertDoesNotThrow(() -> service.delete(1));
		assertThrows(RuntimeException.class, () -> service.delete(2));
	}
	
	public void InitThanksIncrement() {
		// TODO インクリメントの初期化
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("thanksCnt", 1);
		
		
		// Mock化
		jdbcTemp = mock(JdbcTemplate.class);
		when(jdbcTemp.queryForMap(any(), eq(1))).thenReturn(map);
		when(jdbcTemp.update(any(), eq(2), eq(1))).thenReturn(1);
		
		when(jdbcTemp.queryForMap(any(), eq(2))).thenReturn(null);
		
		setService();
	}
	
	@Test
	public void IncrementTest() {
		// TODO インクリメント処理のテスト
		InitThanksIncrement();
		
		int ret = service.thanksIncrement(1);
		Assertions.assertEquals(ret, 2);
		
		ret = service.thanksIncrement(2);
		Assertions.assertEquals(ret, -1);
	}
	
	public void setService() {
		// TODO サービスのインスタンス化
		BlogMainDao dao = new BlogMainDaoSql(jdbcTemp);
		service = new BlogMainServiceUse(dao);
	}
	
	@AfterEach
	public void Release() {
		service = null;
		jdbcTemp = null;
	}

}
