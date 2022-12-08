package com.example.springcarrental.controller.impl;

import com.example.springcarrental.mapper.AgentMapper;
import com.example.springcarrental.model.Agent;
import com.example.springcarrental.service.AgentService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class AgentControllerImplTest {
    //TODO: create the data Test generator class AgentBuilder
    private static final String ENDPOINT_URL = "/agents";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgentControllerImpl agentController;
    @MockBean
    private AgentService agentService;
    @MockBean
    private AgentMapper agentMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.agentController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(agentMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgentBuilder.getListDTO());

        Mockito.when(agentService.findAll()).thenReturn(AgentBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(agentMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgentBuilder.getDTO());

        Mockito.when(agentService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgentBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(agentService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(agentService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(agentMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgentBuilder.getEntity());
        Mockito.when(agentService.save(ArgumentMatchers.any(Agent.class))).thenReturn(AgentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(AgentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(agentService, Mockito.times(1)).save(ArgumentMatchers.any(Agent.class));
        Mockito.verifyNoMoreInteractions(agentService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(agentMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgentBuilder.getEntity());
        Mockito.when(agentService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgentBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(AgentBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agentService, Mockito.times(1)).update(ArgumentMatchers.any(Agent.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(agentService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(agentService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agentService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(agentService);
    }