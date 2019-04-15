package module.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author rumman
 * @since 4/15/19
 */
public class JacksonJsonTester {
    public static void main(String args[]){

        JacksonJsonTester jsonTester = new JacksonJsonTester();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

        //map json to student
        try{
            Student student = mapper.readValue(jsonString, Student.class);

            System.out.println(student);

            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);

            System.out.println(jsonString);

            Student studentObj = new Student();
            studentObj.setName("Rumman");
            studentObj.setAge(28);

            String studentObjJsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentObj);
            System.out.println(studentObjJsonStr);

            Student studentObjFromJson= mapper.readValue(studentObjJsonStr, Student.class);
            System.out.println(studentObjFromJson);

            Map<String, Object> otherValues = new HashMap<>();
            otherValues.put("student", studentObj);
            otherValues.put("work", "Therap BD Ltd");
            otherValues.put("hobby", "Table Tennis");

            String jsonFromMap = mapper.writeValueAsString(otherValues);
            System.out.println(jsonFromMap);

            jsonTester.iterateJsonNode();
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }

    private void iterateJsonNode() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = "{\"name\":\"Mahesh Kumar\",  \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonNode rootNode = mapper.readTree(jsonString);

        JsonNode nameNode = rootNode.path("name");
        System.out.println("Name: "+ nameNode.textValue());

        JsonNode ageNode = rootNode.path("age");
        System.out.println("Age: " + ageNode.intValue());

        JsonNode verifiedNode = rootNode.path("verified");
        System.out.println("Verified: " + (verifiedNode.booleanValue() ? "Yes":"No"));

        JsonNode marksNode = rootNode.path("marks");
        Iterator<JsonNode> iterator = marksNode.elements();
        System.out.print("Marks: [ ");

        while (iterator.hasNext()) {
            JsonNode marks = iterator.next();
            System.out.print(marks.intValue() + " ");
        }

        System.out.println("]");
    }
}
