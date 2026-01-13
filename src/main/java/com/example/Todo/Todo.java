package com.example.Todo;

public class Todo{
	private boolean completed;
	private int id;
	private String title;
	private int userId;

    public Todo() {}

    Todo(boolean completed,int id,String title,int userId){
        this.completed=completed;
        this.id=id;
        this.title=title;
        this.userId=userId;
    }

	public boolean isCompleted(){
		return completed;
	}

	public int getId(){
		return id;
	}

	public String getTitle(){
		return title;
	}

	public int getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"Todo{" + 
			"completed = '" + completed + '\'' + 
			",id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}
