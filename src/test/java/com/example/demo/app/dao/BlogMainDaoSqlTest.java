package com.example.demo.app.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.app.entity.BlogMainModel;

public class BlogMainDaoSqlTest {
	
	private BlogMainDao dao;
	
	@Mock
	JdbcTemplate jdbcTemp;
	
	@Before
	public void Setup() {
		// TODO セットアップ
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
		
		dao = new BlogMainDaoSql(jdbcTemp);
	}

	@Test
	public void SelectAllTest() {
		// TODO 全選択テスト
		LocalDateTime dateTime1 = LocalDateTime.of(2000, 01, 01, 00, 00, 00);
		LocalDateTime dateTime2 = LocalDateTime.of(2000, 01, 02, 00, 00, 00);
		
		List<BlogMainModel> list = dao.getAll();
		
		assertThat(list.size(), is(1));
		assertThat(list.get(0).getId(), is(1));
		assertThat(list.get(0).getTitle(), is("テストタイトル"));
		assertThat(list.get(0).getTag(), is("テストタグ"));
		assertThat(list.get(0).getComment(), is("テストコメント"));
		assertThat(list.get(0).getThanksCnt(), is(1));
		assertThat(list.get(0).getCreated().toString(), is(dateTime1.toString()));
		assertThat(list.get(0).getUpdated().toString(), is(dateTime2.toString()));
		
	}
	
	@After
	public void Release() {
		
	}

}
