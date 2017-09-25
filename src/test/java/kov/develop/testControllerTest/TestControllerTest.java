package kov.develop.testControllerTest;

import kov.develop.config.*;
import kov.develop.model.User;
import kov.develop.service.UserService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static kov.develop.utils.JacksonObjectMapper.getMapper;
import static kov.develop.utils.UserTestData.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class, DataConfig.class, InitConfig.class})
@Sql(scripts = {"classpath:db/schema.sql", "classpath:db/data.sql"}, config = @SqlConfig(encoding = "UTF-8"))
public class TestControllerTest {

    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private static final String REST_URL = "/user";

    @Before
    public void setup() {
        DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
        this.mockMvc = builder.build();
    }



    @Autowired
    private UserService service;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(getMapper().writeValueAsString(USERS)))
                .andDo(print());
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(get(REST_URL + "/2"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json(getMapper().writeValueAsString(USER_2)))
                .andDo(print());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + "/2"))
                .andExpect(status().isOk())
                .andDo(print());
        Assert.assertArrayEquals(new User[] {USER_1, USER_3}, service.getAll().toArray());
    }

    @Test
    public void testCreate() throws Exception {
        User created = getCreated();
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("firstName", "NoName")
                .param("lastName", "Dontnow")
                .param("birthday", "1930-02-02")
                .param("login","smth")
                .param("password", "qwerty")
                .param("info", "test")
                .param("adress", "8080"))
                .andExpect(status().isOk())
                .andDo(print());
        Assert.assertArrayEquals(new User[] {USER_1, USER_2, USER_3, created}, service.getAll().toArray());
    }

    @Test
    public void testUpdate() throws Exception {
        User updated = getUpdated();
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("id", "1")
                .param("firstName", "Andrey")
                .param("lastName", "Kovalenko")
                .param("birthday", "1977-03-17")
                .param("login","kowi")
                .param("password", "lightpass")
                .param("info", "another info")
                .param("adress", "Nsk"))
                .andExpect(status().isOk())
                .andDo(print());
        Assert.assertArrayEquals(new User[] { USER_2, USER_3, updated }, service.getAll().toArray());
    }
}

