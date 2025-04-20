package com.example;

import com.github.jknack.handlebars.Handlebars;
import io.micrometer.docs.DocsGeneratorCommand;
import io.micrometer.docs.commons.templates.HandlebarsUtils;

import java.time.Duration;

public class CustomDocsGeneratorCommand extends Thread {
    public static void main(String[] args) {

//        Handlebars handlebars = HandlebarsUtils.createHandlebars();
//        handlebars.registerHelpers(CustomHelpers.class);
//        CustomDocsGeneratorCommand thread = new CustomDocsGeneratorCommand();
//
//        thread.start();
//
////        DocsGeneratorCommand.main(args);
//        synchronized (thread) {
//            CustomDocsGeneratorCommand.runDocsGenerator(args);
//        }
        HandlebarsUtils.createHandlebars();
        DocsGeneratorCommand.main(args);

    }

    public static synchronized void runDocsGenerator(String[] args) {
        DocsGeneratorCommand.main(args);
    }


    @Override
    public void run() {
        try {
            Thread.sleep(Duration.ofMillis(1200));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Handlebars handlebars = HandlebarsUtils.createHandlebars();
        handlebars.registerHelpers(SecondCustomHelpers.class);
    }
}