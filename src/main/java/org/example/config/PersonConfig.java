package org.example.config;

import org.example.condition.BadGuyCondition;
import org.example.condition.PersonCondition;
import org.example.model.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author xunlailiu
 * @date 2020/05/20
 */
@Configuration
@Conditional({PersonCondition.class})
public class PersonConfig {

    @Bean
    public Person getLi(){
        System.out.println("注入LI=============================");
        return new Person("li", 12);
    }

    @Bean
    @Conditional({BadGuyCondition.class})
    public Person getWang(){
        System.out.println("注入WANG==================================");
        return new Person("WANG", 13);
    }

}
