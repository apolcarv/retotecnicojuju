package co.com.juju.project.helpers;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static co.com.juju.project.helpers.Constant.ONE;
import static co.com.juju.project.helpers.Constant.TWO;

public class DataFaker {
    private DataFaker() {
    }

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    public static String fakerNumberOneAndTwo() {
        return String.valueOf(faker.number().numberBetween(ONE, TWO));
    }
}