package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData

{
    private final Faker faker = new Faker(new Locale("ru"));
    private final Faker fakerEU = new Faker(new Locale("eu-US"));
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName();

}
//"15", "May","1996"