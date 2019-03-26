package com.beans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.stereotype.Component;


@Data
@Component
@NoArgsConstructor
@ToString(of={"name","age"})
public class Person {
    private String name;
    private int age;
}
