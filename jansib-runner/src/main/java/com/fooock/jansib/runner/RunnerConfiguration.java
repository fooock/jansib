package com.fooock.jansib.runner;

/**
 *
 */
public class RunnerConfiguration {
    private final String workingDir;
    private final String playbook;
    private final String inventory;

    public RunnerConfiguration(String workingDir, String playbook, String inventory) {
        this.workingDir = workingDir;
        this.playbook = playbook;
        this.inventory = inventory;
    }

    public String getWorkingDir() {
        return workingDir;
    }

    public String getPlaybook() {
        return playbook;
    }

    public String getInventory() {
        return inventory;
    }
}
