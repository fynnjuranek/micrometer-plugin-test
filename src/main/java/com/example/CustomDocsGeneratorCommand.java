package com.example;

import com.github.jknack.handlebars.Handlebars;
import io.micrometer.docs.DocsGeneratorCommand;
import io.micrometer.docs.commons.templates.HandlebarsUtils;

public class CustomDocsGeneratorCommand {
    public static void main(String[] args) {

        Handlebars handlebars = HandlebarsUtils.createHandlebars();
        handlebars.registerHelpers(CustomHelpers.class);

        DocsGeneratorCommand.main(args);
    }
}