package com.example.demo.json;

import java.nio.file.Path;

import com.example.demo.app.intro.IntroJSONModel;

public interface IntroJsonReader {
	
	public IntroJSONModel reader(Path path);

}
