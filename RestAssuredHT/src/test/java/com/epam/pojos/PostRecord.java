package com.epam.pojos;

public record PostRecord(String userId,String id,String title,String body) {

	public PostRecord{
		if(body!=null)
			body = body.replace("\n", "\\n");
	}
}