package com.epam.pojos;

public record CommentRecord(String postId, String id, String name, String email, String body) {
	
	public CommentRecord{
		if(body!=null)
			body = body.replace("\n", "\\n");
	}
	
}