package com.fooock.jansib.api.project;

import com.fooock.jansib.api.project.dto.*;
import com.fooock.jansib.api.project.model.Job;
import com.fooock.jansib.api.project.model.Project;
import com.fooock.jansib.api.project.service.JobService;
import com.fooock.jansib.api.project.service.ProjectService;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Path("project")
public class ProjectResource {
    @Inject
    ProjectService projectService;

    @Inject
    JobService jobService;

    @POST
    public ProjectView create(@Valid CreateProjectRequest request) {
        return projectService.create(request).transform(this::toProjectView);
    }

    private ProjectView toProjectView(Project data) {
        ProjectView view = new ProjectView();
        view.setId(data.getId());
        view.setName(data.getName());
        view.setDescription(data.getDescription());
        view.setCreated(data.getCreated().toEpochMilli());
        if (data.getJobs() != null)
            view.setNumJobs(data.getJobs().size());
        return view;
    }

    @GET
    public List<ProjectView> list() {
        return projectService.list()
            .stream()
            .map(this::toProjectView)
            .collect(Collectors.toList());
    }

    @GET
    @Path("{id}")
    public ProjectDetailView getById(@PathParam("id") String id) {
        return projectService.getById(id).transform(data -> {
            ProjectDetailView detailView = new ProjectDetailView();
            detailView.setId(data.getId());
            detailView.setName(data.getName());
            detailView.setDescription(data.getDescription());
            detailView.setCreated(data.getCreated().toEpochMilli());

            if (data.getJobs() == null)
                return detailView;

            List<JobView> jobViews = new ArrayList<>(data.getJobs().size());
            for (Job job : data.getJobs()) {
                JobView view = toJobView(job);
                jobViews.add(view);
            }
            detailView.setJobs(jobViews);
            return detailView;
        });
    }

    @POST
    @Path("{projectId}/job")
    public JobView createJob(@PathParam("projectId") String projectId, CreateJobRequest request) {
        request.setProjectId(projectId);
        return jobService.create(request).transform(this::toJobView);
    }

    private JobView toJobView(Job job) {
        JobView view = new JobView();
        view.setId(job.getId());
        view.setName(job.getName());
        view.setCreated(job.getCreated().toEpochMilli());
        view.setType(job.getType());
        view.setState(job.getState().getName());
        return view;
    }

    @GET
    @Path("{projectId}/job/{jobId}")
    public JobViewDetail getJobById(@PathParam("projectId") String projectId, @PathParam("jobId") String jobId) {
        return jobService.getById(projectId, jobId).transform(job -> {
            JobViewDetail viewDetail = new JobViewDetail();
            viewDetail.setId(job.getId());
            viewDetail.setName(job.getName());
            viewDetail.setType(job.getType());
            viewDetail.setCreated(job.getCreated().toEpochMilli());
            viewDetail.setState(job.getState().getName());
            return viewDetail;
        });
    }
}
