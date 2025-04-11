package com.example.support.micrometer;

import io.micrometer.common.docs.KeyName;
import io.micrometer.common.lang.NonNull;
import io.micrometer.observation.docs.ObservationDocumentation;

public enum CustomObservationDocumentation implements ObservationDocumentation {
    /**
     * Meter with description
     */
    ELEMENT {
        @Override
        public Class<? extends CustomObservationConvention> getDefaultConvention() {
            return DefaultObservationConvention.class;
        }

        @NonNull
        @Override
        public KeyName[] getLowCardinalityKeyNames() {
            return LowCardinalityKeyNames.values();
        }

        @NonNull
        @Override
        public KeyName[] getHighCardinalityKeyNames() {
            return HighCardinalityKeyNames.values();
        }
    };

    enum LowCardinalityKeyNames implements KeyName {
        /**
         * Classifier
         */
        CLASSIFIER {
            @NonNull
            @Override
            public String asString() {
                return "classifier";
            }
        },
    }

    enum HighCardinalityKeyNames implements KeyName {
        /**
         * Content
         */
        CONTENT {
            @NonNull
            @Override
            public String asString() {
                return "content";
            }
        },
    }


}
