package com.example.support.micrometer;

import io.micrometer.core.instrument.Meter;

public enum TestExtendMeter implements ExtendMeterDocumentation {
    FOO {
        @Override
        public void test() {

        }

        @Override
        public String getName() {
            return "";
        }

        @Override
        public Meter.Type getType() {
            return Meter.Type.COUNTER;
        }
    }
}

