/**
 * 
 */
package com.deere.warranty.compare;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;
import org.junit.Ignore;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;
import org.skyscreamer.jsonassert.JSONParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Nishant Sonar (qkg5rdk)
 *
 */
public class JSONAssertTest extends AbstractTest {

	private static final String EXPECTED_PAYLOAD = "expected.json";
	private static final String ACTUAL_PAYLOAD = "actual.json";

	@Test
	public void test() throws JSONException, JsonProcessingException, IOException, URISyntaxException {
		File fileExpected = getFile(EXPECTED_PAYLOAD);
		File fileActual = getFile(ACTUAL_PAYLOAD);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode expected = mapper.readTree(fileExpected);
		JsonNode actual = mapper.readTree(fileActual);
		JSONCompareMode strict = JSONCompareMode.STRICT_ORDER;
		final String expectedStr = mapper.writeValueAsString(expected);
		final String actualStr = mapper.writeValueAsString(actual);

		JSONString expectodJSONString = new JSONString() {
			public String toJSONString() {
				// TODO Auto-generated method stub
				return expectedStr;
			}
		};
		JSONString actualJSONString = new JSONString() {

			public String toJSONString() {
				// TODO Auto-generated method stub
				return actualStr;
			}
		};

		JSONCompareResult result = JSONCompare.compareJSON(expectedStr, actualStr,JSONCompareMode.STRICT_ORDER);
		System.out.println(result.getMessage());
		System.out.println(result.getFieldFailures());
		System.out.println(result.getFieldMissing());
		System.out.println(result.getFieldUnexpected());

	}

	@Test
	@Ignore
	public void testSample() throws JSONException {
		String expected = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",pets:[\"bird\",\"fish\"]}],pets:[]}";
		String actual = "{id:1,name:\"Joe\",friends:[{id:2,name:\"Pat\",pets:[\"dog\"]},{id:3,name:\"Sue\",lastname:\"Tsoe\",pets:[\"cat\",\"fish\"]}],pets:[]}";
		JSONAssert.assertEquals(expected, actual, false);
	}
}
