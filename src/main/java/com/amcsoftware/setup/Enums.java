package com.amcsoftware.setup;

public class Enums {
    public Enums() {
    }

    public static enum Priority {
        MOST_URGENT,
        URGENT,
        HIGH,
        LOW,
        NOT_DETERMINED;

        Priority() {
        }
    }

    public static enum Severity {
        CRITICAL,
        HIGH,
        MEDIUM,
        LOW;

        Severity() {
        }
    }

    public static enum  TestOutcome {
        PASSED,
        FAILED,
        INCONCLUSIVE,
        TIMEOUT,
        ABORT;

        TestOutcome() {
        }
    }

    public static enum Browser {
        Chrome,
        Edge,
        Firefox,
        IE,
        Safari;

        Browser() {
        }
    }

    public static enum LoggingLevel {
        DEBUG(0),
        INFO(1),
        WARN(2),
        ERROR(3),
        FATAL(4),
        FORMATTING(5);

        private int value;

        LoggingLevel(int value) {
            this.value = value;
        }

        public int getLoggingLevel() {
            return value;
        }
    }

}
