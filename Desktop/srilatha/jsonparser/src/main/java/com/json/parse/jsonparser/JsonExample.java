/**
 * 
 */
package com.json.parse.jsonparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author srilu
 *
 */
public class JsonExample {
	private static final String filePath = "C:\\Users\\srila\\Desktop\\srilatha\\jsonparser\\src\\main\\java\\com\\json\\parse\\jsonparser\\Employee.json";
	Logger logger = LoggerFactory.getLogger(JsonExample.class);

	// convert JSON to Java object using JSONParser
	public void toJavaObject() {
		try {

			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			String name = (String) jsonObject.get("name");
			logger.info("Employee details.....");
			logger.info("Name:" + name);
			Long id = (Long) jsonObject.get("id");
			logger.info("id:" + id);
			JSONObject address = (JSONObject) jsonObject.get("address");
			logger.info("Address:" + address);

		} catch (FileNotFoundException e) {
			logger.info("File not found:" + e.getMessage());
		} catch (IOException ex) {
			logger.info(ex.getMessage());
		} catch (ParseException pe) {
			logger.info(pe.getMessage());
		}
	}

	// Convert JSON to JAVA Object using JACKSON
	public void toJava() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			FileReader file = new FileReader(
					"C:\\Users\\srila\\Desktop\\srilatha\\jsonparser\\src\\main\\java\\com\\json\\parse\\jsonparser\\Employee.json");
			Employee employee = mapper.readValue(file, Employee.class);
			logger.info(employee.toString());
			logger.info(employee.getAddress().toString());
		} catch (JsonParseException jpe) {

			logger.info(jpe.getMessage());
		} catch (JsonMappingException jme) {

			logger.info(jme.getMessage());
		} catch (IOException e) {

			logger.info(e.getMessage());
		}

	}
}
