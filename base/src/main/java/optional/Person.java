package optional;

import lombok.Data;

import java.util.Optional;

/**
 * @author chase
 * @date 2022/11/3 9:20 AM
 */
@Data
public class Person {
    private String name;
    private Integer age;

    public static void main(String[] args) {
        Person person=new Person();
        person.setAge(2);

        /**
         * optional的filter如果为true则返回optional对象本身，否则返回EMPTY
         */
        Optional.ofNullable(person).filter(p -> p.getAge() > 50).ifPresent( p -> System.out.println(p.age));
        Optional.ofNullable(person).filter(p -> p.getAge() > 1).ifPresent( p -> System.out.println(p.age));

        Optional<Person> optionalPerson =  Optional.ofNullable(null) ;
        String s = optionalPerson.map(Person::getName).orElse("kong");
        System.out.println(s);

        person.setName("zhangSan");
        optionalPerson =  Optional.ofNullable(person) ;
        s = optionalPerson.map(Person::getName).orElse("kong");
        System.out.println(s);

    }
}
