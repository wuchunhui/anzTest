package com.anz.controllerTest;

import net.bytebuddy.matcher.EqualityMatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:applicationContext.xml",
		"classpath:spring-mvc.xml" })
public class DepartmentControllerTest {
	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void searcheDepartment() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.get("/v1/department/1")
							.characterEncoding("UTF-8")
							.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andExpect(
							MockMvcResultMatchers.jsonPath("$.code").value(200))
					.andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void addDepartment() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.post("/v1/department")
							.characterEncoding("UTF-8")
							.accept(MediaType.APPLICATION_JSON)
							.param("name", "testname")
							.param("openPositions", "1"))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andExpect(
							MockMvcResultMatchers.jsonPath("$.code").value(200))
					.andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void udateDepartment() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.put("/v1/department/1")
							.characterEncoding("UTF-8")
							.accept(MediaType.APPLICATION_JSON)
							.param("name", "testname")
							.param("openPositions", "1"))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andExpect(
							MockMvcResultMatchers.jsonPath("$.code").value(200))
					.andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	@Rollback(true)
	public void removeDepartment() {
		try {
			mockMvc.perform(
					MockMvcRequestBuilders.delete("/v1/department/1")
							.characterEncoding("UTF-8")
							.accept(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().is(200))
					.andExpect(
							MockMvcResultMatchers.jsonPath("$.code").value(200))
					.andDo(MockMvcResultHandlers.print()).andReturn();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
