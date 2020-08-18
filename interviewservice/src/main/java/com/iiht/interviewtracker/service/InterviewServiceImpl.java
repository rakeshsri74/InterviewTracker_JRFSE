package com.iiht.interviewtracker.service;

import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterview;
import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterviewDto;
import static com.iiht.interviewtracker.utils.InterviewUtilities.convertToInterviewDtoList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.interviewtracker.dto.InterviewDTO;
import com.iiht.interviewtracker.model.Interview;
import com.iiht.interviewtracker.repository.InterviewRepository;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
    private InterviewRepository interviewRepository;
	
	@Override
	public InterviewDTO saveInterview(InterviewDTO interviewDTO) {
		Interview interview = interviewRepository.save(convertToInterview(interviewDTO));
		return convertToInterviewDto(interview);
	}

	@Override
	public List<InterviewDTO> findAll() {
		List<Interview> list = interviewRepository.findAll();
		return convertToInterviewDtoList(list);
	}

	@Override
	public InterviewDTO updateInterview(InterviewDTO interviewDTO) {
		Interview interview = interviewRepository.save(convertToInterview(interviewDTO));
		return convertToInterviewDto(interview);
	}

	@Override
	public InterviewDTO delete(InterviewDTO interviewdto) {
		interviewRepository.delete(convertToInterview(interviewdto));
		return interviewdto;
	}

	@Override
	public InterviewDTO findInterviewByName(String interviewName) {
		List<Interview> list = interviewRepository.findAll();
		List<InterviewDTO> dtolist = convertToInterviewDtoList(list);
		InterviewDTO temp=null;
		for(InterviewDTO dtointerview:dtolist) {
			if(dtointerview.getInterviewName()==interviewName){
				temp=dtointerview;
				break;
			}
		}
		return  temp;
	}

	@Override
	public InterviewDTO findByInterviewerName(String interviewerName) {
		List<Interview> list = interviewRepository.findAll();
		List<InterviewDTO> dtolist = convertToInterviewDtoList(list);
		InterviewDTO temp=null;
		for(InterviewDTO dtointerview:dtolist) {
			if(dtointerview.getInterviewerName()==interviewerName){
				temp=dtointerview;
				break;
			}
		}
		return  temp;
	}

	@Override
	public int countInterviews() {
		List<Interview> list = interviewRepository.findAll();
		int count = 0;
		for(Interview interview : list)
		{
			count++;
		}
		return count;
	}

}
