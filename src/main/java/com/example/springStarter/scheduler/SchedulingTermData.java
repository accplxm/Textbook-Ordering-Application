package com.example.springStarter.scheduler;

import java.time.Year;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.springStarter.model.Term;
import com.example.springStarter.model.Term.semester;
import com.example.springStarter.service.TermService;

@Component
public class SchedulingTermData {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
    private TermService termService;


	@Scheduled(cron = "${com.example.springStarter.textbookOrdering.termInsertion.cronTime}")
	public void termCronJob(){
	logger.info("entered the cron job for term table insertion");
	Term term =new Term();
	term.setYear(Year.now().getValue());
	term.setSemester(semester.Fall.toString());
	logger.info("semester data going"+ semester.Fall.toString());
	termService.save(term);
	term =new Term();
	term.setYear(Year.now().getValue());
	term.setSemester(semester.Session.toString());
	termService.save(term);
	term =new Term();
	term.setYear(Year.now().getValue());
	term.setSemester(semester.Spring.toString());
	termService.save(term);
	term =new Term();
	term.setYear(Year.now().getValue());
	term.setSemester(semester.Summer.toString());
	termService.save(term);
	term =new Term();
	term.setYear(Year.now().getValue());
	term.setSemester(semester.Winter.toString());
	termService.save(term);
	logger.info("Finished the cron job of inserting into term table");

	}



}

