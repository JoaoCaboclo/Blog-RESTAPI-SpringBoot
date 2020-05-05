package com.joaocaboclosf.blog;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.joaocaboclosf.blog.model.Post;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BlogDemoRestapiApplicationTests {

	private static final String ROOT_URL = "http://localhost:8080";
	RestTemplate restTemplate = new RestTemplate();
	
	@Test
	public void testGetAllPosts() {
		ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity(ROOT_URL+"/posts", Post[].class);
		List<Object> posts = Arrays.asList(responseEntity.getBody());
		AssertNotNull(posts);
	}
	
	private void AssertNotNull(List<Object> posts) {
		// TODO Auto-generated method stub
		
	}

	@Test
	void contextLoads() {
	}

}
