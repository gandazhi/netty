package com.gandazhi.thrift;

import com.gandazhi.thrift.generated.DataException;
import com.gandazhi.thrift.generated.Person;
import com.gandazhi.thrift.generated.PersonService;
import org.apache.thrift.TException;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-15 15:05
 */
public class PersonServiceImpl implements PersonService.Iface {

    @Override
    public Person getPersonByUsername(String username) throws DataException, TException {
        System.out.println("Got Client Param:" + username);

        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void SavePerson(Person person) throws DataException, TException {
        System.out.println("Got Client Param");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());

    }
}
