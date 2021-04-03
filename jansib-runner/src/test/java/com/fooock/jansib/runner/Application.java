package com.fooock.jansib.runner;

import java.util.List;

/**
 *
 */
public class Application implements RunnerEventListener {
    public static void main(String[] args) {
        RunnerConfiguration configuration = new RunnerConfiguration("jansib-runner/src/test/resources", "playbook.yml", "localhost,");
        Application application = new Application();
        application.run(configuration);
    }

    public void run(RunnerConfiguration configuration) {
        AnsibleRunner runner = new AnsibleRunner(configuration);
        runner.start(this);
    }

    @Override
    public void onInitialize(long pid, List<String> command) {
        System.out.println(String.join(" ", command));
        System.out.println("Initialize runner with PID: " + pid);
    }

    @Override
    public void onEventData(String event) {
        System.out.println(event);
    }

    @Override
    public void onError(Exception exception) {
        System.out.println("An error occurs: " + exception);
    }

    @Override
    public void onCompleted(long pid) {
        System.out.println("Completed runner with PID: " + pid);
    }
}
