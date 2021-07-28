package com.delonborges.common;

public class Properties {

    public static Browsers browser = Browsers.FIREFOX;
    public static Executions execution = Executions.LOCAL;

    public enum Browsers {
        CHROME,
        FIREFOX
    }

    public enum Executions {
        LOCAL,
        GRID
    }
}
