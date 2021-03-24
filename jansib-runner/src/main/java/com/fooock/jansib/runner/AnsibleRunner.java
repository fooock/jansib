package com.fooock.jansib.runner;

import java.io.*;
import java.util.Collections;
import java.util.Map;

/**
 *
 */
public class AnsibleRunner {
    private final RunnerConfiguration configuration;

    public AnsibleRunner(RunnerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void start(RunnerEventListener eventListener) {
        // set process working directory. If the directory does not exists then
        // this method will throw an exception
        String workingDir = configuration.getWorkingDir();
        File wd = new File(workingDir);
        if (!wd.exists()) {
            FileNotFoundException exception = new FileNotFoundException("File " + workingDir + " not found");
            eventListener.onError(exception);
            return;
        }
        // build the process that will execute our playbook
        String playbook = configuration.getPlaybook();
        String playbookPath = String.format("%s/%s", wd.getAbsolutePath(), playbook);
        String privateDatePath = String.format("/tmp/%s", workingDir);
        String inventory = configuration.getInventory();

        ProcessBuilder builder = new ProcessBuilder()
            .redirectErrorStream(true)
            .directory(wd)
            .command("ansible-runner", "--json", "-p", playbookPath, "--inventory", inventory, "run", privateDatePath);
        // update process environment variables
        Map<String, String> environment = builder.environment();
        environment.put("ANSIBLE_NOCOLOR", "True");

        // start the process and wait until finish
        try {
            Process process = builder.start();
            long pid = process.pid();
            eventListener.onInitialize(pid, Collections.unmodifiableList(builder.command()));

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            reader.lines().forEach(eventListener::onEventData);

            process.waitFor();
            process.destroy();
            eventListener.onCompleted(pid);

        } catch (InterruptedException | IOException e) {
            eventListener.onError(e);
        }
    }
}
