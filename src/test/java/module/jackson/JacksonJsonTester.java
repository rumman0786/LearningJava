package module.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rumman
 * @since 4/15/19
 */
public class JacksonJsonTester {
    public static void main(String args[]){

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
        }
        catch (JsonParseException e) { e.printStackTrace();}
        catch (JsonMappingException e) { e.printStackTrace(); }
        catch (IOException e) { e.printStackTrace(); }
    }
}
