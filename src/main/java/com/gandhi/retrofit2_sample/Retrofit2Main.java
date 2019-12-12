package com.gandhi.retrofit2_sample;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Retrofit2Main {

	public static void main(String[] args) throws IOException {
		
		UserService service 
		  = GitHubServiceGenerator.createService(UserService.class);
		
		//Call<User> callUser = service.getUser("mojombo");
		Call<List<User>> callListUser = service.getUsers(0, 0);
		
		boolean isSync = true; 
		if(isSync) {
			/*	synchronous	*/
			//List<User> userList = callListUser.execute().body();
			callListUser.execute().body().forEach(user -> {
				System.out.println(user);
			});
			
		} else {
			/*	asynchronous */
			callListUser.enqueue(new Callback<List<User>>() {    
	            @Override
	            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
	                if (response.isSuccessful()) {
	                	//List<User> userList = response.body();
	                	response.body().forEach(user -> {
	                		System.out.println(user);
	                	});
	                } else {
	                	System.out.println("Server response failed");
	                }
	            }
	            
				@Override
				public void onFailure(Call<List<User>> call, Throwable t) {}
			});
			
		}
		
	}

}

