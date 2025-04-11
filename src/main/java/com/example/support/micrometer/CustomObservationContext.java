package com.example.support.micrometer;

import io.micrometer.observation.Observation;

public class CustomObservationContext extends Observation.Context {

    private final String classifier;
    private final String content;

    public CustomObservationContext(String classifier, String content) {
        this.classifier = classifier;
        this.content = content;
    }

    public String getClassifier() {
        return classifier;
    }

    public String getContent() {
        return content;
    }
}
