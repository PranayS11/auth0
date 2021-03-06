package com.auth0.jobportal.repository;

import com.auth0.jobportal.constants.ApplicationConstants;
import com.auth0.jobportal.entity.JobPostProfileEntity;
import com.auth0.jobportal.repository.jpa.JpaJobPostProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JobPostProfileRepository {

    static int jobsPerPage= ApplicationConstants.JOBS_PER_PAGE;


    private  final JpaJobPostProfileRepository jpaJobPostProfileRepository;

    public Optional<JobPostProfileEntity> findById(UUID id){
        return jpaJobPostProfileRepository.findById(id);
    }

    public Page<JobPostProfileEntity> findByIdIn(List<UUID> ids,int pageNo){
        return jpaJobPostProfileRepository.findByIdIn(ids, PageRequest.of(pageNo,jobsPerPage, Sort.Direction.DESC,"updated_at"));
    }

    public Page<JobPostProfileEntity> findByUserIdWithPage(UUID userId,int pageNo){
        return jpaJobPostProfileRepository.findByUserId(userId, PageRequest.of(pageNo,jobsPerPage, Sort.Direction.DESC,"updated_at"));
    }

//    public Page<JobPostProfileEntity> findByBetweenLocationUUID userId,int radius){
//        return jpaJobPostProfileRepository.findByUserId(userId, PageRequest.of(pageNo,jobsPerPage, Sort.Direction.DESC,"updated_at"));
//    }





    public JobPostProfileEntity saveJob(JobPostProfileEntity jobPostProfileEntity){
        return jpaJobPostProfileRepository.save(jobPostProfileEntity);
    }

    public void deleteByJobiId(UUID jobId){
         jpaJobPostProfileRepository.deleteById(jobId);
    }




}
