package local.tyler.africanmarketplace.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import local.tyler.africanmarketplace.models.Item;
import local.tyler.africanmarketplace.services.CategoryService;
import local.tyler.africanmarketplace.services.CurrencyService;
import local.tyler.africanmarketplace.services.ItemService;
import local.tyler.africanmarketplace.services.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
class ItemControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private UserService userService;

    @Autowired
    private CurrencyService currencyService;

    @Autowired
    private CategoryService categoryService;

    private List<Item> items;

    @BeforeEach
    void setUp() {
        items = new ArrayList<>();
        Item item = new Item("here", "name", "desc", 12.21, userService.findByName("user"));
        item.setCurrency(currencyService.getCurrencyByCode("dzd"));
        item.setCategory(categoryService.getCategoryByType("Electronics"));
        items.add(item);
        Item item1 = new Item("there1", "name1", "desck", 120.21, userService.findByName("user"));
        item.setCurrency(currencyService.getCurrencyByCode("aoa"));
        item.setCategory(categoryService.getCategoryByType("Other"));
        items.add(item1);

        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .apply(SecurityMockMvcConfigurers.springSecurity())
                .build();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void listAllItems() throws Exception {
        String url = "/items/items";

        Mockito.when(itemService.getAllItems()).thenReturn(items);

        RequestBuilder rb = MockMvcRequestBuilders.get(url).accept((MediaType.APPLICATION_JSON));

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(items);

        assertEquals(er, tr);
    }

    @Test
    void getItemById() {
    }

    @Test
    void getItemsByName() {
    }

    @Test
    void getItemsByLikeName() {
    }

    @Test
    void listUserItems() {
    }

    @Test
    void listItemsByCurrency() {
    }

    @Test
    void addItem() {
    }

    @Test
    void updateItem() {
    }

    @Test
    void deleteItemById() {
    }
}