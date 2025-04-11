package com.example.support.micrometer;

import io.micrometer.common.lang.NonNull;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationConvention;

public interface CustomObservationConvention extends ObservationConvention<CustomObservationContext> {
    @Override
    default boolean supportsContext(@NonNull Observation.Context context) {
        return context instanceof CustomObservationContext;
    }
}
