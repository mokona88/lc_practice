package com.solution.config;

public class RunnerConfig {
    private static RunnerConfig configInstance;
    public char[][] getInput_36() {
        return new char[][]{
            {'.', '.', '.', '.', '.', '.', '5', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'9', '3', '.', '.', '2', '.', '4', '.', '.'},
            {'.', '.', '7', '.', '.', '.', '3', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '3', '4', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '3', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '5', '2', '.', '.'}
        };
    }

    public static RunnerConfig getInstance() {
        if (configInstance == null) {
            configInstance = new RunnerConfig();
        }
        return configInstance;
    }
}
