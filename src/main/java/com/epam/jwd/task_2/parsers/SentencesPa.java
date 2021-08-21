package com.epam.jwd.task_2.parsers;

import com.epam.jwd.task_2.exceptions.WrongFileName;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class SentencesPa{

    private static final String SENTENCE_PARSER = "\\n*\\s*([^!.?]+?([!.?]))\\n*";  //\n*\s*([^!.?]+?([!.?]))\n* TODO new
    //private static final String REVERSE_PARSER = "(\\n*)(.+)\\s(.+)[!.?]";    //

    /*public static String getReverseParser() {        //(\n*)(.+\s.+[!.?])
        returREVERSE_PARn SER;
    }*/


    public static String getSentenceParser() {
        return SENTENCE_PARSER;
    }

    /*@Override
    public String readFile(String path, Charset encoding) throws IOException {
        return super.readFile(path, encoding);
    }

    @Override
    public void parseIt(String path, String generalParser, int groupOfParser) throws WrongFileName, IOException {
        super.parseIt(path, SENTENCE_PARSER, 0);
    }


    @Override
    public void recoverText(String path, String parser, int groupOfParser) throws IOException {
        super.recoverText(path, SENTENCE_PARSER, 1);
    }*/







}
