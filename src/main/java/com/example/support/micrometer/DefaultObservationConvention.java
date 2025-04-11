package com.example.support.micrometer;

import io.micrometer.common.KeyValues;
import io.micrometer.common.lang.NonNull;
import io.micrometer.common.lang.Nullable;

public class DefaultObservationConvention implements CustomObservationConvention {

    @Nullable
    @Override
    public String getName() {
        return "com.example.observation";
    }

    @Override
    public String getContextualName(@NonNull CustomObservationContext context) {
        return "generate_some";
    }

    @NonNull
    @Override
    public KeyValues getLowCardinalityKeyValues(CustomObservationContext context) {
        return KeyValues.of(CustomObservationDocumentation.LowCardinalityKeyNames.CLASSIFIER
                .withValue(context.getClassifier()));
    }

    @NonNull
    @Override
    public KeyValues getHighCardinalityKeyValues(CustomObservationContext context) {
        return KeyValues.of(CustomObservationDocumentation.HighCardinalityKeyNames.CONTENT
                .withValue(context.getContent()));
    }
}
