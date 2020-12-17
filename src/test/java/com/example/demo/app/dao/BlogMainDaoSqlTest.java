package com.example.demo.app.dao;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.app.entity.BlogMainModel;

class BlogMainDaoSqlTest {
	
	@Mock
	JdbcTemplate jdbcTemp;
	
	@Test
	public void SelectAllTest() {
		// TODO 全選択テスト
		LocalDateTime dateTime1 = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		LocalDateTime dateTime2 = LocalDateTime.of(2000, 01, 02, 00, 00, 00);
		
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
		
		BlogMainDao dao = new BlogMainDaoSql(jdbcTemp);
		List<BlogMainModel> list = dao.getAll();
		
		Assertions.assertEquals(list.size(), 1);
		Assertions.assertEquals(list.get(0).getId(), 1);
		Assertions.assertEquals(list.get(0).getTitle(), "テストタイトル");
		Assertions.assertEquals(list.get(0).getTag(), "テストタグ");
		Assertions.assertEquals(list.get(0).getComment(), "テストコメント");
		Assertions.assertEquals(list.get(0).getThanksCnt(), 1);
		Assertions.assertEquals(list.get(0).getCreated().toString(), dateTime1.toString());
		Assertions.assertEquals(list.get(0).getUpdated().toString(), dateTime2.toString());
		
	}

}
