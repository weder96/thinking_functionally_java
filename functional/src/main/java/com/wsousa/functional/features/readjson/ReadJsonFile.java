package com.wsousa.functional.features.readjson;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class ReadJsonFile {

	public static void main(String[] args) {
		ReadJsonFile rj = new ReadJsonFile();
		Map<Integer,Employee> data = rj.readData();
		displayData.accept(data);
	}
	
	Function<String,File> fileReader =(final String fname) -> {
		try {
			File file = new ClassPathResource(fname).getFile();
			return file;
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	};
	static Consumer<Map<Integer,Employee>> displayData = emp -> {
		emp.forEach((k,v) -> log.info(k +" Employee :"+v));
	};
	
	Function<JSONObject, Integer> idData = id -> Integer.parseInt((String)((JSONObject) id).get("id"));
	
	Function<JSONObject, Employee> fetchEmployee = json -> {
		Employee emp = new Employee();
		Integer id = Integer.parseInt((String)json.get("id"));
		emp.setId(id);
		emp.setFirstName((String)json.get("firstName"));
		emp.setLastName((String)json.get("lastName"));
		emp.setWebsite((String)json.get("website"));
		emp.setCity((String)json.get("city"));
		return emp;
	};
	
	Map<Integer,Employee> readData() {
		File file = fileReader.apply("employees.json");
		JSONParser parser = new JSONParser();
		Map<Integer,Employee> employee = null ;
		try(Reader reader = new FileReader(file)){
			JSONArray jArray = (JSONArray)parser.parse(reader);
			employee = (Map<Integer, Employee>) jArray.stream().collect(Collectors.toMap(idData, fetchEmployee));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return employee;		
	}

}
