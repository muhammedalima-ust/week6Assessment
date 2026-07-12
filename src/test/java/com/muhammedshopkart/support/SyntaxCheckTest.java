package com.muhammedshopkart.support;

import com.muhammedshopkart.ui.pages.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SyntaxCheckTest {
        @ParameterizedTest
        @ValueSource(classes = {
                LoginPage.class,
                Homepage.class,
                ProductPage.class,
                CartPage.class,
                OrderPage.class
        })
        void pageObjectsFollowStandards(Class<?> pageClass) {
            Report.info("Syntax Test Started for", pageClass.getSimpleName());
            List<Field> locators =
                    Arrays.stream(pageClass.getDeclaredFields())
                            .filter(f -> f.getType().equals(By.class))
                            .toList();
            assertTrue(
                    locators.stream()
                            .allMatch(f -> Modifier.isPrivate(f.getModifiers()))
            );
            Report.pass("Test Passed");
        }
}

