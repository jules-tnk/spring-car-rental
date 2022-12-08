package com.example.springcarrental.controller.impl;

import com.example.springcarrental.mapper.AgencyMapper;
import com.example.springcarrental.model.Agency;
import com.example.springcarrental.service.AgencyService;
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
public class AgencyControllerImplTest {
    //TODO: create the data Test generator class AgencyBuilder
    private static final String ENDPOINT_URL = "/agencys";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private AgencyControllerImpl agencyController;
    @MockBean
    private AgencyService agencyService;
    @MockBean
    private AgencyMapper agencyMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.agencyController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(agencyMapper.asDTOList(ArgumentMatchers.any())).thenReturn(AgencyBuilder.getListDTO());

        Mockito.when(agencyService.findAll()).thenReturn(AgencyBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(agencyMapper.asDTO(ArgumentMatchers.any())).thenReturn(AgencyBuilder.getDTO());

        Mockito.when(agencyService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(AgencyBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(agencyService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(agencyService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(agencyMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgencyBuilder.getEntity());
        Mockito.when(agencyService.save(ArgumentMatchers.any(Agency.class))).thenReturn(AgencyBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(AgencyBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(agencyService, Mockito.times(1)).save(ArgumentMatchers.any(Agency.class));
        Mockito.verifyNoMoreInteractions(agencyService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(agencyMapper.asEntity(ArgumentMatchers.any())).thenReturn(AgencyBuilder.getEntity());
        Mockito.when(agencyService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(AgencyBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(AgencyBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agencyService, Mockito.times(1)).update(ArgumentMatchers.any(Agency.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(agencyService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(agencyService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(agencyService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(agencyService);
    }