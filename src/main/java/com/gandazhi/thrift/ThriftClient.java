package com.gandazhi.thrift;

import com.gandazhi.thrift.generated.Person;
import com.gandazhi.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFastFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

/**
 * @Auther: gandazhi
 * @Date: 2018-12-15 15:17
 */
public class ThriftClient {

    public static void main(String[] args) {
        TTransport transport = new TFastFramedTransport(new TSocket("localhost", 8002), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();

            Person person = client.getPersonByUsername("gandazhi");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("------------------");

            Person person1 = new Person();
            person1.setUsername("gandazhi23");
            person1.setAge(22);
            person1.setMarried(false);

            client.SavePerson(person1);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage(), e);
        }finally {
            transport.close();
        }
    }
}
