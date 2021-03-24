package com.fooock.jansib.runnerexample;

import com.fooock.jansib.runner.AnsibleRunner;
import com.fooock.jansib.runner.RunnerConfiguration;
import com.fooock.jansib.runner.RunnerEventListener;

import java.util.List;

/**
 *
 */
public class Application implements RunnerEventListener {

    public void run(RunnerConfiguration configuration) {
        AnsibleRunner runner = new AnsibleRunner(configuration);
        runner.start(this);
    }

    public static void main(String[] args) {
        RunnerConfiguration configuration = new RunnerConfiguration("jansib-ansible-test", "playbook.yml", "localhost,");
        Application application = new Application();
        application.run(configuration);
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
