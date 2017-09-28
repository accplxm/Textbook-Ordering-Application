package com.example.springStarter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springStarter.model.Task;
import com.example.springStarter.service.TaskService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired 
	private TaskService taskService;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public Map<String,String> get(){
		System.out.println( "wewedssssssssssssssssssssssssssssssss");
		Map<String,String> map =new HashMap<String, String>();
		map.put("name","Srinivas");
		return map;
	}
	
	@GetMapping("/all-tasks")
	public String allTasks(){
		return taskService.findAll().toString();
	}
	
	@GetMapping("/save-task")
	public String saveTask(@RequestParam String name,@RequestParam String desc){
		Task task = new Task(name,desc,new Date(),false);
		taskService.save(task);
		return "Task Saved!!!";
	}
	
	@GetMapping("/delete-task")
	public String saveTask(@RequestParam int id){
		taskService.delete(id);
		return "Task Deleted!!!";
	}
	
	
}
