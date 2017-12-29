package idv.mission.example.SpringDAO_Example;

import java.util.Calendar;
import java.util.Date;

public class TransactionTask {
    private IPersonDao personDao;

    public IPersonDao getPersonDao() {
        return personDao;
    }

    public void setPersonDao(IPersonDao personDao) {
        this.personDao = personDao;
    }

    public void run() {
        Person person = new Person();
        person.setName("回溯測試");
        person.setEnglishName("Test");
        person.setAge(20);
        person.setSex("男");
        Calendar calendar = Calendar.getInstance();
        calendar.set(1984, 1, 14); // month index by 0
        Date birthday = calendar.getTime();
        person.setBirthday(birthday);
        person.setDescription("Rollback Test");

        personDao.addPerson(person);

        personDao.addPerson(null);
    }
}
