package com.solvd.other.enums.computer;

public enum MainCharacteristics {
    CPU(1600d) {
        public String getValue() {
            return "Cpu";
        }
    },
    MEMORY(2500d) {
        public String getValue() {
            return "Memory";
        }
    },
    GRAPHIC_CARD(3800d) {
        public String getValue() {
            return "GRAPHIC_CARD";
        }
    },
    AUDIO_CARD(420d) {
        public String getValue() {
            return "AUDIO_CARD";
        }
    };
    private final double frequency;
    private String value;

    MainCharacteristics(double freq) {
        this.frequency = freq;
    }

    public String getFrequency() {
        return String.valueOf(frequency);
    }

    public String getValue() {
        return value;
    }

}