package idv.mission.example.SpringDAO_Example;

import java.util.List;

public interface IPersonDao {
    // public String getPersonName(Integer id);
    //
    public void addPerson(Person person);
    //
    // public int getPersonCount();

    public List<Person> listPersons();
}
