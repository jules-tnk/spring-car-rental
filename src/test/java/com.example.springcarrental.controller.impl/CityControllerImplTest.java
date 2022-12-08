package com.example.springcarrental.controller.impl;

import com.example.springcarrental.mapper.CityMapper;
import com.example.springcarrental.model.City;
import com.example.springcarrental.service.CityService;
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
public class CityControllerImplTest {
    //TODO: create the data Test generator class CityBuilder
    private static final String ENDPOINT_URL = "/citys";
    @MockBean
    private ReferenceMapper referenceMapper;
    @InjectMocks
    private CityControllerImpl cityController;
    @MockBean
    private CityService cityService;
    @MockBean
    private CityMapper cityMapper;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.cityController).build();
    }

    @Test
    public void getAll() throws Exception {
        Mockito.when(cityMapper.asDTOList(ArgumentMatchers.any())).thenReturn(CityBuilder.getListDTO());

        Mockito.when(cityService.findAll()).thenReturn(CityBuilder.getListEntities());
        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));

    }

    @Test
    public void getById() throws Exception {
        Mockito.when(cityMapper.asDTO(ArgumentMatchers.any())).thenReturn(CityBuilder.getDTO());

        Mockito.when(cityService.findById(ArgumentMatchers.anyLong())).thenReturn(java.util.Optional.of(CityBuilder.getEntity()));

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(cityService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(cityService);
    }

    @Test
    public void save() throws Exception {
        Mockito.when(cityMapper.asEntity(ArgumentMatchers.any())).thenReturn(CityBuilder.getEntity());
        Mockito.when(cityService.save(ArgumentMatchers.any(City.class))).thenReturn(CityBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CityBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Mockito.verify(cityService, Mockito.times(1)).save(ArgumentMatchers.any(City.class));
        Mockito.verifyNoMoreInteractions(cityService);
    }

    @Test
    public void update() throws Exception {
        Mockito.when(cityMapper.asEntity(ArgumentMatchers.any())).thenReturn(CityBuilder.getEntity());
        Mockito.when(cityService.update(ArgumentMatchers.any(), ArgumentMatchers.anyLong())).thenReturn(CityBuilder.getEntity());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON_UTF8)
                                .content(CustomUtils.asJsonString(CityBuilder.getDTO())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(cityService, Mockito.times(1)).update(ArgumentMatchers.any(City.class), ArgumentMatchers.anyLong());
        Mockito.verifyNoMoreInteractions(cityService);
    }

    @Test
    public void delete() throws Exception {
        Mockito.doNothing().when(cityService).deleteById(ArgumentMatchers.anyLong());
        mockMvc.perform(
                        MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(cityService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(cityService);
    }