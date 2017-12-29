package idv.mission.example.SpringDAO_Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PersonDaoImpl extends JdbcDaoSupport implements IPersonDao {

    public void addPerson(Person person) {
        String sql = "insert into person(name, english_name, age, sex, birthday, description, create_time) value (?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] { person.getName(), person.getEnglishName(), person.getAge(), person.getSex(), person.getBirthday(), person.getDescription(), new Date() });
    }

    public List<Person> listPersons() {
        String sql = "SELECT * FROM person";
        List<Map<String, Object>> list = getJdbcTemplate().queryForList(sql);
        List<Person> personList = new ArrayList<Person>();
        for (Map<String, Object> row : list) {
            Integer id = (Integer) row.get("id");
            String name = (String) row.get("name");
            String englishName = (String) row.get("english_name");
            Integer age = ((Long) row.get("age")).intValue();
            String sex = (String) row.get("sex");
            String description = (String) row.get("description");
            Date birthday = (Date) row.get("birthday");

            Person person = new Person();
            person.setId(id);
            person.setName(name);
            person.setEnglishName(englishName);
            person.setAge(age);
            person.setSex(sex);
            person.setBirthday(birthday);
            person.setDescription(description);
            personList.add(person);
        }
        return personList;
    }

}
