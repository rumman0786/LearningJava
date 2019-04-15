package module.jackson;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.parser.JSONParser;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @author rumman
 * @since 4/15/19
 */
public class JacksonJsonTester {
    public static void main(String args[]) {

        JacksonJsonTester jsonTester = new JacksonJsonTester();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try {
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);

            Student studentObj = new Student();
            studentObj.setName("Rumman");
            studentObj.setAge(28);

            String studentObjJsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentObj);
            System.out.println(studentObjJsonStr);

            Student studentObjFromJson = mapper.readValue(studentObjJsonStr, Student.class);
            System.out.println(studentObjFromJson);

            Map<String, Object> otherValues = new HashMap<>();
            otherValues.put("student", studentObj);
            otherValues.put("work", "Therap BD Ltd");
            otherValues.put("hobby", "Table Tennis");

            String jsonFromMap = mapper.writeValueAsString(otherValues);
            System.out.println(jsonFromMap);

            jsonTester.iterateJsonNode();

            jsonTester.rawJsonCreateExample();

            jsonTester.jsonParserExample();

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void iterateJsonNode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonNode rootNode = mapper.readTree(jsonString);

        JsonNode nameNode = rootNode.path("name");
        System.out.println("Name: " + nameNode.textValue());

        JsonNode ageNode = rootNode.path("age");
        System.out.println("Age: " + ageNode.intValue());

        JsonNode verifiedNode = rootNode.path("verified");
        System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes" : "No"));

        JsonNode marksNode = rootNode.path("marks");
        Iterator<JsonNode> iterator = marksNode.elements();
        System.out.print("Marks: [ ");

        while (iterator.hasNext()) {
            JsonNode marks = iterator.next();
            System.out.print(marks.intValue() + " ");
        }

        System.out.println("]");
    }

    private void rawJsonCreateExample() {
        JsonFactory jsonFactory = new JsonFactory();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        JsonGenerator jsonGenerator = null;
        try {

            jsonGenerator = jsonFactory.createGenerator(outputStream);


            jsonGenerator.writeStartObject();

            jsonGenerator.writeStringField("name", "Rasha");
            jsonGenerator.writeBooleanField("isAlive", true);
            jsonGenerator.writeNumberField("experience", 5);

            jsonGenerator.writeFieldName("salary");
            jsonGenerator.writeStartArray();
            jsonGenerator.writeNumber(3000);
            jsonGenerator.writeNumber(3500);
            jsonGenerator.writeNumber(4500);
            jsonGenerator.writeNumber(5000);
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();

            jsonGenerator.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        String jsonString = outputStream.toString();
        System.out.println(jsonString);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> stringObjectMap = objectMapper.readValue(jsonString, Map.class);
            System.out.println(stringObjectMap.get("name"));
            System.out.println(stringObjectMap.get("isAlive"));
            System.out.println(stringObjectMap.get("salary"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void jsonParserExample() {
        String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";

        JsonFactory factory = new JsonFactory();
        try {
            JsonParser parser = factory.createParser(jsonString);

            System.out.println();
            System.out.println("JSON Token Workflow");

            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                System.out.println("jsonToken = " + jsonToken);
            }


            System.out.println();
            System.out.println("JSON Parsing");

            parser = factory.createParser(jsonString);

            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                if (JsonToken.FIELD_NAME.equals(jsonToken)) {
                    String fieldKey = parser.getCurrentName();
                    System.out.println(fieldKey);

                    jsonToken = parser.nextToken();

                    if ("name".equals(fieldKey)) {
                        System.out.println(parser.getValueAsString());
                    }

                    else if ("age".equals(fieldKey)) {
                        System.out.println(parser.getValueAsInt());
                    }

                    else if ("verified".equals(fieldKey)) {
                        System.out.println(parser.getValueAsBoolean());
                    }

                    else if ("marks".equals(fieldKey)) {
                        StringJoiner joiner = new StringJoiner(", ", "[", "]");

                        while (parser.nextToken() != JsonToken.END_ARRAY) {
                            joiner.add(String.valueOf(parser.getValueAsInt()));
                        }

                        System.out.println(joiner.toString());
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
