package com.test;

import com.utilAndData.ConfigReader;

public class BaseTest {

    protected String baseURL = ConfigReader.getProperty("url");

    protected static String token = "";

}